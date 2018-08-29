package com.artqiyi.dahuashai.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class UserInfo {
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private Long userId;

    private Integer userRandomNo;

    private String headPicUrl;

    private Short gender;

    private String birthday;

    private String provinceCode;

    private String cityCode;

    private String areaCode;

    private String invaiteCode;

    private String level;

    private Integer diamond;

    private Integer coin;

    private Integer point;

    private Long balance;

    private Long balanceWithdrawable;

    private Long balanceFreezed;

    private String alipayAccount;

    private String alipayRealname;

    private Boolean phoneValidated;

    private Boolean realnameValidated;

    private Boolean alipayAccountValidated;

    private Date lastLoginTime;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
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

    public Integer getUserRandomNo() {
        return userRandomNo;
    }

    public void setUserRandomNo(Integer userRandomNo) {
        this.userRandomNo = userRandomNo;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl == null ? null : headPicUrl.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getInvaiteCode() {
        return invaiteCode;
    }

    public void setInvaiteCode(String invaiteCode) {
        this.invaiteCode = invaiteCode == null ? null : invaiteCode.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getDiamond() {
        return diamond;
    }

    public void setDiamond(Integer diamond) {
        this.diamond = diamond;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalanceWithdrawable() {
        return balanceWithdrawable;
    }

    public void setBalanceWithdrawable(Long balanceWithdrawable) {
        this.balanceWithdrawable = balanceWithdrawable;
    }

    public Long getBalanceFreezed() {
        return balanceFreezed;
    }

    public void setBalanceFreezed(Long balanceFreezed) {
        this.balanceFreezed = balanceFreezed;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    public String getAlipayRealname() {
        return alipayRealname;
    }

    public void setAlipayRealname(String alipayRealname) {
        this.alipayRealname = alipayRealname == null ? null : alipayRealname.trim();
    }

    public Boolean getPhoneValidated() {
        return phoneValidated;
    }

    public void setPhoneValidated(Boolean phoneValidated) {
        this.phoneValidated = phoneValidated;
    }

    public Boolean getRealnameValidated() {
        return realnameValidated;
    }

    public void setRealnameValidated(Boolean realnameValidated) {
        this.realnameValidated = realnameValidated;
    }

    public Boolean getAlipayAccountValidated() {
        return alipayAccountValidated;
    }

    public void setAlipayAccountValidated(Boolean alipayAccountValidated) {
        this.alipayAccountValidated = alipayAccountValidated;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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