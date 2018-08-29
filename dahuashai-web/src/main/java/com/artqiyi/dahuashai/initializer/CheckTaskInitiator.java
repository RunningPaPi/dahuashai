package com.artqiyi.dahuashai.initializer;

import com.artqiyi.dahuashai.payment.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/3
 * Modify On: 2018/5/3 by chencunjun
 */

/**
 * 初始化组合任务至redis缓存并设置定时
 * author: chencunjun
 * date:2018/4/17.
 */
@Component
@PropertySource("classpath:system.properties")
public class CheckTaskInitiator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PayService payService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent()==null) {//只在根容器启动事件进行，子容器不需要
            payService.initWithdrawOrderCheck();
        }
    }
}
