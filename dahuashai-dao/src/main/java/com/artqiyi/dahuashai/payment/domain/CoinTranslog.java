package com.artqiyi.dahuashai.payment.domain;

import java.util.Date;

public class CoinTranslog {
    private Integer coinTranslogId;

    private Long userId;

    private String userName;

    private Integer accountType;

    private String transType;

    private String transTypeSub;

    private Integer transFlag;

    private Integer transAmount;

    private Integer balance;

    private String remark;

    private Integer awardPercentInvitor;

    private Long awardFromUserId;

    private Date transTime;

    private Date updateTime;

    private Date createTime;

    public Integer getCoinTranslogId() {
        return coinTranslogId;
    }

    public void setCoinTranslogId(Integer coinTranslogId) {
        this.coinTranslogId = coinTranslogId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransTypeSub() {
        return transTypeSub;
    }

    public void setTransTypeSub(String transTypeSub) {
        this.transTypeSub = transTypeSub;
    }

    public Integer getTransFlag() {
        return transFlag;
    }

    public void setTransFlag(Integer transFlag) {
        this.transFlag = transFlag;
    }

    public Integer getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Integer transAmount) {
        this.transAmount = transAmount;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAwardPercentInvitor() {
        return awardPercentInvitor;
    }

    public void setAwardPercentInvitor(Integer awardPercentInvitor) {
        this.awardPercentInvitor = awardPercentInvitor;
    }

    public Long getAwardFromUserId() {
        return awardFromUserId;
    }

    public void setAwardFromUserId(Long awardFromUserId) {
        this.awardFromUserId = awardFromUserId;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}