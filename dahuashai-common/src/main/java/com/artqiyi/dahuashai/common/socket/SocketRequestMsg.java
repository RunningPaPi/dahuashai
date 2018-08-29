package com.artqiyi.dahuashai.common.socket;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/8
 * Modify On: 2018/5/8 by chencunjun
 */

import com.alibaba.fastjson.JSON;
import com.artqiyi.dahuashai.common.util.JSONUtil;
import com.artqiyi.dahuashai.common.util.StringUtils;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * socket客户端信息载体
 */
public class SocketRequestMsg {
    private String code;//操作(相当于接口地址如登录：login)
    private String params; //参数(参数格式以&隔开如username=ccj&password=123)
    private String msg;    //信息
    private Map<String,Object> paramMap; //参数封装Map

    public SocketRequestMsg(String jsonStr) {
        try {
            Map map = (Map)JSON.parse(jsonStr);
            setMsg(map.get("msg").toString());
            setCode(map.get("code").toString());
            String params=map.get("params").toString();
            if (params.contains("&")) {
                setParams(params);
                String[] paramsArr = params.split("\\&");
                for (String param : paramsArr) {
                    if (StringUtils.isNotBlank(param)) {
                        String[] arr = param.split("\\=");
                        if (arr.length > 1) {
                            if (null == this.paramMap) {
                                this.paramMap = new HashedMap();
                            }
                            this.paramMap.put(arr[0], arr[1]);
                        }
                    }
                }
            }else{
                this.paramMap =  (Map)map.get("params");
            }
        }catch (Exception e){
            new Throwable("参数错误："+jsonStr);
        }

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public static void main(String[] args){
        String jsonStr="{\"code\":\"login\",\"msg\":\"login\",\"params\":{\"user\":\"ccj\",\"password\":\"123\"}}";
        SocketRequestMsg socketRequestMsg=new SocketRequestMsg(jsonStr);
        System.out.print(JSON.toJSON(socketRequestMsg));
    }

}
