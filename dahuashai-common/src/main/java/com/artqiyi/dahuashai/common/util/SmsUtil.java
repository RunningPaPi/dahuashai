package com.artqiyi.dahuashai.common.util;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/16
 * Modify On: 2018/5/16 by chencunjun
 */

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 腾讯云信息发送工具类
 *
 */
public class SmsUtil {
    private static Logger log = LoggerFactory.getLogger(SmsUtil.class);
    private static int APP_ID= 1400092070;   //应用ID
    private static String APP_KEY="41602ed68e3892903f536936973d15c2"; //应用key
    private static int MODEL_ID=122273; //短信模板ID
    private static String SMS_SIGN="趣电玩";//短信签名(需申请认证通过)
    private static String COUNTRY_CODE="86"; //国家编码

    /**
     * 发送单条信息
     * @param phone
     * @param content
     * @return
     */
    public static boolean sendSingeMsg(String phone,String content){
        try {
            SmsSingleSender ssender = new SmsSingleSender(APP_ID, APP_KEY);
            SmsSingleSenderResult result = ssender.send(0, COUNTRY_CODE, phone,content, "", "");
            log.info("【短信验证码】 发送单条信息返回结果：SmsSingleSenderResult={}", result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 群发信息
     * @param phones
     * @param content
     * @return
     */
    public static boolean sendMassMsg(ArrayList<String> phones, String content){
        try {
            SmsMultiSender  msender  = new SmsMultiSender (APP_ID, APP_KEY);
            SmsMultiSenderResult  result = msender .send(0, COUNTRY_CODE, phones,content, "", "");
            log.info("【短信验证码】 群发信息返回结果：SmsSingleSenderResult={}", result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 根据手机验证码模板发送信息
     * @param validateCode
     * @param second
     * @param phone
     * @return
     */
    public static boolean sendValidateCodeByModel(String validateCode,String phone,int second) {
        SmsSingleSender sender = new SmsSingleSender(APP_ID,APP_KEY);
        ArrayList<String> params = new ArrayList<String>();
        params.add(validateCode);
        params.add(String.valueOf(second));
        SmsSingleSenderResult result;
        try {
            result = sender.sendWithParam(COUNTRY_CODE, phone, MODEL_ID, params, SMS_SIGN, "", "");
            log.info("【短信验证码】 根据手机验证码模板发送信息返回结果：SmsSingleSenderResult={}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 制定模板群发
     * @param phones
     * @param params
     * @param modelID
     * @return
     */
    public static boolean sendMassMsg(ArrayList<String> phones,ArrayList<String> params,int modelID){
        try {
            SmsMultiSender msender = new SmsMultiSender(APP_ID, APP_KEY);
            SmsMultiSenderResult result =  msender.sendWithParam(COUNTRY_CODE, phones,
                    modelID, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            log.info("【短信验证码】 制定模板群发返回结果：SmsSingleSenderResult={}", result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return true;
    }

}
