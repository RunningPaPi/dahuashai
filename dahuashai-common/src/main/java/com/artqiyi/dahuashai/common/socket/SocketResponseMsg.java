package com.artqiyi.dahuashai.common.socket;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/8
 * Modify On: 2018/5/8 by chencunjun
 */
/**
 * socket服务端响应信息载体
 */
public class SocketResponseMsg {
    private String code;      //操作
    private String msg;           //响应提示信息
    private Object result;          //响应数据
    private boolean isSuccess;  //是否成功

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "SocketResponseMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                ", success=" + isSuccess +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
