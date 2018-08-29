/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-web
 * Author: author  wushyue@gmail.com
 * Create On: May 4, 2018 8:05:18 PM
 * Modify On: May 4, 2018 8:05:18 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.websocket;

import org.springframework.beans.factory.annotation.Autowired;

import com.artqiyi.dahuashai.redis.RedisService;
import com.artqiyi.dahuashai.websocket.client.DahuashaiWebSocketClient;

/** 
 * 类或接口作用描述 
 *
 * @author wushuang
 * @since 2018-05-04
 */
public class WebSocketClientTest {

	@Autowired
	private RedisService redisService;

	private static final String WS_URI = "ws://localhost:8080/websocket/socketServer"; 

    public static void  main(String[] args) throws InterruptedException{
    	DahuashaiWebSocketClient  client = new DahuashaiWebSocketClient(WS_URI);  
    	client.addMessageHandler(new MessageHandler() {
			@Override
			public void handleMessage(String message) {
				System.out.println("hanlder handle haha");
			}});

    	client.sendMessage("hahahahahahhah");

    }


	
	

}
