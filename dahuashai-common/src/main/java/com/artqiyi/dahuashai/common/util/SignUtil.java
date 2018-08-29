package com.artqiyi.dahuashai.common.util;

import com.artqiyi.dahuashai.common.Constants;
import com.artqiyi.dahuashai.common.constant.SystemConfig;

import org.aeonbits.owner.ConfigCache;

import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/11
 * Modify On: 2018/5/11 by chencunjun
 */
public class SignUtil {
    private static final SystemConfig sysConfig = ConfigCache.getOrCreate(SystemConfig.class);

    public static String getSign(Map<String, String> map) throws NoSuchAlgorithmException {
        Map<String, String> sortMap = sortMapByKey(map);
        String sign = makeSign(sortMap);
        return sign;
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

    static class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
    }

    /**
     * 生成签名
     * @param map
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String makeSign(Map<String, String> map) throws NoSuchAlgorithmException {
        String mdkkeyStr = "";
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mdkkeyStr += entry.getKey() + entry.getValue();
            }
         //   System.err.println("加密前参数组合："+mdkkeyStr);
            mdkkeyStr = MD5Util.md5(mdkkeyStr);
       //     System.err.println("加密后参数组合："+mdkkeyStr);
         //   mdkkeyStr += Constants.APP_KEY;
        //    System.err.println("平台私钥："+sysConfig.getAppSignKey());
            mdkkeyStr += sysConfig.getAppSignKey();
            mdkkeyStr = MD5Util.md5(mdkkeyStr);
       //     System.err.println("最后签名："+mdkkeyStr);
        }

        return mdkkeyStr;
    }

    public static String getRequestSign(Map<String, String> params) {
        String signStr = null;
        try {
            signStr = getSign(params);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return signStr;
    }
}
