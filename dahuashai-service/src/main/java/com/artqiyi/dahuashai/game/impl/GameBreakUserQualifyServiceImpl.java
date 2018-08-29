package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameBreakUserQualifyService;
import com.artqiyi.dahuashai.game.domain.GameBreakUserQualify;
import com.artqiyi.dahuashai.game.domain.GameBreakUserQualifyExample;
import com.artqiyi.dahuashai.game.mapper.GameBreakUserQualifyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/7/3
 * Modify On: 2018/7/3 by chencunjun
 */
@Service
public class GameBreakUserQualifyServiceImpl implements IGameBreakUserQualifyService {
    @Autowired
    private GameBreakUserQualifyMapper mapper;
    @Override
    public PageInfo<GameBreakUserQualify> page(int page, int pageSize, GameBreakUserQualifyExample example) {
        PageHelper.startPage(page,pageSize);
        List<GameBreakUserQualify> gameBreakRecords = mapper.selectByExample(example);
        return new PageInfo<>(gameBreakRecords);
    }

    @Override
    public long saveOrUpdate(GameBreakUserQualify GameBreakUserQualify) {
        if(null==GameBreakUserQualify.getId() || GameBreakUserQualify.getId()==0){
            mapper.insertSelective(GameBreakUserQualify);
        }else{
            mapper.updateByPrimaryKeySelective(GameBreakUserQualify);
        }
        return GameBreakUserQualify.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameBreakUserQualifyExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameBreakUserQualify records, GameBreakUserQualifyExample example) {
        return mapper.updateByExample(records,example);
    }

    @Override
    public List<GameBreakUserQualify> selectByExample(GameBreakUserQualifyExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameBreakUserQualify selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameBreakUserQualifyExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public GameBreakUserQualify getLatestUserPrize(Long userId, Long gameId, String gameNo) {
        GameBreakUserQualifyExample example = new GameBreakUserQualifyExample();
        example.or().andUserIdEqualTo(userId).andGameModelIdEqualTo(gameId).andGameNoEqualTo(gameNo);
        List<GameBreakUserQualify> breakGameUserQualifies = mapper.selectByExample(example);
        if (breakGameUserQualifies != null && !breakGameUserQualifies.isEmpty()) {
            return breakGameUserQualifies.get(0);
        }
        return null;
    }
}
