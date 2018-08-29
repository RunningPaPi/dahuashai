/**
* COPYRIGHT. Foresee Inc. ALL RIGHTS RESERVED.
* Project: api-gateway-common
* Author: wushyue@gmail.com
*/

package com.artqiyi.dahuashai.common;

/**
 * 安全异常
 * 
 * @author woosam
 *
 */
public class SecretException extends RuntimeException {

    private static final long serialVersionUID = -8572451831540522020L;

    private String errCode;
    private String errMsg;

    public SecretException() {
        super();
    }

    public SecretException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecretException(String message) {
        super(message);
    }

    public SecretException(Throwable cause) {
        super(cause);
    }

    public SecretException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
