package com.artqiyi.dahuashai.game.vo;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/7/9
 * Modify On: 2018/7/9 by chencunjun
 */

/**
 * 机器人叫骰
 */
public class RobotCallVo {
    private int times;//个数
    private int number;//点数
    private boolean isOpen;//是否开骰

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
