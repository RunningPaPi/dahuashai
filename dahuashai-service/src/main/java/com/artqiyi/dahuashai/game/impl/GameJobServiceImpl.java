package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.common.constant.GameConstants;
import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.game.IGameConfigService;
import com.artqiyi.dahuashai.game.IGameJobService;
import com.artqiyi.dahuashai.game.domain.GameBreakRecords;
import com.artqiyi.dahuashai.game.domain.GameModel;
import com.artqiyi.dahuashai.game.vo.GameBreakUserRecordsVo;
import com.artqiyi.dahuashai.game.vo.GameFightUserRecordsVo;
import com.artqiyi.dahuashai.job.domain.ScheduleJob;
import com.artqiyi.dahuashai.service.IQuartzService;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 游戏相关定时任务
 */
@Service
public class GameJobServiceImpl implements IGameJobService{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IQuartzService quartzService;
    @Autowired
    private IGameConfigService gameConfigService;

    private static int OVERTIME=30;//超时时间

    /**
     * 保存好友对战游戏数据任务
     */
    public void saveFightGameData(){
        logger.info("【大话骰结算】 设置保存好友对战游戏数据任务");
        ScheduleJob job = new ScheduleJob();
        job.setClazzName(null);
        job.setIsConcurrent(false);
        job.setCronExpression("0 0 0 * * ?");
        job.setDescription("save fight game data");
        job.setIsSpringbean(true);
        job.setJobGroup("fightGameData");
        job.setJobName("saveData4FightGame");
        job.setJobstatus(SystemConstant.TASK_STATUS_READY);
        job.setTargetMethod("saveData");
        job.setTargetObject("gameFightService");

        quartzService.addJob(job);
        logger.info("【大话骰结算】 设置保存好友对战游戏数据任务完毕");
    }

