/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: tanqiu-service
 * Author: author  wushyue@gmail.com
 * Create On: May 2, 2018 4:33:35 PM
 * Modify On: May 2, 2018 4:33:35 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.websocket;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * 连接握手拦截器
 *
 * @author wushuang
 * @since 2018-05-02
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
	private static Logger logger = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.socket.server.HandshakeInterceptor#afterHandshake(org
	 * .springframework.http.server.ServerHttpRequest,
	 * org.springframework.http.server.ServerHttpResponse,
	 * org.springframework.web.socket.WebSocketHandler, java.lang.Exception)
	 */
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler webSocketHandler, Exception exception) {
		
		logger.info("After Handshake");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.socket.server.HandshakeInterceptor#beforeHandshake(
	 * org.springframework.http.server.ServerHttpRequest,
	 * org.springframework.http.server.ServerHttpResponse,
	 * org.springframework.web.socket.WebSocketHandler, java.util.Map)
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
		logger.info("before Handshake");  
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			Cookie[] cookies=servletRequest.getServletRequest().getCookies();
			if(cookies!=null){
				for(Cookie cookie:cookies){
					attributes.put(cookie.getName(), cookie.getValue());
				}
			}
			Map<String, Object>  map=((ServletServerHttpRequest) request).getServletRequest().getParameterMap();
			for(Map.Entry<String, Object> entry: map.entrySet())
			{
				String[] values=(String[])entry.getValue();
				attributes.put(entry.getKey(), values[0]);
			}
//			HttpSession session = servletRequest.getServletRequest().getSession(false);
//			if (session != null) {
//				// 使用userName区分WebSocketHandler，以便定向发送消息
//				String userName = (String) session.getAttribute("WEBSOCKET_USERNAME");
//				if (userName == null) {
//					userName = "system-" + session.getId();
//				}
//				attributes.put("WEBSOCKET_USERNAME", servletRequest.getServletRequest().getParameter("userName"));
//				attributes.put("WEBSOCKET_GROUP", servletRequest.getServletRequest().getParameter("group"));
//			}
		}
		return true;
	}

	private static String unicodeToCn(String unicode) {
		/** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
		String[] strs = unicode.split("\\\\u");
		String returnStr = "";
		// 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
		for (int i = 1; i < strs.length; i++) {
			returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
		}
		return returnStr;
	}

}
