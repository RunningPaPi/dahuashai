package com.artqiyi.dahuashai.common.constant;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/23
 * Modify On: 2018/4/23 by chencunjun
 */

/**
 * 响应编码
 */
public class ResponseCodeConstant {
     public static String SUCCESS="10000";    //请求成功
     public static String NO_AUTH="11000";    //权限验证失败
     public static String SERVICE_FAIL="10100";  //请求成功,业务逻辑处理失败
     public static String PARAM_FAIL="40000";  //请求参数格式有误
     public static String PARAM_ID_FAIL="40100";  //请求参数ID数据不存在
     public static String FAIL="50000";       //内部错误，请求失败

     public static String PAY_TOKEN_NOT_GET="40001";
     public static String PAY_PREPAY_ID_NOT_GET="40002";
     public static String PAY_PREPAY_GET_ERROR="40003";
     public static String PAY_PREPAY_GET_URI_ERROR="40004";
}
