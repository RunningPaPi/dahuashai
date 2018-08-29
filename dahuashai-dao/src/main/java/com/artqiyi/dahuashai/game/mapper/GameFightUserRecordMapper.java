package com.artqiyi.dahuashai.game.mapper;

import com.artqiyi.dahuashai.game.domain.GameFightUserRecord;
import com.artqiyi.dahuashai.game.domain.GameFightUserRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameFightUserRecordMapper {
    long countByExample(GameFightUserRecordExample example);

    int deleteByExample(GameFightUserRecordExample example);

    int deleteByPrimaryKey(@Param("id") Long id, @Param("userId") Long userId, @Param("gameNo") String gameNo);

    int insert(GameFightUserRecord record);

    int insertSelective(GameFightUserRecord record);

    List<GameFightUserRecord> selectByExample(GameFightUserRecordExample example);

    GameFightUserRecord selectByPrimaryKey(@Param("id") Long id, @Param("userId") Long userId, @Param("gameNo") String gameNo);

    int updateByExampleSelective(@Param("record") GameFightUserRecord record, @Param("example") GameFightUserRecordExample example);

    int updateByExample(@Param("record") GameFightUserRecord record, @Param("example") GameFightUserRecordExample example);

    int updateByPrimaryKeySelective(GameFightUserRecord record);

    int updateByPrimaryKey(GameFightUserRecord record);
}