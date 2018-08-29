package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameBreakUserRecordsService;
import com.artqiyi.dahuashai.game.domain.GameBreakUserRecords;
import com.artqiyi.dahuashai.game.domain.GameBreakUserRecordsExample;
import com.artqiyi.dahuashai.game.mapper.GameBreakUserRecordsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBreakUserRecordsImpl implements IGameBreakUserRecordsService {
    @Autowired
    private GameBreakUserRecordsMapper mapper;
    @Override
    public PageInfo<GameBreakUserRecords> page(int page, int pageSize, GameBreakUserRecordsExample example) {
        PageHelper.startPage(page,pageSize);
        List<GameBreakUserRecords> gameBreakRecords = mapper.selectByExample(example);
        return new PageInfo<>(gameBreakRecords);
    }

    @Override
    public long saveOrUpdate(GameBreakUserRecords gameBreakUserRecords) {
        if(null==gameBreakUserRecords.getId() || gameBreakUserRecords.getId()==0){
            mapper.insertSelective(gameBreakUserRecords);
        }else{
            mapper.updateByPrimaryKeySelective(gameBreakUserRecords);
        }
        return gameBreakUserRecords.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameBreakUserRecordsExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameBreakUserRecords records, GameBreakUserRecordsExample example) {
        return mapper.updateByExample(records,example);
    }

    @Override
    public List<GameBreakUserRecords> selectByExample(GameBreakUserRecordsExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameBreakUserRecords selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameBreakUserRecordsExample example) {
        return mapper.countByExample(example);
    }
}
