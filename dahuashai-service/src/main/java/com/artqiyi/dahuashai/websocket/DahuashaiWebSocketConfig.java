/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: tanqiu-service
 * Author: author  wushyue@gmail.com
 * Create On: May 2, 2018 4:43:06 PM
 * Modify On: May 2, 2018 4:43:06 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.artqiyi.dahuashai.websocket.service.WebSocketHandlerService;

/**
 * WebSocket配置类
 *
 * @author wushuang
 * @since 2018-05-02
 */
@Configuration
//@EnableWebMvc//这个标注可以不加，如果有加，要extends WebMvcConfigurerAdapter
@EnableWebSocket
public class DahuashaiWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	@Autowired
	WebSocketHandlerService webSocketHandlerService;
//	@Autowired
//	private DahuashaiWebSocketHandler dahuashaiWebSocketHandler;

//	public static final String[] paths = {"/dhsWebsocket/"};


	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 1.注册WebSocket
		String websocket_url = "/websocket/socketServer"; // 设置websocket的地址
		registry.addHandler(webSocketHandlerService, websocket_url). // 注册Handler
				addInterceptors(new WebSocketHandshakeInterceptor()).setAllowedOrigins("*"); // 注册Interceptor

		// 2.注册SockJS，提供SockJS支持(主要是兼容ie8)
		String sockjs_url = "/sockjs/socketServer"; // 设置sockjs的地址
		registry.addHandler(webSocketHandlerService, sockjs_url)
				.addInterceptors(new WebSocketHandshakeInterceptor()).withSockJS();

//        String path = paths[0] + "{userId}/{group}";
//        registry.addHandler(dahuashaiWebSocketHandler, path).setAllowedOrigins("*");
    }

}
