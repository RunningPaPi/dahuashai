/**
* COPYRIGHT. Foresee Inc. ALL RIGHTS RESERVED.
* Project: dc-api-gateway-common
* Author: wushyue@gmail.com
*/

package com.artqiyi.dahuashai.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.artqiyi.dahuashai.common.Constants;
import com.artqiyi.dahuashai.common.SecretException;


/**
 * 安全相关的util
 * 
 * @author woosam
 *
 */
public class SecurityUtils {
    /**
     * 给请求签名。
     * 
     * @param params
     *            所有字符型的请求参数
     * @param secret
     *            签名密钥
     * @param signMethod
     *            signMethod 签名方法，目前支持：空（老md5)、md5, hmac_md5三种
     * @return 签名
     */
    public static String signRequest(Map<String, String> params, String secret, String signMethod) throws IOException {
        return signRequest(params, null, secret, signMethod);
    }

    /**
     * 给请求签名。
     * 
     * @param params
     *            所有字符型的请求参数
     * @param body
     *            请求主体内容
     * @param secret
     *            签名密钥
     * @param signMethod
     *            签名方法，目前支持：空（老md5)、md5, hmac_md5三种
     * @return 签名
     */
    public static String signRequest(Map<String, String> params, String body, String secret, String signMethod)
            throws IOException {
        // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
            query.append(secret);
        }
        for (String key : keys) {
            String value = params.get(key);
            if (StringUtils.areNotEmpty(key, value)) {
                query.append(key).append(value);
            }
        }

        // 第三步：把请求主体拼接在参数后面
        if (body != null) {
            query.append(body);
        }

        // 第四步：使用MD5/HMAC加密
        byte[] bytes;
        if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {
            bytes = encryptHMAC(query.toString(), secret);
        } else if (Constants.SIGN_METHOD_HMAC_SHA256.equals(signMethod)) {
            bytes = encryptHMACSHA256(query.toString(), secret);
        } else {
            query.append(secret);
            bytes = encryptMD5(query.toString());
        }

