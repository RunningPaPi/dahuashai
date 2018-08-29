package com.artqiyi.dahuashai.aspect;


import com.alibaba.fastjson.JSONObject;
import com.artqiyi.dahuashai.common.constant.MsgConstant;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.constant.ResponseCodeConstant;
import com.artqiyi.dahuashai.common.constant.SystemConfig;
import com.artqiyi.dahuashai.common.util.SignUtil;
import com.artqiyi.dahuashai.redis.RedisClient;
import com.artqiyi.dahuashai.response.UserResponse;
import com.artqiyi.dahuashai.user.service.IUserService;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 权限验证拦截器
 * author: chencunjun
 * date:2018/4/17.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final SystemConfig sysConfig = ConfigCache.getOrCreate(SystemConfig.class);
    private static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private IUserService userService;

    private static String   SIGN="sign";   //签名参数名称
    private static String   TOKEN="token"; //身份令牌
    private static String   CURRENT_TIME="time"; //当前时间
    private static long    SING_OVERTIME=300*1000; //签名过期时间

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
            //没有声明需要权限,或者声明不验证权限
            if(authPassport == null){
                return true;
            }

            //验证数据签名(硬件设备推动接口签名验证)
            if(authPassport.checkPhpSign()){
                Map pmap=getParameterMap(request);
                if(!pmap.containsKey("sign") ){
                    //返回参数错误提示信息
                    returnErrorMessage(response, MsgConstant.NO_AUTH_PARAM, ResponseCodeConstant.NO_AUTH,null);
                    logger.info("=======参数有误，系统拦截.........");
                    return false;
                }
                String sign=String.valueOf(pmap.get("sign"));
                pmap.remove("sign");
                pmap=SignUtil.sortMapByKey(pmap);
                if(!sign.equals(SignUtil.makeSign(pmap))){
                    //返回应用签名错误提示
                    returnErrorMessage(response, MsgConstant.APP_SIGN_FAIL, ResponseCodeConstant.NO_AUTH,null);
                    logger.info("======="+sign+"签名验证失败，系统拦截........."+SignUtil.makeSign(pmap));
                    return false;
                }

            }
            if(!authPassport.checkSign() && !authPassport.checkLogin()){
                return true;

            }

            Map paramMap=new HashedMap();
            Cookie[] cookies=request.getCookies();
            if(cookies==null){
                //返回参数错误提示信息
                returnErrorMessage(response, MsgConstant.NO_AUTH_PARAM, ResponseCodeConstant.NO_AUTH,null);
                logger.info("======="+request.getPathInfo()+"数据签名有误，系统拦截.........");
                return false;
            }
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(TOKEN) || cookie.getName().equals(CURRENT_TIME) || cookie.getName().equals(SIGN)){
                    paramMap.put(cookie.getName(), cookie.getValue());
                }
            }

            if(!paramMap.containsKey(TOKEN) || !paramMap.containsKey(CURRENT_TIME) || !paramMap.containsKey(SIGN)){
                //返回参数错误提示信息
                returnErrorMessage(response, MsgConstant.NO_AUTH_PARAM, ResponseCodeConstant.NO_AUTH,null);
                logger.info("=======参数有误，系统拦截.........");
                return false;
            }
            String token=paramMap.get(TOKEN).toString();
            String time=paramMap.get(CURRENT_TIME).toString();
            String appSign=paramMap.get(SIGN).toString();
            paramMap.put("platform", sysConfig.getAppPlatform());
//            paramMap.put("appKey",Constants.APP_KEY);
            long currentTime=System.currentTimeMillis();//当前时间毫秒数
            if(isNumeric(time)){
                long signTime=Long.parseLong(time);
                long stime=currentTime-signTime;
                if(stime>SING_OVERTIME){
                    //返回参数错误提示信息
                    returnErrorMessage(response, MsgConstant.APP_SIGN_OVERTIME, ResponseCodeConstant.NO_AUTH,null);
                    logger.info("=======签名已过期，系统拦截.........");
                    return false;
                }
            }else{
                //返回参数错误提示信息
                returnErrorMessage(response, MsgConstant.NO_AUTH_PARAM, ResponseCodeConstant.NO_AUTH,null);
                logger.info("=======时间参数有误，系统拦截.........");
                return false;
            }

            //验证是否登录
            if(authPassport.checkLogin()){
                if(!redisClient.hExists(RedisFiledConstant.FILED_USER,token) && !userService.hasLogin(token)){
                    //返回登录状态失效提示
                    returnErrorMessage(response, MsgConstant.LOGIN_STATUS_INVAID, ResponseCodeConstant.NO_AUTH,null);
                    logger.info("======="+token+"登录状态失效，系统拦截.........");
                    return false;
                }
            }
            if(authPassport.checkSign()){
                paramMap.remove(SIGN);
                if(!appSign.equals(SignUtil.getSign(paramMap))){
                    //返回应用签名错误提示
                    returnErrorMessage(response, MsgConstant.APP_SIGN_FAIL, ResponseCodeConstant.NO_AUTH,null);
                    logger.info("======="+request.getPathInfo()+"，"+appSign+"数据签名有误，系统拦截.........");
                    return false;
                }
            }


        } else{
            return true;
        }
        logger.info("=======验证成功，系统放行.........");
        return true;

    }

    /**
     * 封装返回结果
     * @param response
     * @param errorMessage
     * @param responseCode
     * @param data
     * @throws IOException
     */
    private void returnErrorMessage(HttpServletResponse response, String errorMessage,String responseCode,Object data) throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        UserResponse responseVo=new UserResponse();
        responseVo.setResult(data);
        responseVo.setMsg(errorMessage);
        responseVo.setCode(responseCode);
        JSONObject jb= (JSONObject) JSONObject.toJSON(responseVo);
        out.print(jb.toString());
        out.flush();
    }

    /**
     * 判断是否存在某参数
     * @param request
     * @param paramName
     * @return
     */
    private boolean hasParam(HttpServletRequest request,String paramName){
        Enumeration<String> e = request.getParameterNames();// 所有的请求参数名
        //表单输入域的名称与JavaBean中的属性名称一致:使用内省，方便扩张。
        while (e.hasMoreElements()) {
            String pname = (String) e.nextElement();
               if(paramName.equals(pname)){
                   return true;
               }
        }
        return false;
    }

    /**
     * 判断数字是全为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 请求参数转map
     * @param request
     * @return
     */
    public static Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
}
