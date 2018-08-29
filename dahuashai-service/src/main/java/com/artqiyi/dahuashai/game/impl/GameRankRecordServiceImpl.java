package com.artqiyi.dahuashai.game.impl;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/03
 * Modify On: 2018/07/03 20:44 by wufuchang
 */

import com.artqiyi.dahuashai.game.IGameRankRecordService;
import com.artqiyi.dahuashai.game.domain.GameRankRecord;
import com.artqiyi.dahuashai.game.mapper.GameRankRecordMapper;
import com.artqiyi.dahuashai.game.vo.GameRankVo;
import com.artqiyi.dahuashai.user.service.IUserInviteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class GameRankRecordServiceImpl implements IGameRankRecordService {
    @Autowired
    private GameRankRecordMapper gameRankRecordMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IUserInviteService userInviteService;

    @Override
    public long saveOrUpdate(GameRankRecord gameRankRecord) {
        if(null==gameRankRecord.getId() || gameRankRecord.getId()==0){
            gameRankRecordMapper.insertSelective(gameRankRecord);
        }else{
            gameRankRecordMapper.updateByPrimaryKeySelective(gameRankRecord);
        }
        return gameRankRecord.getId();
    }

    /**
     * 增加记录
     * @param userId
     * @param userNickName
     * @param gameModelKey
     * @param gameModelId
     * @param score
     */
    @Override
    public void addGameRecord(Long userId, String userNickName, String gameModelKey, Long gameModelId, Integer score) {
        GameRankRecord record = new GameRankRecord();
        record.setGameModelId(gameModelId);
        record.setGameModelKey(gameModelKey);
        record.setUserId(userId);
        record.setUserNickname(userNickName);
        record.setScore(score);
        saveOrUpdate(record);
    }

    /**
     * 获取好友排行榜
     * @param userId
     * @return
     */
    @Override
    public List<GameRankVo> getFriendRankList(Long userId) {
        /*//获取好友列表
        List<Long> friendIdList = userInviteService.getFriendIdList(userId);
        //计算世界排名

        generateWorldRank();*/

        return null;
    }


}
