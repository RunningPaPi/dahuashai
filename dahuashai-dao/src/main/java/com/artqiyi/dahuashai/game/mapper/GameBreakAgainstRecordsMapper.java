package com.artqiyi.dahuashai.game.mapper;

import org.apache.ibatis.annotations.Param;

import com.artqiyi.dahuashai.game.domain.GameBreakAgainstRecords;
import com.artqiyi.dahuashai.game.domain.GameBreakAgainstRecordsExample;

import java.util.List;

public interface GameBreakAgainstRecordsMapper {
    long countByExample(GameBreakAgainstRecordsExample example);

    int deleteByExample(GameBreakAgainstRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameBreakAgainstRecords record);

    int insertSelective(GameBreakAgainstRecords record);

    List<GameBreakAgainstRecords> selectByExample(GameBreakAgainstRecordsExample example);

    GameBreakAgainstRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameBreakAgainstRecords record, @Param("example") GameBreakAgainstRecordsExample example);

    int updateByExample(@Param("record") GameBreakAgainstRecords record, @Param("example") GameBreakAgainstRecordsExample example);

    int updateByPrimaryKeySelective(GameBreakAgainstRecords record);

    int updateByPrimaryKey(GameBreakAgainstRecords record);
}