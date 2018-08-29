package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.common.constant.GameConstants;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.game.IGameRankService;
import com.artqiyi.dahuashai.game.mapper.GameRankMapper;
import com.artqiyi.dahuashai.game.vo.UserRankVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRankServiceImpl implements IGameRankService {
    @Autowired
    private GameRankMapper mapper;

     @Override
    public PageInfo<UserRankVo> getRank(int page, int pageSize, Long gameId, String wayOfRank) {

        PageHelper.startPage(page, pageSize);
        List<UserRankVo> qualifies = null;
        DateTime dt = new DateTime();
        switch (wayOfRank) {
            case GameConstants.WAY_OF_RANK_WEEK:
                qualifies = mapper.selectLatestRank(gameId, DateUtil.getThisWeekMonday(dt.withMillisOfDay(0).toDate()), dt.toDate());
                break;
            case GameConstants.WAY_OF_RANK_ALL:
                qualifies = mapper.selectAllRank(gameId);
                break;
            default:
                break;
        }
        return new PageInfo<>(qualifies);
    }

    @Override
    public UserRankVo getRankByUserId(Long userId, Long gameId, String wayOfRank) {
        UserRankVo userRankVo = null;
        DateTime dt = new DateTime();
        switch (wayOfRank) {
            case GameConstants.WAY_OF_RANK_WEEK:
                userRankVo = mapper.selectUserRank(userId, gameId, DateUtil.getThisWeekMonday(dt.withMillisOfDay(0).toDate()), dt.toDate());
                break;
            case GameConstants.WAY_OF_RANK_ALL:
                userRankVo = mapper.selectUserRankInAll(userId,gameId);
                break;
            default:
                break;
        }
        return userRankVo;
    }
}
