/**
* COPYRIGHT. Foresee Inc. ALL RIGHTS RESERVED.
* Project: api-gateway-common
* Author: wushyue@gmail.com
*/

package com.artqiyi.dahuashai.common;

import org.aeonbits.owner.ConfigCache;

import com.artqiyi.dahuashai.common.constant.SystemConfig;

/**
 * 常量类
 * 
 * @author woosam
 *
 */
public abstract class Constants {
    private static final SystemConfig sysConfig = ConfigCache.getOrCreate(SystemConfig.class);
    public static final String APP_KEY = sysConfig.getAppSignKey(); //线上应用签名key
    public static final String PLATFORM = sysConfig.getAppPlatform(); //线上平台签名
    public static final String FORMAT = "format";
    public static final String METHOD = "method";
    public static final String TIMESTAMP = "timestamp";
    public static final String VERSION = "v";
    public static final String SIGN = "sign";
    public static final String SIGN_METHOD = "signMethod";
    
    public static final String DATE_TIMEZONE = "GMT+8";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /** JSON 应格式 */
    public static final String FORMAT_JSON = "json";
    /** XML 应格式 */
    public static final String FORMAT_XML = "xml";

    /** MD5签名方式 */
    public static final String SIGN_METHOD_MD5 = "md5";
    /** HMAC签名方式 */
    public static final String SIGN_METHOD_HMAC = "hmac";
    /** HMAC-SHA256签名方式 */
    public static final String SIGN_METHOD_HMAC_SHA256 = "hmac-sha256";
    
    public static final String MAC_HMAC_MD5 = "HmacMD5";
    
    /** UTF-8字符集 **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /** HTTP请求相关 **/
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String CTYPE_FORM_DATA = "application/x-www-form-urlencoded";
    public static final String CTYPE_FILE_UPLOAD = "multipart/form-data";
    public static final String CTYPE_TEXT_XML = "text/xml";
    public static final String CTYPE_TEXT_PLAIN = "text/plain";
    public static final String CTYPE_APP_JSON = "application/json";
}
