package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameBreakRecoverCostService;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverCost;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverCostExample;
import com.artqiyi.dahuashai.game.mapper.GameBreakRecoverCostMapper;
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
public class GameBreakRecoverCostServiceImpl implements IGameBreakRecoverCostService {
    @Autowired
    private GameBreakRecoverCostMapper mapper;
    @Override
    public PageInfo<GameBreakRecoverCost> page(int page, int pageSize, GameBreakRecoverCostExample example) {
        PageHelper.startPage(page,pageSize);
        List<GameBreakRecoverCost> gameBreakRecords = mapper.selectByExample(example);
        return new PageInfo<>(gameBreakRecords);
    }

    @Override
    public long saveOrUpdate(GameBreakRecoverCost GameBreakRecoverCost) {
        if(null==GameBreakRecoverCost.getId() || GameBreakRecoverCost.getId()==0){
            mapper.insertSelective(GameBreakRecoverCost);
        }else{
            mapper.updateByPrimaryKeySelective(GameBreakRecoverCost);
        }
        return GameBreakRecoverCost.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameBreakRecoverCostExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameBreakRecoverCost records, GameBreakRecoverCostExample example) {
        return mapper.updateByExample(records,example);
    }

    @Override
    public List<GameBreakRecoverCost> selectByExample(GameBreakRecoverCostExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameBreakRecoverCost selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameBreakRecoverCostExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public List<GameBreakRecoverCost> getByGameModelKey(String gameKey) {
        GameBreakRecoverCostExample example = new GameBreakRecoverCostExample();
        example.or().andGameModelKeyEqualTo(gameKey);
        List<GameBreakRecoverCost> breakGameRecoverCosts = mapper.selectByExample(example);
        if (breakGameRecoverCosts!=null && breakGameRecoverCosts.size()>0){
            return breakGameRecoverCosts;
        }
        return null;
    }

    @Override
    public GameBreakRecoverCost getRoundCost(long gameId, int round) {
        GameBreakRecoverCostExample example = new GameBreakRecoverCostExample();
        example.or().andGameModelIdEqualTo(gameId).andGameRoundEqualTo(round);
        List<GameBreakRecoverCost> breakGameRecoverCosts = mapper.selectByExample(example);
        if (breakGameRecoverCosts!=null && breakGameRecoverCosts.size()>0){
            return breakGameRecoverCosts.get(0);
        }
        return null;
    }
}
