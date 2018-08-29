package com.artqiyi.dahuashai.game.domain;

import java.util.Date;

public class GameFightUserRecord {
    private Long id;

    private Long userId;

    private String gameNo;

    private String headUrl;

    private Integer playTimes;

    private Integer winTimes;

    private Integer inviteTimes;

    private Integer successInviteTimes;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo == null ? null : gameNo.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public Integer getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(Integer playTimes) {
        this.playTimes = playTimes;
    }

    public Integer getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(Integer winTimes) {
        this.winTimes = winTimes;
    }

    public Integer getInviteTimes() {
        return inviteTimes;
    }

    public void setInviteTimes(Integer inviteTimes) {
        this.inviteTimes = inviteTimes;
    }

    public Integer getSuccessInviteTimes() {
        return successInviteTimes;
    }

    public void setSuccessInviteTimes(Integer successInviteTimes) {
        this.successInviteTimes = successInviteTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}