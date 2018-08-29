package com.artqiyi.dahuashai.websocket.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketSession;

/**
 * webSocket用户会话session信息服务(线程安全单例模式)
 */
public enum  WebSocketSessionService {
    INSTANCE;

    // 已建立连接的用户
    private Map<String, WebSocketSession> users = new ConcurrentHashMap<>();

    //分组用户
    private Map<String, Map<String, WebSocketSession>> groupUsers = new ConcurrentHashMap<>();

    public void addUser(String userName, WebSocketSession session){
        users.put(userName, session);
    }

    public void addGroupUser(String groupName, String userName, WebSocketSession session) {
        if (groupUsers.get(groupName) == null){
            Map<String, WebSocketSession> group = new ConcurrentHashMap<>();
            group.put(userName, session);
            groupUsers.put(groupName, group);
            return ;
        }
        groupUsers.get(groupName).put(userName, session);
    }

    public WebSocketSession getGroupUser(String groupName, String userName){
        if (groupUsers.get(groupName) == null){
            return null;
        }
        return groupUsers.get(groupName).get(userName);
    }

    public void removeGroupUser(String groupName, String userName){
        if (groupUsers.get(groupName) != null) {
            groupUsers.get(groupName).remove(userName);
            if (groupUsers.get(groupName).size() == 0) {
                groupUsers.remove(groupName);
            }
        }
    }

    public Map<String, WebSocketSession> getGroupUsers(String groupName){
        return groupUsers.get(groupName);
    }

    public Map<String, WebSocketSession> getAllUsers(){
        return users;
    }

    public WebSocketSession getUser(String userName){
        return users.get(userName);
    }

    public WebSocketSession removeUser(String userName){
        return users.remove(userName);
    }

    public Integer getOnlineCount() {
        return users.size();
    }
}

