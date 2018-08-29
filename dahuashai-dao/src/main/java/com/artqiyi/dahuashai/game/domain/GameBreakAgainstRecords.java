package com.artqiyi.dahuashai.game.domain;

import java.util.Date;

public class GameBreakAgainstRecords {
    private Long id;

    private Long gameModelId;

    private String gameModelKey;

    private String gameNo;

    private Short gameRound;

    private Integer score;

    private Long userId;

    private String nickName;

    private String headUrl;

    private Boolean isWin;

    private Boolean isGameEnd;

    private Long againstUserId;

    private String againstNickName;

    private String againstHeadUrl;

    private Integer againstScore;

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

    public String getGameModelKey() {
        return gameModelKey;
    }

    public void setGameModelKey(String gameModelKey) {
        this.gameModelKey = gameModelKey == null ? null : gameModelKey.trim();
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo == null ? null : gameNo.trim();
    }

    public Short getGameRound() {
        return gameRound;
    }

    public void setGameRound(Short gameRound) {
        this.gameRound = gameRound;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(Boolean isWin) {
        this.isWin = isWin;
    }

    public Boolean getIsGameEnd() {
        return isGameEnd;
    }

    public void setIsGameEnd(Boolean isGameEnd) {
        this.isGameEnd = isGameEnd;
    }

    public Long getAgainstUserId() {
        return againstUserId;
    }

    public void setAgainstUserId(Long againstUserId) {
        this.againstUserId = againstUserId;
    }

    public String getAgainstNickName() {
        return againstNickName;
    }

    public void setAgainstNickName(String againstNickName) {
        this.againstNickName = againstNickName == null ? null : againstNickName.trim();
    }

    public String getAgainstHeadUrl() {
        return againstHeadUrl;
    }

    public void setAgainstHeadUrl(String againstHeadUrl) {
        this.againstHeadUrl = againstHeadUrl == null ? null : againstHeadUrl.trim();
    }

    public Integer getAgainstScore() {
        return againstScore;
    }

    public void setAgainstScore(Integer againstScore) {
        this.againstScore = againstScore;
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