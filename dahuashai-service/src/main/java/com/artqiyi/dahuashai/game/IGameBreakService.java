package com.artqiyi.dahuashai.game;

import java.util.Map;

import com.artqiyi.dahuashai.game.domain.GameBreakRecords;
import com.artqiyi.dahuashai.game.vo.GameBreakUserRecordsVo;

/**
 * 闯关游戏service接口
 */
public interface IGameBreakService {
    /**
     * 开始游戏
     * @param userId 用户ID
     * @param gameId 游戏ID
     */
    void startGame(long userId,long gameId,String gameNo);

    /**
     * 继续闯关
     * @param userId 用户ID
     * @param gameId 游戏ID
     * @param gameNo 游戏赛场编码
     */
    void continueGame(long userId,long gameId,String gameNo);

    /**
     * 复活
     * @param userId 用户ID
     * @param gameNo 游戏编码
     * @param round  当前关卡
     */
    Map<String, Object> recover(long userId,long gameId, String gameNo, int round);

    /**
     * 传递玩家叫骰（用户继续跟叫数）
     * @param userId 用户id
     * @param againstId 对手id
     * @param userId 游戏赛场编码
     * @param data 传递数据
     */
    void follow(long userId,long againstId,String gameNo,String data);

    /**
     * 玩家退出认输
     * @param userId
     */
    void giveUp(long userId,long againstId,String gameNo);

    /**
     * 比赛超时未叫骰
     * @param breakGameUserRecordsVo 用户比赛记录
     */
    void callNumberOvertime( GameBreakUserRecordsVo breakGameUserRecordsVo);

    /**
     * 玩家开骰
     * @param userId
     */
    void open(long userId,long againstId,String gameNo);

    /**
     * 表情
     * @param userId
     * @param againstId
     * @param gameNo
     */
    void emoticon(long userId, long againstId, String gameNo, String data);

    /**
     * 赢得单轮pk
     * @param userRecordsVo  当家玩家记录
     * @param againstRecordsVo 对手玩家记录
     */
    void win(GameBreakUserRecordsVo userRecordsVo,GameBreakUserRecordsVo againstRecordsVo,String resultCode);

    /**
     * 匹配对手
     * @param breakGameUserRecordsVo 当前玩家游戏信息
     */
    void match(GameBreakUserRecordsVo breakGameUserRecordsVo);

    /**
     * 计算骰子点数比赛PK结果
     * @param currentPlayerRandomNum 当前用户骰子点数
     * @param againstPlayerRandomNum 对手用户骰子点数
     * @param map  叫骰点数
     * @return
     */
    boolean compute(int currentPlayerRandomNum,int againstPlayerRandomNum,Map map,boolean hasCallOne);

    /**
     * 退出比赛(长时间等待匹配对手)
     * @param userId
     * @param gameNo
     */
    void quit(long userId,long gameId,String gameNo,boolean isBegin);

    /**
     * 结算游戏
     */
    void closeGame(Long gameId);

    /**
     * 开启新游戏
     */
    GameBreakRecords createNewGame(Long gameId);

    /**
     * 机器人匹配
     * @param paramMap
     */
    void robotMatch(Map paramMap);
}
