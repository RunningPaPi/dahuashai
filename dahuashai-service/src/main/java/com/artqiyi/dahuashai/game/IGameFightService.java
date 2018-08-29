package com.artqiyi.dahuashai.game;

import com.artqiyi.dahuashai.game.vo.GameFightUserRecordsVo;

/**
 * 好友对战模式
 */
public interface IGameFightService {
    /**
     * 用户创建房间
     *
     * @param userId 用户ID
     */
    String newRoom(Long userId);

    /**
     * 进入房间匹配对战
     *
     * @param userId 用户id
     * @param roomNo 房间编码
     */
    void enterRoom(Long userId, String roomNo);

    /**
     * 开始游戏
     *
     * @param userId
     */
    void start(Long userId, Long againstId, String roomNo);

    /**
     * 逃跑
     *
     * @param userId 用户id
     * @param roomNo 房间编码
     */
    void giveUp(long userId, String roomNo);

    /**
     * 表情
     *
     * @param userId
     * @param roomNo
     */
    void emoticon(long userId, String roomNo, String data);

    /**
     * 叫骰
     *
     * @param userId
     * @param againstId
     * @param roomNo
     * @param data
     */
    void follow(long userId, long againstId, String roomNo, String data);

    /**
     * 再来一局
     *
     * @param userId
     * @param roomNo
     */
    void again(long userId, long againstId, String roomNo);

    /**
     * 结束PK后离开房间
     *
     * @param userId
     * @param roomNo
     */
    void leave(Long userId, String roomNo);

    /**
     * 退出等待
     *
     * @param userId
     * @param roomNo
     */
    void quit(Long userId, String roomNo);

    /**
     * 开骰
     *
     * @param userId
     * @param againstId
     * @param roomNo
     */
    void open(long userId, long againstId, String roomNo);

    /**
     * 赢得比赛PK
     *
     * @param winPlayer  赢家记录
     * @param failPlayer 输家记录
     */
    void win(GameFightUserRecordsVo winPlayer, GameFightUserRecordsVo failPlayer, String msgCode);

    /**
     * 超时监测任务
     *
     * @param player
     */
    void callNumberOvertime(GameFightUserRecordsVo player);

    /**
     * 掉线
     * @param userId
     */
    void offLine(Long userId);

    void saveData(Object o);
}
