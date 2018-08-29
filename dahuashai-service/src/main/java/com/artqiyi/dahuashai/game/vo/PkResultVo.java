package com.artqiyi.dahuashai.game.vo;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/28
 * Modify On: 2018/5/28 by chencunjun
 */

/**
 * pk结果数据vo
 */
public class PkResultVo {
    private boolean isPass;//是否通关
    private boolean isWin; //是否赢得当前pk
    private int currentRound;//当前关卡
    private Object data;//上次叫骰数据
    private Object agaistData;//对手上次叫骰数据
    private Object lastData;//最后回合叫骰数据
    private int randomNum;  //用户骰子点数
    private int agaistrandomNum;  //对手骰子点数
    private boolean hasCallOne;//是否叫过1
    private int maxShareTimes;
    private int shareTimes;
    private String shareType;

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

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public int getAgaistrandomNum() {
        return agaistrandomNum;
    }

    public void setAgaistrandomNum(int agaistrandomNum) {
        this.agaistrandomNum = agaistrandomNum;
    }

    public Object getAgaistData() {
        return agaistData;
    }

    public void setAgaistData(Object agaistData) {
        this.agaistData = agaistData;
    }

    public Object getLastData() {
        return lastData;
    }

    public void setLastData(Object lastData) {
        this.lastData = lastData;
    }

    public boolean isHasCallOne() {
        return hasCallOne;
    }

    public void setHasCallOne(boolean hasCallOne) {
        this.hasCallOne = hasCallOne;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getShareType() {
        return shareType;
    }
}
