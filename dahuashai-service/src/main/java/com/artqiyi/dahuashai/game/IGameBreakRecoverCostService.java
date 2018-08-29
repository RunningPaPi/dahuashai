package com.artqiyi.dahuashai.game;

import com.artqiyi.dahuashai.base.service.IBaseService;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverCost;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverCostExample;

import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/7/3
 * Modify On: 2018/7/3 by chencunjun
 */
public interface IGameBreakRecoverCostService extends IBaseService<GameBreakRecoverCost,GameBreakRecoverCostExample> {
    List<GameBreakRecoverCost> getByGameModelKey(String gameKey);

    GameBreakRecoverCost getRoundCost(long gameId, int i);
}
