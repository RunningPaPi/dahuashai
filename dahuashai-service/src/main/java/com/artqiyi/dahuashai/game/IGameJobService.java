package com.artqiyi.dahuashai.game;

import com.artqiyi.dahuashai.game.vo.GameBreakUserRecordsVo;
import com.artqiyi.dahuashai.game.vo.GameFightUserRecordsVo;

import java.util.Map;

/**
 * 游戏相关任务
 */
public interface IGameJobService {
    void fightGameOvertimeTask(GameFightUserRecordsVo gameFightUserRecordsVo);
    void breakGameOvertimeTask(GameBreakUserRecordsVo gameBreakUserRecordsVo);
    void removeGameJob(String groupName, String JobName);
    void robotMacthTask(GameBreakUserRecordsVo breakGameUserRecordsVo,int time);
    void addCloseBreakGameJob(Map<String, Object> params);
    void saveFightGameData();
}
