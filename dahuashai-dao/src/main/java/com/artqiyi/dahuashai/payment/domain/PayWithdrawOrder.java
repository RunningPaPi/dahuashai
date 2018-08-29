package com.artqiyi.dahuashai.payment.domain;

import java.util.Date;

public class PayWithdrawOrder {
    private String withdrawOrderId;

    private String withdrawOrderNum;

    private Integer orderType;

    private Long userId;

    private String openid;

    private String userName;

    private Long withdrawCoinAmount;

    private Long withdrawAmount;

    private Long orderAmount;

    private String channelAcquiringNum;

    private Date channelPayTime;

    private String channelPayErrorcode;

    private Integer channel;

    private Integer channelPayAmount;

    private Integer orderState;

    private Integer orderStateSub;

    private Integer orderFlag;

    private String orderDesc;

    private String remark;

    private String clientIp;

    private Date createTime;

    private Date validTime;

    private Date finishTime;

    private Date updateTime;

    public String getWithdrawOrderId() {
        return withdrawOrderId;
    }

    public void setWithdrawOrderId(String withdrawOrderId) {
        this.withdrawOrderId = withdrawOrderId;
    }

    public String getWithdrawOrderNum() {
        return withdrawOrderNum;
    }

    public void setWithdrawOrderNum(String withdrawOrderNum) {
        this.withdrawOrderNum = withdrawOrderNum;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getWithdrawCoinAmount() {
        return withdrawCoinAmount;
    }

    public void setWithdrawCoinAmount(Long withdrawCoinAmount) {
        this.withdrawCoinAmount = withdrawCoinAmount;
    }

    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getChannelAcquiringNum() {
        return channelAcquiringNum;
    }

    public void setChannelAcquiringNum(String channelAcquiringNum) {
        this.channelAcquiringNum = channelAcquiringNum;
    }

    public Date getChannelPayTime() {
        return channelPayTime;
    }

    public void setChannelPayTime(Date channelPayTime) {
        this.channelPayTime = channelPayTime;
    }

    public String getChannelPayErrorcode() {
        return channelPayErrorcode;
    }

    public void setChannelPayErrorcode(String channelPayErrorcode) {
        this.channelPayErrorcode = channelPayErrorcode;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getChannelPayAmount() {
        return channelPayAmount;
    }

    public void setChannelPayAmount(Integer channelPayAmount) {
        this.channelPayAmount = channelPayAmount;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderStateSub() {
        return orderStateSub;
    }

    public void setOrderStateSub(Integer orderStateSub) {
        this.orderStateSub = orderStateSub;
    }

    public Integer getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}