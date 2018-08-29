package com.artqiyi.dahuashai.game.domain;

import java.util.Date;

public class GameBreakUserQualify {
    private Long id;

    private Long gameModelId;

    private String gameNo;

    private Long userId;

    private String nickName;

    private String headUrl;

    private Integer passTimes;

    private Boolean isAward;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameModelId() {
        return gameModelId;
    }

    public void setGameModelId(Long gameModelId) {
        this.gameModelId = gameModelId;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo == null ? null : gameNo.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public Integer getPassTimes() {
        return passTimes;
    }

    public void setPassTimes(Integer passTimes) {
        this.passTimes = passTimes;
    }

    public Boolean getIsAward() {
        return isAward;
    }

    public void setIsAward(Boolean isAward) {
        this.isAward = isAward;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}