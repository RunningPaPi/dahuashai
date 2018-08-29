package com.artqiyi.dahuashai.game.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class PassAwardRecord {

    @JsonIgnore
    private Long userId;

    private Integer passTimes;

    private Long awardNum;
    @JsonIgnore
    private String openId;
    @JsonIgnore
    private Date latestPassTime;
    @JsonIgnore
    private Boolean readStat;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getLatestPassTime() {
        return latestPassTime;
    }

    public void setLatestPassTime(Date latestPassTime) {
        this.latestPassTime = latestPassTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPassTimes() {
        return passTimes;
    }

    public void setPassTimes(Integer passTimes) {
        this.passTimes = passTimes;
    }

    public Long getAwardNum() {
        return awardNum;
    }

    public void setAwardNum(Long awardNum) {
        this.awardNum = awardNum;
    }

    public Boolean getReadStat() {
        return readStat;
    }

    public void setReadStat(Boolean readStat) {
        this.readStat = readStat;
    }

    @Override
    public String toString() {
        return "GamePassAwardRecord{" +
                "userId=" + userId +
                ", passTimes=" + passTimes +
                ", awardNum=" + awardNum +
                ", readStat=" + readStat +
                '}';
    }
}