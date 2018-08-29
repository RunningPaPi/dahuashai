package com.artqiyi.dahuashai.common.util;

import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * 模板消息辅助类
 */
public class MessageHelper {

    private final static String regex = "\\{\\}";
    public static String generateByModel(String modelMsg, String... args) {
        Assert.isTrue(StringUtils.areNotEmpty(modelMsg), "模板不能为空");
        for (String arg : args) {
            modelMsg = modelMsg.replaceFirst(regex, arg);
        }
        return modelMsg;
    }

    public static String generateByModel(String modelMsg, int... args) {
        Assert.isTrue(StringUtils.areNotEmpty(modelMsg), "模板不能为空");
        for (int arg : args) {
            modelMsg = modelMsg.replaceFirst(regex, String.valueOf(arg));
        }
        return modelMsg;
    }

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        String modelMsg = "在{}年{}月{}日，获得奖励{}趣币";
        String s = generateByModel(modelMsg,time.getYear(),time.getMonth().getValue(),time.getDayOfMonth(),20);
        System.out.println(modelMsg);
        System.out.println(s);
    }
}
