package com.artqiyi.dahuashai.game.vo;

public class UserRankVo implements Comparable<UserRankVo>{
    private String userName;
    private long userId;
    private String headPicUrl;
    private int passTimes;
    private int money;
    private int rank;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public int getPassTimes() {
        return passTimes;
    }

    public void setPassTimes(int passTimes) {
        this.passTimes = passTimes;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(UserRankVo o) {
        int i = this.getPassTimes() - o.getPassTimes();//先按照年龄排序
        if(i == 0){
            return this.getMoney() - o.getMoney();//如果年龄相等了再用分数进行排序
        }
        return i;
    }
}
