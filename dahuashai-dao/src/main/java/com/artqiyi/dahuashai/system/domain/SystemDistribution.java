package com.artqiyi.dahuashai.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class SystemDistribution {
    @JsonIgnore
    private Integer distrId;

    private Short appType;

    private String version;

    private Short appStoreId;

    private Short distrState;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

    public Integer getDistrId() {
        return distrId;
    }

    public void setDistrId(Integer distrId) {
        this.distrId = distrId;
    }

    public Short getAppType() {
        return appType;
    }

    public void setAppType(Short appType) {
        this.appType = appType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Short getAppStoreId() {
        return appStoreId;
    }

    public void setAppStoreId(Short appStoreId) {
        this.appStoreId = appStoreId;
    }

    public Short getDistrState() {
        return distrState;
    }

    public void setDistrState(Short distrState) {
        this.distrState = distrState;
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