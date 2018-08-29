package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameFightRecordsService;
import com.artqiyi.dahuashai.game.domain.GameFightRecords;
import com.artqiyi.dahuashai.game.mapper.GameFightRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameFightRecordsServiceImpl implements IGameFightRecordsService {

    @Autowired
    private GameFightRecordsMapper mapper;

    @Override
    public Long save(GameFightRecords records) {
        if (null == records.getId() || records.getId()==0) {
            mapper.insertSelective(records);
        } else {
            mapper.updateByPrimaryKeySelective(records);
        }
        return records.getId();
    }
}
