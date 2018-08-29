package com.artqiyi.dahuashai.game.mapper;


import org.apache.ibatis.annotations.Param;

import com.artqiyi.dahuashai.game.domain.GameBreakUserQualify;
import com.artqiyi.dahuashai.game.domain.GameBreakUserQualifyExample;

import java.util.List;

public interface GameBreakUserQualifyMapper {
    long countByExample(GameBreakUserQualifyExample example);

    int deleteByExample(GameBreakUserQualifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameBreakUserQualify record);

    int insertSelective(GameBreakUserQualify record);

    List<GameBreakUserQualify> selectByExample(GameBreakUserQualifyExample example);

    GameBreakUserQualify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameBreakUserQualify record, @Param("example") GameBreakUserQualifyExample example);

    int updateByExample(@Param("record") GameBreakUserQualify record, @Param("example") GameBreakUserQualifyExample example);

    int updateByPrimaryKeySelective(GameBreakUserQualify record);

    int updateByPrimaryKey(GameBreakUserQualify record);
}