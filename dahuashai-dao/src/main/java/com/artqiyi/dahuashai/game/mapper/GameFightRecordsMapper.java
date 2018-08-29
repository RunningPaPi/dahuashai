package com.artqiyi.dahuashai.game.mapper;

import com.artqiyi.dahuashai.game.domain.GameFightRecords;
import com.artqiyi.dahuashai.game.domain.GameFightRecordsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameFightRecordsMapper {
    long countByExample(GameFightRecordsExample example);

    int deleteByExample(GameFightRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameFightRecords record);

    int insertSelective(GameFightRecords record);

    List<GameFightRecords> selectByExample(GameFightRecordsExample example);

    GameFightRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameFightRecords record, @Param("example") GameFightRecordsExample example);

    int updateByExample(@Param("record") GameFightRecords record, @Param("example") GameFightRecordsExample example);

    int updateByPrimaryKeySelective(GameFightRecords record);

    int updateByPrimaryKey(GameFightRecords record);
}