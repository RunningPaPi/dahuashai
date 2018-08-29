package com.artqiyi.dahuashai.game.domain;

import java.util.Date;

public class GameUserWinPercent {
    private Integer id;

    private Long userId;

    private String winPercentCode;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWinPercentCode() {
        return winPercentCode;
    }

    public void setWinPercentCode(String winPercentCode) {
        this.winPercentCode = winPercentCode == null ? null : winPercentCode.trim();
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