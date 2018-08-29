package com.artqiyi.dahuashai.aspect;

import java.lang.annotation.*;

/**
 * 权限验证拦截器
 * author: chencunjun
 * date:2018/4/17.
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPassport {
    boolean checkLogin() default true; //是否验证登录
    boolean checkSign()  default false;//是否验证数字签名
    boolean checkPhpSign() default false;//是否验证设备PHP服务端数字签名
}

