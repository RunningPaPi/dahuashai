package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameFightUserRecordsService;
import com.artqiyi.dahuashai.game.domain.GameFightUserRecord;
import com.artqiyi.dahuashai.game.mapper.GameFightUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameFightUserRecordsServiceImpl implements IGameFightUserRecordsService {

    @Autowired
    private GameFightUserRecordMapper mapper;

    @Override
    public Long save(GameFightUserRecord records) {
        if (null == records.getId() || records.getId()==0) {
            mapper.insertSelective(records);
        } else {
            mapper.updateByPrimaryKeySelective(records);
        }
        return records.getId();
    }
}
