package com.artqiyi.dahuashai.game.vo;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/7/4
 * Modify On: 2018/7/4 by chencunjun
 */

/**
 * 比赛过程数据
 */
public class GameDataVo {
    private int againstScore; //对手最终得分
    private String againstGameData; //对手比赛数据

    public int getAgainstScore() {
        return againstScore;
    }

    public void setAgainstScore(int againstScore) {
        this.againstScore = againstScore;
    }

    public String getAgainstGameData() {
        return againstGameData;
    }

    public void setAgainstGameData(String againstGameData) {
        this.againstGameData = againstGameData;
    }
}
