package com.artqiyi.dahuashai.game.vo;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/03
 * Modify On: 2018/07/03 17:36 by wufuchang
 */

import java.util.List;

import com.artqiyi.dahuashai.game.domain.GameConfig;

/**
 * 点击某种模式进入的界面 值对象
 */
public class GameModelPageInfoVo {
    //该模式下的游戏配置
    private List<GameConfig> gameConfigs;

    public List<GameConfig> getGameConfigs() {
        return gameConfigs;
    }

    public void setGameConfigs(List<GameConfig> gameConfigs) {
        this.gameConfigs = gameConfigs;
    }
}
