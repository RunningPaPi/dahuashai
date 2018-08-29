package com.artqiyi.dahuashai.game;

import com.alibaba.fastjson.JSON;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.util.UrlUtil;
import com.artqiyi.dahuashai.game.vo.GameBoxErrEnum;
import com.artqiyi.dahuashai.game.vo.GameBoxForm;
import com.artqiyi.dahuashai.game.vo.GameBreakUserRecordsVo;
import com.artqiyi.dahuashai.redis.RedisClient;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class GameBoxService {
    private static Logger log = LoggerFactory.getLogger(GameBoxService.class);
    private static final String url_fight = "https://planet.stargame.top/platform/fight";
    private static final String url_match = "https://planet.stargame.top/platform/matching";
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    public void sendToGameBoxSystem(boolean isFight, Long userId, int uid, boolean isWin) {
        taskExecutor.execute(() -> {
            try {
                GameBoxForm form = new GameBoxForm();
                String openid = redisClient.hGet(RedisFiledConstant.USER_OPEN_ID, userId.toString(), String.class);
                form.setOpenid(openid);
                form.setUid(uid);
                form.setResult(isWin ? 1 : 0);
                String jsonForm = JSON.toJSONString(form);
                String url = null;
                if (isFight){
                    url = url_fight;
                }else {
                    url = url_match;
                }
                String s = UrlUtil.doPost(url, jsonForm);
                Map parse = (Map) JSON.parse(s);
                Integer errcode = MapUtils.getInteger(parse, "errcode");
                if (GameBoxErrEnum.SUCCESS.getCode() == errcode) {
                    log.info("【游戏盒子】 数据推送成功，sendData={}", jsonForm);
                } else {
                    log.error("【游戏盒子】 数据推送失败，sendData={}，errcode={}, errmsg={}", jsonForm, errcode, GameBoxErrEnum.getMsg(errcode));
                }
            } catch (Exception e) {
                log.error("【游戏盒子】 数据推送失败，{}，{}", e.getMessage(), e);
            }

        });
    }

    public static void main(String[] args) {
        GameBoxForm form = new GameBoxForm();
        form.setOpenid("5415fdsafas15d1f5as5");
        form.setUid(123);
        form.setResult(1);
        String jsonForm = JSON.toJSONString(form);
        String s = UrlUtil.doPost(url_match, jsonForm);
        Map parse = (Map) JSON.parse(s);
        Integer errcode = MapUtils.getInteger(parse, "errcode");
        if (GameBoxErrEnum.SUCCESS.getCode() == errcode) {
            log.info("【游戏盒子】 数据推送成功，sendData={}", jsonForm);
        } else {
            log.error("【游戏盒子】 数据推送失败，sendData={}，errcode={}, errmsg={}", jsonForm, errcode, GameBoxErrEnum.getMsg(errcode));
        }
    }
}
