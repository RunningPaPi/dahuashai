/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: tanqiu-service
 * Author: author  wushyue@gmail.com
 * Create On: May 2, 2018 6:47:57 PM
 * Modify On: May 2, 2018 6:47:57 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.websocket.client;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.artqiyi.dahuashai.websocket.MessageHandler;
import com.artqiyi.dahuashai.websocket.marshalling.SampleConfigurator;
import com.artqiyi.dahuashai.websocket.marshalling.SampleDecoder;
import com.artqiyi.dahuashai.websocket.marshalling.SimpleEncoder;


/** 
 * WebSocket客户端
 *
 * @author wushuang
 * @since 2018-05-02
 */
@ClientEndpoint(
        configurator=SampleConfigurator.class,
        decoders={SampleDecoder.class},
        encoders={SimpleEncoder.class},
        subprotocols={})
@Component
public class DahuashaiWebSocketClient {
	private static Logger logger = LoggerFactory.getLogger(DahuashaiWebSocketClient.class);

	private MessageHandler messageHandler;

    private Session session;
    private int count = 0;
    
    public DahuashaiWebSocketClient() {
    	super();
    }
    
	public DahuashaiWebSocketClient(String wsUri) {
		super();
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();	// 获得WebSocketContainer
			this.session = container.connectToServer(this, new URI(wsUri));	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

    @OnOpen
    public void open(Session session){
        logger.info("Client WebSocket is opening...");
        this.session = session;
        sendMessage("onOpen hello benny onOpen");
    }

    @OnMessage
    public void onMessage(String message){
        logger.info("Server send message: " + message);
        if (this.messageHandler != null) {
        	this.messageHandler.handleMessage(message);
        }
        System.out.println("Server send message: " + message);
    }

    @OnClose
    public void onClose(){
        logger.info("Websocket closed");
    }


    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

    public void send(String message){
        this.session.getAsyncRemote().sendText(message);
    }

    public void close() throws Exception{
        if(this.session.isOpen()){
            this.session.close();
        }
    }
    
	public void sendMessage(String message){
		try {
			this.session.getBasicRemote().sendText(message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				this.session.getBasicRemote().flushBatch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }
}
