package com.artqiyi.dahuashai.game.mapper;


import org.apache.ibatis.annotations.Param;

import com.artqiyi.dahuashai.game.domain.GameBreakRecoverCost;
import com.artqiyi.dahuashai.game.domain.GameBreakRecoverCostExample;

import java.util.List;

public interface GameBreakRecoverCostMapper {
    long countByExample(GameBreakRecoverCostExample example);

    int deleteByExample(GameBreakRecoverCostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameBreakRecoverCost record);

    int insertSelective(GameBreakRecoverCost record);

    List<GameBreakRecoverCost> selectByExample(GameBreakRecoverCostExample example);

    GameBreakRecoverCost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameBreakRecoverCost record, @Param("example") GameBreakRecoverCostExample example);

    int updateByExample(@Param("record") GameBreakRecoverCost record, @Param("example") GameBreakRecoverCostExample example);

    int updateByPrimaryKeySelective(GameBreakRecoverCost record);

    int updateByPrimaryKey(GameBreakRecoverCost record);
}