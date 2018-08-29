package com.artqiyi.dahuashai.websocket.service;


import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.socket.SocketConstant;
import com.artqiyi.dahuashai.common.socket.SocketRequestMsg;
import com.artqiyi.dahuashai.game.IGameBreakService;
import com.artqiyi.dahuashai.game.IGameFightService;
import com.artqiyi.dahuashai.redis.RedisClient;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;

/**
 * webSocket业务服务类
 */
@Component
public class WebSocketHandlerService extends TextWebSocketHandler {
    private static Logger logger = LoggerFactory.getLogger(WebSocketHandlerService.class);
    @Autowired
    private IGameBreakService gameBreakService;
    @Autowired
    private IGameFightService gameFightService;
    @Autowired
    private RedisClient redisClient;

    private WebSocketSessionService sessionService = WebSocketSessionService.INSTANCE;

    /**
     * 拦截客户端每次请求进行业务处理
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String username = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        // 获取提交过来的消息详情
        logger.info("收到用户 " + username + "的消息:" + message.getPayload());

        //业务处理
        String payload = message.getPayload();
        if (StringUtils.isNotBlank(payload)) {
            SocketRequestMsg requestMsg = new SocketRequestMsg(payload);
            String code = requestMsg.getCode();
            Map paramMap = requestMsg.getParamMap();
            switch (code) {
                /*=============================大话骰闯关游戏socket相关操作=========================================*/
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_BEGIN: //闯关游戏开始
                    gameBreakService.startGame(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "gameId"), MapUtils.getString(paramMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_CONTINUE: //继续闯关
                    gameBreakService.continueGame(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "gameId"), MapUtils.getString(paramMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_FOLLOW: //叫数（跟）
                    gameBreakService.follow(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "gameNo"), MapUtils.getString(paramMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_OPEN: //开骰
                    gameBreakService.open(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_GIVE_UP: //放弃比赛
                    gameBreakService.giveUp(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RECOVER: //比赛复活
                    gameBreakService.recover(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "gameId"), MapUtils.getString(paramMap, "gameNo"), MapUtils.getIntValue(paramMap, "round"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_EMOTICON: //表情
                    gameBreakService.emoticon(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "gameNo"), MapUtils.getString(paramMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_QUIT_WAIT: //退出等待
                    gameBreakService.quit(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "gameId"), MapUtils.getString(paramMap, "gameNo"), MapUtils.getBoolean(paramMap, "isBegin"));
                    break;
                /*=============================大话骰好友对战socket相关操作=========================================*/

                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM: //加入房间
                    gameFightService.enterRoom(MapUtils.getLong(paramMap, "userId"), MapUtils.getString(paramMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_EMOTICON: //表情
                    gameFightService.emoticon(MapUtils.getLong(paramMap, "userId"), MapUtils.getString(paramMap, "roomNo"), MapUtils.getString(paramMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_FOLLOW: //叫骰
                    gameFightService.follow(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "roomNo"), MapUtils.getString(paramMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_OPEN: //开骰
                    gameFightService.open(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_AGAIN: //再来一局
                    gameFightService.again(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_QUIT_WAIT: //放弃等待
                    gameFightService.quit(MapUtils.getLong(paramMap, "userId"), MapUtils.getString(paramMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_GIVE_UP: //认输
                    gameFightService.giveUp(MapUtils.getLong(paramMap, "userId"), MapUtils.getString(paramMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_START: //开始
                    gameFightService.start(MapUtils.getLong(paramMap, "userId"), MapUtils.getLong(paramMap, "againstId"), MapUtils.getString(paramMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_LEAVE: //离开
                    gameFightService.leave(MapUtils.getLong(paramMap, "userId"), MapUtils.getString(paramMap, "roomNo"));
                    break;


                default:
            }
        }
    }

    /**
     * 当新连接建立的时候, 连接成功时候,会触发页面上onOpen方法(第一次调用的时候才调用这个方法)
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String username = String.valueOf(session.getAttributes().get("WEBSOCKET_USERNAME"));
        String groupName = String.valueOf(session.getAttributes().get("WEBSOCKET_GROUP"));
        logger.info("session.getId()={}",session.getId());
        //如果建立过连接,关闭并删除旧的
        WebSocketSession oldSession = sessionService.getUser(username);
        if (oldSession != null && oldSession.isOpen()){
            oldSession.close();
        }
        //用户会话session信息保存
        sessionService.addUser(username, session);
        sessionService.addGroupUser(groupName, username, session);
        logger.info("用户 " + username + " Connection Established");
        logger.info("在线人数：{}", sessionService.getOnlineCount());
    }

    /**
     * 当连接关闭时被调用
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String username = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        String groupName = (String) session.getAttributes().get("WEBSOCKET_GROUP");
        logger.info("socket用户:" + username + " Connection closed. Status: " + status);
        sessionService.removeUser(username);
        sessionService.removeGroupUser(groupName, username);
        logger.info("在线人数：{}", sessionService.getOnlineCount());
        try {
            if ("DHS_FIGHT_MODEL".equals(groupName)) {
                if (!"null".equals(username) && !"".equals(username) && !(null == username)) {
                    String _userId = username.replaceAll("user", "");
                    if (!"".equals(_userId) && NumberUtils.isDigits(_userId)) {
                        Long userId = Long.parseLong(_userId);
                        gameFightService.offLine(userId);
                    }
                }
                //所有连接断开时,清除无效游戏数据
                if (sessionService.getGroupUsers(groupName) == null) {
                    logger.info("-------所有连接已断开，清除无效好友对战游戏数据-------");
                    redisClient.del(RedisFiledConstant.DHS_FIGHT_ROOM);
                    redisClient.del(RedisFiledConstant.DHS_FIGHT_USER_ROOM);
                    redisClient.del(RedisFiledConstant.DHS_FIGHT_USER_RECORD);
                }
            }
        } catch (Exception e) {
            logger.error("【连接关闭】 异常Exception={},e.stackTrace={}", e.getMessage(), e);
        }
    }

    /**
     * 传输错误时调用
     *
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        String username = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        if (session.isOpen()) {
            session.close();
        }
        logger.debug("socket用户: " + username + "连接关闭成功......");
    }

    /**
     * 给某个分组用户发信息
     *
     * @param message
     */
    public void sendMessageToGroupUsers(String groupName, TextMessage message) {
        Map<String, WebSocketSession> userMap = sessionService.getGroupUsers(groupName);
        if (userMap == null) {
            return;
        }
        for (Map.Entry<String, WebSocketSession> entry : userMap.entrySet()) {
            WebSocketSession userSession = entry.getValue();
            try {
                if (null != userSession && userSession.isOpen()) {
                    userSession.sendMessage(message);
                    logger.info("分组: " + groupName + " 信息发送，用户：" + entry.getKey() + "连接正常，消息发送成功：" + message.getPayload());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        Map<String, WebSocketSession> userMap = sessionService.getAllUsers();
        if (userMap == null) {
            return;
        }
        for (Map.Entry<String, WebSocketSession> entry : userMap.entrySet()) {
            WebSocketSession userSession = entry.getValue();
            try {
                if (null != userSession && userSession.isOpen()) {
                    userSession.sendMessage(message);
                    logger.info("全部在线用户信息发送，用户：" + entry.getKey() + "连接正常，消息发送成功：" + message.getPayload());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        WebSocketSession userSession = sessionService.getUser(userName);
        try {
            if (null != userSession && userSession.isOpen()) {
                userSession.sendMessage(message);
                logger.info("socket用户: " + userName + " 连接正常，消息发送成功：" + message.getPayload());
            } else {
                logger.info("socket用户: " + userName + " 连接已断开，消息发送失败：" + message.getPayload());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给某个分组某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String groupName, String userName, TextMessage message) {
        WebSocketSession userSession = sessionService.getGroupUser(groupName, userName);
        try {
            if (null != userSession && userSession.isOpen()) {
                userSession.sendMessage(message);
                logger.info("分组:" + groupName + " socket用户: " + userName + " 连接正常，消息发送成功：" + message.getPayload());
            } else {
                logger.info("分组:" + groupName + "socket用户: " + userName + " 连接已断开，消息发送失败：" + message.getPayload());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 断开某个用户链接
     *
     * @param userName
     * @throws Exception
     */
    public void close(String userName) throws Exception {
        WebSocketSession userSession = sessionService.getUser(userName);
        if (userSession == null) {
            return;
        }
        if (userSession.isOpen()) {
            userSession.close();
            sessionService.removeUser(userName);
        }
    }
}
