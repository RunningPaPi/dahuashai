package com.artqiyi.dahuashai.common.vo;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/05/10
 * Modify On: 2018/05/10 15:42 by wufuchang
 */

/**
 *  quartz传参值对象——匹配游戏
 */
public class QuartzForGameMatchVo {
    private String gameNo;

    private Short nextRound;

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo;
    }

    public Short getNextRound() {
        return nextRound;
    }

    public void setNextRound(Short nextRound) {
        this.nextRound = nextRound;
    }

}
