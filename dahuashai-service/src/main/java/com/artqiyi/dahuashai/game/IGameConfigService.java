package com.artqiyi.dahuashai.game;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/03
 * Modify On: 2018/07/03 17:05 by wufuchang
 */

import com.artqiyi.dahuashai.game.domain.GameConfig;
import com.artqiyi.dahuashai.game.vo.GameModelPageInfoVo;

import java.util.List;
import java.util.Map;

/**
 * 大话骰游戏业务接口
 */
public interface IGameConfigService {
    GameModelPageInfoVo getGameModelPageInfo(String gameModelKey);
    List<GameConfig> getConfigsByModelKeyAndCode(String gameModelKey,String configCode) ;

    Map<String,String> getByGameModelKey(String gameModelKey);

    List<GameConfig> getByType(String gameKey, String typeKey);

    List<String> getGameRules(String gameKey);

    List<String> getBreakRules(String gameKey);
}
