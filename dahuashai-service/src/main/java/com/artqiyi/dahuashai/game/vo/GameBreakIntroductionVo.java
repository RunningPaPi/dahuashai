package com.artqiyi.dahuashai.game.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class GameBreakIntroductionVo {
    private Long userId;
    private int passThroughNum;
    private int contestNum;
    private String awardTime;
    private int money;
    private String posterUrl;
    private int totalLevels;
    private String gameNo;
    private String gameKey;
    private String gameName;
    private Long gameId;
    private int passTimes;
    private List<String> gameRules;
    private List<String> breakRules;
    private Date systemTime;
    private int levelCost;
    private int currentLevel;
    private boolean isLive;
    private Short costType;
    private int maxShareTimes;
    private int shareTimes;
    @JsonIgnore
    private String shareType;
    private PassAwardRecord passAwardRecord;

    public PassAwardRecord getPassAwardRecord() {
        return passAwardRecord;
    }

    public void setPassAwardRecord(PassAwardRecord passAwardRecord) {
        this.passAwardRecord = passAwardRecord;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public int getMaxShareTimes() {
        return maxShareTimes;
    }

    public void setMaxShareTimes(int maxShareTimes) {
        this.maxShareTimes = maxShareTimes;
    }

    public int getShareTimes() {
        return shareTimes;
    }

    public void setShareTimes(int shareTimes) {
        this.shareTimes = shareTimes;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setPassThroughNum(int passThroughNum) {
        this.passThroughNum = passThroughNum;
    }

    public int getPassThroughNum() {
        return passThroughNum;
    }

    public void setContestNum(int contestNum) {
        this.contestNum = contestNum;
    }

    public int getContestNum() {
        return contestNum;
    }

    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }

    public String getAwardTime() {
        return awardTime;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setTotalLevels(int totalLevels) {
        this.totalLevels = totalLevels;
    }

    public int getTotalLevels() {
        return totalLevels;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setPassTimes(int passTimes) {
        this.passTimes = passTimes;
    }

    public int getPassTimes() {
        return passTimes;
    }

    public void setGameRules(List<String> gameRules) {
        this.gameRules = gameRules;
    }

    public List<String> getGameRules() {
        return gameRules;
    }

    public void setBreakRules(List<String> breakRules) {
        this.breakRules = breakRules;
    }

    public List<String> getBreakRules() {
        return breakRules;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    public Date getSystemTime() {
        return systemTime;
    }

    public void setLevelCost(int levelCost) {
        this.levelCost = levelCost;
    }

    public int getLevelCost() {
        return levelCost;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setCostType(Short costType) {
        this.costType = costType;
    }

    public Short getCostType() {
        return costType;
    }
}
