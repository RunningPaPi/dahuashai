package com.artqiyi.dahuashai.user.domain;

import java.util.Date;

public class UserInvite {
    private Long id;

    private Long userId;

    private Long invitorUserId;

    private Boolean isNew;

    private Date createTime;

    private Date updateTime;

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

    public Long getInvitorUserId() {
        return invitorUserId;
    }

    public void setInvitorUserId(Long invitorUserId) {
        this.invitorUserId = invitorUserId;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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