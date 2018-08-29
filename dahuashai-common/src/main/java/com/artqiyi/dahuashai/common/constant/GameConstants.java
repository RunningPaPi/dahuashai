package com.artqiyi.dahuashai.common.constant;

/**
 * 游戏常量类
 */
public class GameConstants {

    //游戏key
    public static final String DHS_GAME_MODEL_KEY_SINGLE = "DHS_SINGLE_MODEL";//游戏模式-单机模式
    public static final String DHS_FIGHT_MODEL = "DHS_FIGHT_MODEL";//游戏模式-好友对战
    public static final String DHS_BREAK_MODEL = "DHS_BREAK_MODEL";//游戏模式-闯关模式
    //游戏配置code
    public final static String DHS_BREAK_MODEL_SYSTEM = "DHS_BREAK_MODEL_SYSTEM";//
    public final static String DHS_BREAK_MODEL_GAME_RULE = "DHS_BREAK_MODEL_GAME_RULE";//
    public final static String BREAK_RULE = "BREAK_RULE";//
    public final static String MONEY = "MONEY";//游戏奖池
    public final static String TIME = "TIME";//游戏奖励发放时间
    public final static String CHEAT = "CHEAT";//作弊(后台添加的通关人数)
    public final static String CONTEST = "CONTEST";//参与人数基数
    public final static String LEVEL = "LEVEL";//关卡数
    public final static String POSTER_URL = "POSTER_URL";//
    public static final String BONUS_MAX = "BONUS_MAX";//最大红包金额
    public static final String BONUS_MIN = "BONUS_MIN";//最小红包金额
    public static final String BONUS_MAX_TO_ONE = "BONUS_MAX_TO_ONE";//每个人的最大奖励金额
    public static final String SHARE_TIMES = "SHARE_TIMES";//分享次数
    public static final String WATCH_AD_TIMES = "WATCH_AD_TIMES";//看视频次数
    public static final String RECOVER_WAY = "RECOVER_WAY";//分享次数
    /**
     * 骰子个数
     */
    public static final int TOTAL_DICE_NUM = 5;//分享次数
    /**
     * 游戏消耗类型
     */
    public final static Short GAME_COST_TYPE_1 = 1;//趣币
    public final static Short GAME_COST_TYPE_2 = 2;//钻石
    public final static Short GAME_COST_TYPE_3 = 3;//红包

    /**
     * 游戏状态
     */

    public final static Short GAME_STATUS_INVALID = 0;//无效
    public final static Short GAME_STATUS_VALID = 1;//正常

    /**
     * 比赛状态
     */
    public final static short GAME_STATUS_0 = 0;//比赛状态：0.未开赛 1.比赛中 2.比赛结束
    public final static short GAME_STATUS_1 = 1;//比赛状态：0.未开赛 1.比赛中 2.比赛结束
    public final static short GAME_STATUS_2 = 2;//比赛状态：0.未开赛 1.比赛中 2.比赛结束

    /**
     * 游戏排名
     */
    public final static String WAY_OF_RANK_WEEK = "week";
    public final static String WAY_OF_RANK_ALL = "all";

    /**
     * 定时任务阈值
     */
    public final static int THRESHOLD = 0;//分钟

}
