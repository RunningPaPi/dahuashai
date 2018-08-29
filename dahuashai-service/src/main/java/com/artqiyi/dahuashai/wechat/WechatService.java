package com.artqiyi.dahuashai.wechat;

import com.alibaba.fastjson.JSON;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.common.util.UrlUtil;
import com.artqiyi.dahuashai.game.vo.PassAwardRecord;
import com.artqiyi.dahuashai.game.vo.WechatConfig;
import com.artqiyi.dahuashai.game.vo.WechatModelMsgVo;
import com.artqiyi.dahuashai.redis.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WechatService {
    private static Logger log = LoggerFactory.getLogger(WechatService.class);

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private WechatConfig wechatConfig;

    /**
     * 闯关通关获奖微信模板消息推送
     */
    public void sendModelMsg() {
        log.info("【微信模板消息推送】: 闯关通关获奖微信模板消息推送");
        try {
            taskExecutor.execute(() -> {
                String accessToken = getAccessToken();
                Map<String, PassAwardRecord> passAwardRecordMap = redisClient.hGetAll(RedisFiledConstant.BREAK_GAME_PASS_RECORD, PassAwardRecord.class);
                if (passAwardRecordMap != null || !passAwardRecordMap.isEmpty()) {
                    for (Map.Entry<String, PassAwardRecord> entry : passAwardRecordMap.entrySet()) {
                        PassAwardRecord records = entry.getValue();
                        String userId = entry.getKey();
                        String formId = redisClient.hGet(RedisFiledConstant.USER_FORM_ID, userId, String.class);
                        if (formId==null){
                            log.error("【微信模板消息推送】 userId={}没有找到formId,消息未发送",userId);
                            redisClient.hDel(RedisFiledConstant.BREAK_GAME_PASS_RECORD, userId);
                            continue;
                        }
                        WechatModelMsgVo wechatModelMsgVo = new WechatModelMsgVo();
                        wechatModelMsgVo.setPage(wechatConfig.getPage());
                        wechatModelMsgVo.setTemplate_id(wechatConfig.getTemplateId());
                        String openId = redisClient.hGet(RedisFiledConstant.USER_OPEN_ID, userId, String.class);
                        if (openId == null){
                            log.error("【微信模板消息推送】 userId={}没有找到openid,消息未发送",userId);
                            redisClient.hDel(RedisFiledConstant.BREAK_GAME_PASS_RECORD, userId);
                            continue;
                        }
                        wechatModelMsgVo.setTouser(openId);
                        wechatModelMsgVo.setForm_id(formId);
                        String rmb = null;
                        double rmbd = records.getAwardNum() / 100.0;
                        rmb = String.valueOf(rmbd);
                        if (rmbd % 1.0 == 0) {
                            rmb = String.valueOf((int) rmbd);
                        }
                        String date = DateUtil.formatDate(records.getLatestPassTime(), "yyyy年MM月dd日 HH:mm");
                        wechatModelMsgVo.put("keyword1", "大话骰闯关")
                                .put("keyword2", date)
                                .put("keyword3", "通关" + records.getPassTimes() + "次")
                                .put("keyword4", rmb + "元");
                        String jsonData = JSON.toJSONString(wechatModelMsgVo);
                        String result = UrlUtil.doPost(wechatConfig.getMsgSendUrl().replace("ACCESS_TOKEN", accessToken), jsonData);
                        Map mapResult = (Map) JSON.parse(result);

                        if (Integer.valueOf(0).equals(mapResult.get("errcode"))){
                            log.info("【微信模板消息推送】 userId={}微信模板消息推送成功,sendData={}",userId, jsonData);
                        }else{
                            redisClient.hDel(RedisFiledConstant.BREAK_GAME_PASS_RECORD, userId);
                            log.error("【微信模板消息推送】 userId={}微信模板消息推送失败，sendData={}, result={}",userId, jsonData, result);
                        }
                    }
                }

            });
        } catch (Exception e) {
            log.error("【微信模板消息推送】: 闯关通关获奖微信模板消息推送过程出错：Exception={},e={}", e.getMessage(),e);
        }

    }

    public String getAccessToken() {
        String s = UrlUtil.get(wechatConfig.getAccessTokenUrl().replace("APPID", wechatConfig.getAppid()).replace("APPSECRET", wechatConfig.getAppsecret()));
        Map getResult = (Map) JSON.parse(s);
        return (String) getResult.get("access_token");
    }

}
