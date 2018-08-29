package com.artqiyi.dahuashai.websocket;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import com.artqiyi.dahuashai.websocket.client.DahuashaiWebSocketClient;


public class AppMain {

	public static void main(String[] args) 
			throws Exception {
		// Auto-generated method stub
		WebSocketContainer conmtainer = ContainerProvider.getWebSocketContainer();
		DahuashaiWebSocketClient client = new DahuashaiWebSocketClient();
		conmtainer.connectToServer(client, 
				new URI("ws://localhost:8080/websocket/socketServer"));
		
		int turn = 0;
		while(turn++ < 10){
			client.send("send text: " + (char)(65 + turn));
			Thread.sleep(1000);
		}
		client.close();
		
	}

}
