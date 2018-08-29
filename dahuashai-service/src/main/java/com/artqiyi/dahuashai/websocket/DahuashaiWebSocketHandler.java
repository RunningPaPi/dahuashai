/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: tanqiu-service
 * Author: author  wushyue@gmail.com
 * Create On: May 2, 2018 4:22:36 PM
 * Modify On: May 2, 2018 4:22:36 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.websocket;

import com.alibaba.fastjson.JSON;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.socket.SocketConstant;
import com.artqiyi.dahuashai.game.IGameBreakService;
import com.artqiyi.dahuashai.game.IGameFightService;
import com.artqiyi.dahuashai.redis.RedisClient;
import com.artqiyi.dahuashai.websocket.service.WebSocketSessionService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.Map;

//@Component
public class DahuashaiWebSocketHandler extends TextWebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(DahuashaiWebSocketHandler.class);
    @Autowired
    private IGameBreakService gameBreakService;
    @Autowired
    private IGameFightService gameFightService;
    @Autowired
    private RedisClient redisClient;
    private WebSocketSessionService sessionService = WebSocketSessionService.INSTANCE;

    /**
	 * 处理前端发送的文本信息 js调用websocket.send时候, 会调用该方法
	 *
	 * @param session
	 * @param message
	 * @throws Exception
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Map paramsMap = (Map)JSON.parse(message.getPayload());
        String code = MapUtils.getString(paramsMap,"code");
        Map dataMap = (Map)paramsMap.get("params");
        if (code != null) {
            switch (code) {
                /*=============================大话骰闯关游戏socket相关操作=========================================*/
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_BEGIN: //闯关游戏开始
                    gameBreakService.startGame(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "gameId"), MapUtils.getString(dataMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_CONTINUE: //继续闯关
                    gameBreakService.continueGame(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "gameId"), MapUtils.getString(dataMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_FOLLOW: //叫数（跟）
                    gameBreakService.follow(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "gameNo"), MapUtils.getString(dataMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_OPEN: //开骰
                    gameBreakService.open(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_GIVE_UP: //放弃比赛
                    gameBreakService.giveUp(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "gameNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RECOVER: //比赛复活
                    gameBreakService.recover(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "gameId"), MapUtils.getString(dataMap, "gameNo"), MapUtils.getIntValue(dataMap, "round"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_EMOTICON: //表情
                    gameBreakService.emoticon(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "gameNo"), MapUtils.getString(dataMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_QUIT_WAIT: //退出等待
                    gameBreakService.quit(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "gameId"), MapUtils.getString(dataMap, "gameNo"), MapUtils.getBoolean(dataMap, "isBegin"));
                    break;
                /*=============================大话骰好友对战socket相关操作=========================================*/

                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM: //加入房间
                    gameFightService.enterRoom(MapUtils.getLong(dataMap, "userId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_EMOTICON: //表情
                    gameFightService.emoticon(MapUtils.getLong(dataMap, "userId"), MapUtils.getString(dataMap, "roomNo"), MapUtils.getString(dataMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_FOLLOW: //叫骰
                    gameFightService.follow(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "roomNo"), MapUtils.getString(dataMap, "data"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_OPEN: //开骰
                    gameFightService.open(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_AGAIN: //再来一局
                    gameFightService.again(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_QUIT_WAIT: //放弃等待
                    gameFightService.quit(MapUtils.getLong(dataMap, "userId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_GIVE_UP: //认输
                    gameFightService.giveUp(MapUtils.getLong(dataMap, "userId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_START: //开始
                    gameFightService.start(MapUtils.getLong(dataMap, "userId"), MapUtils.getLong(dataMap, "againstId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                case SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_LEAVE: //离开
                    gameFightService.leave(MapUtils.getLong(dataMap, "userId"), MapUtils.getString(dataMap, "roomNo"));
                    break;
                default:
                    break;
            }
        }
	}

	/**
	 * 当新连接建立的时候, 连接成功时候,会触发页面上onOpen方法
	 *
	 * @param session
	 * @throws Exception
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        UserGroup userGroup = getUserIdAndGroupName(session);
        //如果建立过连接,关闭并删除旧的
        WebSocketSession oldSession = sessionService.getUser(userGroup.getUserName());
        if (oldSession != null && oldSession.isOpen()){
            oldSession.close();
        }
        sessionService.addUser(userGroup.getUserName(), session);
        sessionService.addGroupUser(userGroup.getGroupName(), userGroup.getUserName(), session);
        logger.info("在线用户：{}", sessionService.getOnlineCount());
	}

	private UserGroup getUserIdAndGroupName(WebSocketSession session){
        URI uri = session.getUri();
        String[] uriSeg = uri.getPath().replace("/dhsWebsocket/","").split("/");
        return new UserGroup(uriSeg[0], uriSeg[1]);
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
        UserGroup userGroup = getUserIdAndGroupName(session);
        sessionService.removeUser(userGroup.getUserName());
        sessionService.removeGroupUser(userGroup.getGroupName(), userGroup.getUserName());
		//所有连接断开时,清除无效游戏数据
		if ("DHS_FIGHT_MODEL".equals(userGroup.getGroupName())){
		    if (sessionService.getGroupUsers("DHS_FIGHT_MODEL") == null) {
		        logger.info("------------- redisClient.del(RedisFiledConstant.DHS_FIGHT_ROOM)------------------");
		        redisClient.del(RedisFiledConstant.DHS_FIGHT_ROOM);
		        redisClient.del(RedisFiledConstant.DHS_FIGHT_USER_ROOM);
		        redisClient.del(RedisFiledConstant.DHS_FIGHT_USER_RECORD);
            }
        }
        logger.info("用户 " + userGroup.getUserName() + " Connection closed. Status: " + status);
        logger.info("在线用户：{}", sessionService.getOnlineCount());
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
        UserGroup userGroup = getUserIdAndGroupName(session);
		if (session.isOpen()) {
			session.close();
		}
		logger.debug("用户: " + userGroup.getUserName() + " websocket connection closed......");
        sessionService.removeUser(userGroup.getUserName());
        sessionService.removeGroupUser(userGroup.getGroupName(), userGroup.getUserName());
	}

	/**
	 * 给所有在线用户发送消息
	 *
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		for (Map.Entry<String, WebSocketSession> sessionEntry : sessionService.getAllUsers().entrySet()) {
			try {
				if (sessionEntry.getValue().isOpen()) {
					sessionEntry.getValue().sendMessage(message);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
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
		WebSocketSession session = sessionService.getUser(userName);
		if (session != null) {
			try {
				if (session.isOpen()) {
					session.sendMessage(message);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
	}

    public class UserGroup{
        //userName
        private String userName;
        //groupName
        private String groupName;

        public UserGroup(String userName, String groupName){
            this.userName = userName;
            this.groupName = groupName;
        }

        public String getUserName() {
            return userName;
        }
        public String getGroupName() {
            return groupName;
        }
    }

}
