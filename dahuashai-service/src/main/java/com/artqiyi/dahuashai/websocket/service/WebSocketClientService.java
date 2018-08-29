package com.artqiyi.dahuashai.websocket.service;

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
 * webSocket客户端
 */
@ClientEndpoint(
        configurator=SampleConfigurator.class,
        decoders={SampleDecoder.class},
        encoders={SimpleEncoder.class},
        subprotocols={})
@Component
public class WebSocketClientService {
    private static Logger logger = LoggerFactory.getLogger(WebSocketClientService.class);

    private MessageHandler messageHandler;

    private Session session;

    public WebSocketClientService() {
        super();
    }

    public WebSocketClientService(String wsUri) {
        super();
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();	// 获得WebSocketContainer
            this.session = container.connectToServer(this, new URI(wsUri));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建socket连接
     * @param wsUri
     */
    public void createWebSocketClient(String wsUri){
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

    /**
     * 新建连接会话
     * @param session
     */
    @OnOpen
    public void open(Session session){
        logger.info("Client WebSocket is opening...");
        this.session = session;
        sendMessage("onOpen hello benny onOpen");
    }

    /**
     * 接收服务端信息
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        logger.info("Server send message: " + message);
        if (this.messageHandler != null) {
            this.messageHandler.handleMessage(message);
        }
        System.out.println("Server send message: " + message);
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        logger.info("Websocket closed");
    }

    /**
     * 连接出现错误
     * @param session
     * @param t
     */
    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

    /**
     * 发送信息
     * @param message
     */
    public void send(String message){
        this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 关闭连接
     * @throws Exception
     */
    public void close() throws Exception{
        if(this.session.isOpen()){
            this.session.close();
        }
    }

    /**
     * 发送信息
     * @param message
     */
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
