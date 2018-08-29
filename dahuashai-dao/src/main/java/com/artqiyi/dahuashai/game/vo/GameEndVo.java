package com.artqiyi.dahuashai.game.vo;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/03
 * Modify On: 2018/07/03 20:12 by wufuchang
 */

import java.util.List;

/**
 * 游戏结束返回数据
 */
public class GameEndVo {
    private Integer score;//本次最终得分
    private boolean isSelfWeekHighest;//是否本周最佳 平记录不算
    private List<GameRankVo> friendGameRankVoList;//好友排行榜
    private GameRankVo myGameRankVo;//我的最佳记录


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isSelfWeekHighest() {
        return isSelfWeekHighest;
    }

    public void setSelfWeekHighest(boolean selfWeekHighest) {
        isSelfWeekHighest = selfWeekHighest;
    }

    public List<GameRankVo> getFriendGameRankVoList() {
        return friendGameRankVoList;
    }

    public void setFriendGameRankVoList(List<GameRankVo> friendGameRankVoList) {
        this.friendGameRankVoList = friendGameRankVoList;
    }

    public GameRankVo getMyGameRankVo() {
        return myGameRankVo;
    }

    public void setMyGameRankVo(GameRankVo myGameRankVo) {
        this.myGameRankVo = myGameRankVo;
    }


}
