package com.artqiyi.dahuashai.common.util;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/25
 * Modify On: 2018/4/25 by chencunjun
 */

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密通用类
 */
public class MD5Util {
    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }

    /**
     * 7      * 使用md5的算法进行加密
     * 8
     */
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("MD5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        return fillMD5(md5code);
    }

    public static String fillMD5(String str) {
        return str.length() == 32? str:fillMD5("0" + str);
    }

    public static void main(String[] args){
        String token="0070037b-86cc-42b2-9dfa-f60b5aa23378";
        try {
            String sigin=MD5Util.md5(token+"12345678","dahuashai@artqiyi");
            System.out.print(sigin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
