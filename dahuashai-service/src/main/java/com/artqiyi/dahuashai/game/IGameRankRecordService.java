package com.artqiyi.dahuashai.game;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/03
 * Modify On: 2018/07/03 20:44 by wufuchang
 */

import com.artqiyi.dahuashai.game.domain.GameRankRecord;
import com.artqiyi.dahuashai.game.vo.GameRankVo;

import java.util.List;

/**
 *
 */
public interface IGameRankRecordService {
    long saveOrUpdate(GameRankRecord gameRankRecord);

    void addGameRecord(Long userId, String userNickName, String gameModelKey, Long gameModelId, Integer score);

    List<GameRankVo> getFriendRankList(Long userId);
}
