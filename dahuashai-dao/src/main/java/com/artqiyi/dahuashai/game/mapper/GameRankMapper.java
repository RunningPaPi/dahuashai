package com.artqiyi.dahuashai.game.mapper;

import com.artqiyi.dahuashai.game.vo.UserRankVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GameRankMapper {
    List<UserRankVo> selectLatestRank(@Param("gameId") Long gameId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<UserRankVo> selectAllRank(@Param("gameId") Long gameId);

    UserRankVo selectUserRank(@Param("userId") Long userId, @Param("gameId") Long gameId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    UserRankVo selectUserRankInAll(@Param("userId") Long userId, @Param("gameId") Long gameId);

    Integer getTotalPassNum(@Param("gameId") Long gameId, @Param("gameNo") String gameNo);
}
