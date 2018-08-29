/**
* COPYRIGHT. Foresee Inc. ALL RIGHTS RESERVED.
* Project: dahuashai-common
* Author: wushyue@gmail.com
*/

package com.artqiyi.dahuashai.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 类或者接口作用描述
 * 
 * @author wushuang
 *
 */
public class ResponseBean {
    /**
     * 权限不足
     */
    public static String LESS_PERM = "lessperm";

    /**
     * 会话过期
     */
    public static String SESSION_OUT = "#AMM_SESSION_TIME_OUT#";

    /**
     * 成功
     */
    public static String SUCCESS = "success";

    /**
     * 警告
     */
    public static String WARN = "warn";

    /**
     * 出错
     */
    public static String FAILURE = "failure";

    /**
     * 操作结果状态位
     */
    private String optSta;

    /**
     * 描述
     */
    private String optTxt;

    /**
     * 返回数据
     */
    private Map<String, Object> responseData;

    public String getOptSta() {
        return optSta;
    }

    public void setOptSta(String optSta) {
        this.optSta = optSta;
    }

    public String getOptTxt() {
        return optTxt;
    }

    public void setOptTxt(String optTxt) {
        this.optTxt = optTxt;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }

    public void addObject(String key, Object obj) {
        if (key == null || key.trim().equals("")) {
            return;
        }
        if (this.responseData == null) {
            this.responseData = new HashMap<String, Object>();
        }
        this.responseData.put(key, obj);
    }
}
