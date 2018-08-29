package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameBreakRecordsService;
import com.artqiyi.dahuashai.game.domain.GameBreakRecords;
import com.artqiyi.dahuashai.game.domain.GameBreakRecordsExample;
import com.artqiyi.dahuashai.game.mapper.GameBreakRecordsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBreakRecordsServiceImpl implements IGameBreakRecordsService {
    @Autowired
    private GameBreakRecordsMapper mapper;
    @Override
    public PageInfo<GameBreakRecords> page(int page, int pageSize, GameBreakRecordsExample example) {
        PageHelper.startPage(page,pageSize);
        List<GameBreakRecords> gameBreakRecords = mapper.selectByExample(example);
        return new PageInfo<>(gameBreakRecords);
    }

    @Override
    public long saveOrUpdate(GameBreakRecords GameBreakRecords) {
        if(null==GameBreakRecords.getId() || GameBreakRecords.getId()==0){
            mapper.insertSelective(GameBreakRecords);
        }else{
            mapper.updateByPrimaryKeySelective(GameBreakRecords);
        }
        return GameBreakRecords.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameBreakRecordsExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameBreakRecords records, GameBreakRecordsExample example) {
        return mapper.updateByExample(records,example);
    }

    @Override
    public List<GameBreakRecords> selectByExample(GameBreakRecordsExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameBreakRecords selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameBreakRecordsExample example) {
        return mapper.countByExample(example);
    }
}
