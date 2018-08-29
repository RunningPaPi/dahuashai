package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameBreakAgainstRecordsService;
import com.artqiyi.dahuashai.game.domain.GameBreakAgainstRecords;
import com.artqiyi.dahuashai.game.domain.GameBreakAgainstRecordsExample;
import com.artqiyi.dahuashai.game.mapper.GameBreakAgainstRecordsMapper;
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
public class GameBreakAgainstRecordsServiceImpl implements IGameBreakAgainstRecordsService {
    @Autowired
    private GameBreakAgainstRecordsMapper mapper;
    @Override
    public PageInfo<GameBreakAgainstRecords> page(int page, int pageSize, GameBreakAgainstRecordsExample example) {
        PageHelper.startPage(page,pageSize);
        List<GameBreakAgainstRecords> gameBreakRecords = mapper.selectByExample(example);
        return new PageInfo<>(gameBreakRecords);
    }

    @Override
    public long saveOrUpdate(GameBreakAgainstRecords record) {
        if(null==record.getId() || record.getId()==0){
            mapper.insertSelective(record);
        }else{
            mapper.updateByPrimaryKeySelective(record);
        }
        return record.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameBreakAgainstRecordsExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameBreakAgainstRecords records, GameBreakAgainstRecordsExample example) {
        return mapper.updateByExample(records,example);
    }

    @Override
    public List<GameBreakAgainstRecords> selectByExample(GameBreakAgainstRecordsExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameBreakAgainstRecords selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameBreakAgainstRecordsExample example) {
        return mapper.countByExample(example);
    }
}
