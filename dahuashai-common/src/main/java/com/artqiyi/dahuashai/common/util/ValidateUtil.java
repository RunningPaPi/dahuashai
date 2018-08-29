package com.artqiyi.dahuashai.common.util;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: majinghui <ai.xmg.go@gmail.com>
 * Create On: 2018.05.18
 */
public class ValidateUtil {

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     */
    public static boolean isChinaPhoneNumber(String phone) {
        return match("^(((19[0-9])|(16[0-9])|(13[0-9])|(14[5,7,9])|(15[0-9])|(18[0-9])|(17[0-9]))+\\d{8})?$", phone);
    }

    /**
     * 判断是否是邮箱
     */
    public static boolean isEmail(String email) {
        return match("^[a-zA-Z0-9_.-]{1,50}@[a-zA-Z0-9-]{1,50}(\\.[a-zA-Z0-9-]+){0,50}\\.[a-zA-Z0-9]{2,6}$", email);
    }

    /**
     * 是否是纯数字
     */
    public static boolean isNumber(String s) {
        return match("^[0-9]*$", s);
    }



    public static boolean match(String regex, String s) {
        if (isBlank(s)) {
            return false;
        }
        return s.matches(regex);
    }

    /**
     * 时间正确性校验
     * @return
     */
    public static boolean isTime(String time){
        return match("^([0-9]|([0-1][0-9])|([2][0-3])):[0-5][0-9]",time);
    }

    private static boolean isBlank(String s) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(isChinaPhoneNumber("15515115151"));
//
//        System.out.println(isEmail("qq@s.cn"));

        System.out.println(isNumber("111"));
    }
}
