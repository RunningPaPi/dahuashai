/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-web
 * Author: author  wushyue@gmail.com
 * Create On: May 2, 2018 4:57:22 PM
 * Modify On: May 2, 2018 4:57:22 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.websocket.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.artqiyi.dahuashai.redis.RedisService;
import com.artqiyi.dahuashai.websocket.client.DahuashaiWebSocketClient;
import com.artqiyi.dahuashai.websocket.service.WebSocketClientService;
import com.artqiyi.dahuashai.websocket.service.WebSocketHandlerService;

/** 
 * WebSocket实例类
 *
 * @author wushuang
 * @since 2018-05-02
 */
@Controller
public class WebSocketController {
	private static Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    WebSocketHandlerService webSocketHandlerService;
    @Autowired
    WebSocketClientService webSocketClientService;

    @Autowired
    private RedisService redisService;
  
    @RequestMapping("/login")  
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String group = request.getParameter("group");
        logger.info(username + "登录");  
        HttpSession session = request.getSession();  
        session.setAttribute("WEBSOCKET_USERNAME", username);
        session.setAttribute("WEBSOCKET_GROUP", group);
        WebSocketContainer conmtainer = ContainerProvider.getWebSocketContainer();
        DahuashaiWebSocketClient client = new DahuashaiWebSocketClient();
        conmtainer.connectToServer(webSocketClientService,
                new URI("ws://localhost/websocket:8080/socketServer"));
//        webSocketClientService.createWebSocketClient("ws://jijiatmatm.3322.org:49080/websocket/socketServer");
//        webSocketClientService.send("hello");
        response.sendRedirect("websocket.jsp");  
    }  
  
    @RequestMapping("/send")  
    @ResponseBody  
    public String send(HttpServletRequest request) {  
        String username = request.getParameter("username");  
        //getHandler().sendMessageToUser(username, new TextMessage("你好，欢迎测试！！！！"));
        webSocketHandlerService.sendMessageToUser(username,new TextMessage("你好，欢迎测试！！！！"));
        return null;  
    } 
}
