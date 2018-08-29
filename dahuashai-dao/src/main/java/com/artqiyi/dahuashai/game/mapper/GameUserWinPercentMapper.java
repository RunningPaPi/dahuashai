package com.artqiyi.dahuashai.game.mapper;

import com.artqiyi.dahuashai.game.domain.GameUserWinPercent;
import com.artqiyi.dahuashai.game.domain.GameUserWinPercentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameUserWinPercentMapper {
    long countByExample(GameUserWinPercentExample example);

    int deleteByExample(GameUserWinPercentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameUserWinPercent record);

    int insertSelective(GameUserWinPercent record);

    List<GameUserWinPercent> selectByExample(GameUserWinPercentExample example);

    GameUserWinPercent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameUserWinPercent record, @Param("example") GameUserWinPercentExample example);

    int updateByExample(@Param("record") GameUserWinPercent record, @Param("example") GameUserWinPercentExample example);

    int updateByPrimaryKeySelective(GameUserWinPercent record);

    int updateByPrimaryKey(GameUserWinPercent record);
}