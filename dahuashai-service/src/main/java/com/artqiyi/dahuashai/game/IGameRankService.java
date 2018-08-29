package com.artqiyi.dahuashai.game;

import com.artqiyi.dahuashai.game.vo.UserRankVo;
import com.github.pagehelper.PageInfo;

public interface IGameRankService {

    /**
     * 根据排名方式获取相应的排名
     *
     * @param page      第几页
     * @param pageSize  一页中的记录数
     * @param gameId    游戏id
     * @param wayOfRank 排名方式
     * @return
     */
    PageInfo<UserRankVo> getRank(int page, int pageSize, Long gameId, String wayOfRank);

    /**
     * 单个用户的排名
     *
     * @param userId    用户id
     * @param gameId    游戏id
     * @param wayOfRank 排名方式
     * @return
     */
    UserRankVo getRankByUserId(Long userId, Long gameId, String wayOfRank);
}
