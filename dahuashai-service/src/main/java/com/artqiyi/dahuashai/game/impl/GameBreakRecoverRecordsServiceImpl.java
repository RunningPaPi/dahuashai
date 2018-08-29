package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameBreakRecoverRecordsService;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverRecords;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverRecordsExample;
import com.artqiyi.dahuashai.game.mapper.GameBreakRecoverRecordsMapper;
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
public class GameBreakRecoverRecordsServiceImpl implements IGameBreakRecoverRecordsService {
    @Autowired
    private GameBreakRecoverRecordsMapper mapper;
    @Override
    public PageInfo<GameBreakRecoverRecords> page(int page, int pageSize, GameBreakRecoverRecordsExample example) {
        PageHelper.startPage(page,pageSize);
        List<GameBreakRecoverRecords> gameBreakRecords = mapper.selectByExample(example);
        return new PageInfo<>(gameBreakRecords);
    }

    @Override
    public long saveOrUpdate(GameBreakRecoverRecords GameBreakRecoverRecords) {
        if(null==GameBreakRecoverRecords.getId() || GameBreakRecoverRecords.getId()==0){
            mapper.insertSelective(GameBreakRecoverRecords);
        }else{
            mapper.updateByPrimaryKeySelective(GameBreakRecoverRecords);
        }
        return GameBreakRecoverRecords.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameBreakRecoverRecordsExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameBreakRecoverRecords records, GameBreakRecoverRecordsExample example) {
        return mapper.updateByExample(records,example);
    }

    @Override
    public List<GameBreakRecoverRecords> selectByExample(GameBreakRecoverRecordsExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameBreakRecoverRecords selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameBreakRecoverRecordsExample example) {
        return mapper.countByExample(example);
    }
}