    /**
     * 闯关游戏用户超时监测任务
     * @param player
     */
    @Override
    public void fightGameOvertimeTask(GameFightUserRecordsVo player) {
        removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, player.getRoomNo() + player.getUserId());
        logger.info("设置闯关大话骰游戏--" + player.getNickName() + " -叫骰超时任务");
        ScheduleJob job = new ScheduleJob();
        job.setClazzName(null);
        job.setIsConcurrent(false);
        String cronExp = DateUtil.formatDate(DateUtils.addSeconds(new Date(), OVERTIME), DateUtil.CRON_FORMAT);
        job.setCronExpression(cronExp);
        job.setDescription("大话骰游戏叫骰超时任务");
        job.setIsSpringbean(true);
        job.setJobGroup(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME);
        job.setJobName(player.getRoomNo() + player.getUserId());
        job.setJobstatus(SystemConstant.TASK_STATUS_READY);
        job.setTargetMethod("callNumberOvertime");
        job.setTargetObject("gameFightService");
        job.setParam(player);
        quartzService.addJob(job);
    }


    /**
     * 闯关游戏用户超时监测任务
     * @param gameBreakUserRecordsVo
     */
    @Override
    public void breakGameOvertimeTask(GameBreakUserRecordsVo gameBreakUserRecordsVo) {
        removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, gameBreakUserRecordsVo.getGameNo() + gameBreakUserRecordsVo.getUserId());
        logger.info("设置闯关大话骰游戏--" + gameBreakUserRecordsVo.getNickName() + " -叫骰超时任务");
        ScheduleJob job = new ScheduleJob();
        job.setClazzName(null);
        job.setIsConcurrent(false);
        String cronExp = DateUtil.formatDate(DateUtils.addSeconds(new Date(), OVERTIME), DateUtil.CRON_FORMAT);
        job.setCronExpression(cronExp);
        job.setDescription("大话骰游戏叫骰超时任务");
        job.setIsSpringbean(true);
        job.setJobGroup(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME);
        job.setJobName(gameBreakUserRecordsVo.getGameNo() + gameBreakUserRecordsVo.getUserId());
        job.setJobstatus(SystemConstant.TASK_STATUS_READY);
        job.setTargetMethod("callNumberOvertime");
        job.setTargetObject("gameBreakService");
        job.setParam(gameBreakUserRecordsVo);
        quartzService.addJob(job);
    }

    /**
     * 机器人匹配
     * @param breakGameUserRecordsVo
     * @param time
     */
    @Override
    public void robotMacthTask(GameBreakUserRecordsVo breakGameUserRecordsVo, int time) {
        removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_ROBOT_MATCH, breakGameUserRecordsVo.getGameNo() + breakGameUserRecordsVo.getUserId());
        Map paramMap=new HashMap();
        paramMap.put("breakGameUserRecordsVo",breakGameUserRecordsVo);
        logger.info("设置闯关大话骰游戏--" + breakGameUserRecordsVo.getNickName() + " -匹配机器人任务");
        ScheduleJob job = new ScheduleJob();
        job.setClazzName(null);
        job.setIsConcurrent(false);
        String cronExp = DateUtil.formatDate(DateUtils.addMilliseconds(new Date(), time), DateUtil.CRON_FORMAT);
        job.setCronExpression(cronExp);
        job.setDescription("大话骰游戏匹配机器人任务");
        job.setIsSpringbean(true);
        job.setJobGroup(SystemConstant.TASK_GROUP_BREAK_GAME_ROBOT_MATCH);
        job.setJobName(breakGameUserRecordsVo.getGameNo() + breakGameUserRecordsVo.getUserId());
        job.setJobstatus(SystemConstant.TASK_STATUS_READY);
        job.setTargetMethod("robotMatch");
        job.setTargetObject("gameBreakService");
        job.setParam(paramMap);
        quartzService.addJob(job);
    }


    /**
     * 游戏结算任务移除
     * @param groupName
     * @param JobName
     */
    @Override
    public void removeGameJob(String groupName, String JobName) {
        ScheduleJob jobForEnd = new ScheduleJob();
        jobForEnd.setJobName(JobName);
        jobForEnd.setJobGroup(groupName);
        quartzService.deletJob(jobForEnd);
    }




    /**
     * 创建结算定时任务
     *
     * @param params
     */
    public void addCloseBreakGameJob(Map<String, Object> params) {
        GameModel game = (GameModel) params.get("game");
        GameBreakRecords gameRecord = (GameBreakRecords) params.get("gameRecord");

        Map<String, String> configs = gameConfigService.getByGameModelKey(game.getGameModelKey());
        String awardTime = configs.get(GameConstants.TIME);
        if (awardTime == null) {
            logger.error("【定时任务】结算定时任务，系统参数表break_game_config未配置参数BIG_BONUS_SYSTEM_TIME");
            throw new RuntimeException("【定时任务】结算定时任务，系统参数表break_game_config未配置参数'开奖时间'");
        }

        String cronExp = getCron(awardTime);
        logger.info("【定时任务】 结算cron={}",cronExp);

        //格式"0 0 21 1 6 ? 2018"-- 2018年6月1号21点0分0秒触发任务
        logger.info("【大话骰结算】 设置" + game.getGameModelName() + "结算任务");
        ScheduleJob job = new ScheduleJob();
        job.setClazzName(null);
        job.setIsConcurrent(false);
        job.setCronExpression(cronExp);
        job.setDescription("closeBreakGame");
        job.setIsSpringbean(true);
        job.setJobGroup(SystemConstant.TASK_GROUP_BREAK_GAME_CLOSE);
        job.setJobName(gameRecord.getGameNo());
        job.setJobstatus(SystemConstant.TASK_STATUS_READY);
        job.setTargetMethod("closeGame");
        job.setTargetObject("gameBreakService");
        job.setParam(game.getId());
        quartzService.addJob(job);
        logger.info("【大话骰结算】 设置" + game.getGameModelName() + "结算任务完毕");
    }

    /**
     * 获取cron
     *
     * @param awardTime
     * @return
     */
    private static String getCron(String awardTime) {
        DateTime time = new DateTime();
        int hour = time.getHourOfDay();
        int minute = time.minuteOfHour().get();
        DateTime plusDays = time.plusDays(1);
        String cron = "ss mm HH dd MM ? yyyy";
        //默认次日21点
        String cronExp = null;


        String[] split = awardTime.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        //如果当前时间小于定时任务配置的时间,在当天开启结算任务
        if (hour < h || (hour == h && m - minute > GameConstants.THRESHOLD)) {
            cronExp = cron.replace("yyyy", time.getYear() + "")
                    .replace("MM", time.getMonthOfYear() + "")
                    .replace("dd", time.getDayOfMonth() + "")
                    .replace("HH", h + "")
                    .replace("mm", m + "")
                    .replace("ss", "0");
        } else {
            //否则第二天结算
            cronExp = cron.replace("yyyy", plusDays.getYear() + "")
                    .replace("MM", plusDays.getMonthOfYear() + "")
                    .replace("dd", plusDays.getDayOfMonth() + "")
                    .replace("HH", h + "")
                    .replace("mm", m + "")
                    .replace("ss", "0");
        }

        return cronExp;
    }

}
