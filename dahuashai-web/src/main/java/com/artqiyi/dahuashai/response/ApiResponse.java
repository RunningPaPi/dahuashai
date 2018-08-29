/**
* COPYRIGHT. Foresee Inc. ALL RIGHTS RESERVED.
* Project: dc-api-gateway-core
* Author: wushyue@gmail.com
*/

package com.artqiyi.dahuashai.response;

import java.io.Serializable;

/**
 * 响应类
 * 
 * @author wushuang
 *
 */
public abstract class ApiResponse implements Serializable {

    private static final long serialVersionUID = 6494470905599293299L;

    private String code;
    private String msg;

    private Object result; // API响应JSON或XML串
    

    public ApiResponse() {
    }
    /**
     * @param code
     * @param msg
     */
    public ApiResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }


	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public boolean isSuccess() {
        return this.code != null;
    }

}