        // 第五步：把二进制转化为大写的十六进制
        return byte2hex(bytes);
    }

    /**
     * 给带body体的请求签名，适用于批量API的请求签名。
     * 
     * @param params
     *            所有字符型的请求参数
     * @param body
     *            请求body体
     * @param secret
     *            签名密钥
     * @param isHmac
     *            是否为HMAC方式加密
     * @return 签名
     */
    public static String signTopRequestWithBody(Map<String, String> params, String body, String secret,
            String signMethod) throws IOException {
        return signRequest(params, body, secret, signMethod);
    }

    private static byte[] encryptHMACSHA256(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constants.CHARSET_UTF8), "HmacSHA256");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(Constants.CHARSET_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    private static byte[] encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constants.CHARSET_UTF8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(Constants.CHARSET_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 对字符串采用UTF-8编码后，用MD5进行摘要。
     */
    public static byte[] encryptMD5(String data) throws IOException {
        return encryptMD5(data.getBytes(Constants.CHARSET_UTF8));
    }

    /**
     * 对字节流进行MD5摘要。
     */
    public static byte[] encryptMD5(byte[] data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 把字节流转换为十六进制表示方式。
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * 清除字典中值为空的项。
     * 
     * @param <V>
     *            泛型
     * @param map
     *            待清除的字典
     * @return 清除后的字典
     */
    public static <V> Map<String, V> cleanupMap(Map<String, V> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, V> result = new HashMap<String, V>(map.size());
        Set<Entry<String, V>> entries = map.entrySet();

        for (Entry<String, V> entry : entries) {
            if (entry.getValue() != null) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    /**
     * . BASE64 编码(byte[]).
     *
     * @param src
     *            byte[] inputed string
     * @return String returned string
     */
    public static String base64Encode(byte[] src) {
        try {
            return base64Encode(src, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * . BASE64 编码(byte[]).
     *
     * @param src
     *            byte[] inputed string
     * @param charsetName
     * @return String returned string
     * @throws UnsupportedEncodingException
     */
    public static String base64Encode(byte[] src, String charsetName) throws UnsupportedEncodingException {
        byte[] res = Base64.encodeToByte(src, false);
        return (src != null ? new String(res, charsetName) : null);
    }

    /**
     * @see #hmacMD5Encrypt(String, byte[])
     * 
     * @param encryptText
     *            被签名的字符串
     * @param encryptKey
     *            密钥
     * @param compressLen压缩长度
     * @return
     * @throws Exception
     */
    public static String hmacMD5EncryptToBase64(String encryptText, byte[] encryptKey, int compressLen)
            throws SecretException {
        try {
            return base64Encode(compress(hmacMD5Encrypt(encryptText, encryptKey), compressLen));
        } catch (Exception e) {
            throw new SecretException(e);
        }
    }

    /**
     * @see #hmacMD5Encrypt(String, byte[])
     * 
     * @param encryptText
     *            被签名的字符串
     * @param encryptKey
     *            密钥
     * @return
     * @throws Exception
     */
    public static String hmacMD5EncryptToBase64(String encryptText, byte[] encryptKey) throws SecretException {
        try {
            return base64Encode(hmacMD5Encrypt(encryptText, encryptKey));
        } catch (Exception e) {
            throw new SecretException(e);
        }
    }

    /**
     * 使用 HMAC-MD5 签名方法对对encryptText进行签名
     * 
     * @param encryptText
     *            被签名的字符串
     * @param encryptKey
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] hmacMD5Encrypt(String encryptText, byte[] encryptKey) throws Exception {
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(encryptKey, Constants.MAC_HMAC_MD5);
        // 生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(Constants.MAC_HMAC_MD5);
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(Constants.CHARSET_UTF8);
        // 完成 Mac 操作
        return mac.doFinal(text);
    }

    private static boolean isLetterOrDigit(char x) {
        if (0 <= x && x <= 127) {
            return true;
        }
        return false;
    }

    private static byte[] compress(byte[] input, int toLength) {
        if (toLength < 0) {
            return null;
        }
        byte[] output = new byte[toLength];
        for (int i = 0; i < output.length; i++) {
            output[i] = 0;
        }

        for (int i = 0; i < input.length; i++) {
            int index_output = i % toLength;
            output[index_output] ^= input[i];
        }

        return output;
    }

    private static int getRandInt() {

        Random random = new Random();

        return random.nextInt(10);

    }

    /**
     * 
     * 生成App Key
     * 
     * @param
     * @return String
     */
    public static String genAppKey() {

        StringBuffer randomValidateCode = new StringBuffer();

        for (int j = 0; j < 8; j++) {
            int one = getRandInt();// 获得一个随机数
            if (j == 0) {
                randomValidateCode.append(one).append("#");// 添加随机数和分隔符
            } else if (j > 0) {
                String[] all = randomValidateCode.toString().split("#");// 分割成字符串数组
                // 调用是否重复方法teseEquals
                if (teseEquals(all, one, randomValidateCode) == 1) {
                    randomValidateCode.append(one).append("#");// 如果不重复就添加随机数和分隔符
                } else {
                    j--;// 如果重复的话将j-1
                }
            }
        }
        // 对得到的8位随机数用分隔符进行分割
        String[] result = randomValidateCode.toString().split("#");
        StringBuffer res = new StringBuffer();
        for (int r = 0; r < result.length; r++) {
            res.append(result[r]);
        }
        return res.toString();
    }

    // 测试是否重复
    private static int teseEquals(String[] all, int one, StringBuffer randomValidateCode) {
        for (int i = 0; i < all.length; i++) {
            if (one == Integer.parseInt(all[i])) {
                return 0;// 重复就返回0
            }
        }
        return 1;// 不重复返回1
    }

    /**
     * 
     * 生成Secret Key
     * 
     * @param @return String @exception
     */
    public static String genAppSecret() {
        String secret = UUID.randomUUID().toString().replaceAll("-", "");

        return secret;
    }
}
