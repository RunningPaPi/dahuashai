package com.artqiyi.dahuashai.game.domain;

import java.util.Date;

public class GameFightRecords {
    private Long id;

    private String gameNo;

    private Integer contestNum;

    private Integer pkTimes;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo == null ? null : gameNo.trim();
    }

    public Integer getContestNum() {
        return contestNum;
    }

    public void setContestNum(Integer contestNum) {
        this.contestNum = contestNum;
    }

    public Integer getPkTimes() {
        return pkTimes;
    }

    public void setPkTimes(Integer pkTimes) {
        this.pkTimes = pkTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}