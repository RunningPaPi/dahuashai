package com.artqiyi.dahuashai.game.domain;

import java.util.Date;

public class GameBreakUserRecords {
    private Long id;

    private Long gameId;

    private String gameNo;

    private Long userId;

    private String nickName;

    private String headUrl;

    private Integer recoveryTimes;

    private Short passMaxLevel;

    private Boolean isPass;

    private Integer score;

    private String note;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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

    public Integer getRecoveryTimes() {
        return recoveryTimes;
    }

    public void setRecoveryTimes(Integer recoveryTimes) {
        this.recoveryTimes = recoveryTimes;
    }

    public Short getPassMaxLevel() {
        return passMaxLevel;
    }

    public void setPassMaxLevel(Short passMaxLevel) {
        this.passMaxLevel = passMaxLevel;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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