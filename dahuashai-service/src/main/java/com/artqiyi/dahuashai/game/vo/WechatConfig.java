package com.artqiyi.dahuashai.game.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WechatConfig {
    @Value("${wxapplet.appId}")
    private String appid;
    @Value("${wxapplet.secret}")
    private String appsecret;
    @Value("${wxapplet.msg.templateId}")
    private String templateId;
    @Value("${wxapplet.msg.page}")
    private String page;
    @Value("${wxapplet.msg.sendUrl}")
    private String msgSendUrl; // 发送模板消息url
    @Value("${wxapplet.msg.tokenUrl}")
    private String accessTokenUrl; // 获取access_token的 url

    public String getMsgSendUrl() {
        return msgSendUrl;
    }

    public void setMsgSendUrl(String msgSendUrl) {
        this.msgSendUrl = msgSendUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getAppid() {
        return appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getPage() {
        return page;
    }
}
