package com.artqiyi.dahuashai.common.constant;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/23
 * Modify On: 2018/4/23 by chencunjun
 */

/**
 * redis缓存命名空间常量
 */
public class RedisFiledConstant {

    public static String FILED_USER = "user_info";      //用户信息
    public static String FILED_VALIDATE = "user_validate_code"; //用户注册码
    public static String DIC_AREA = "dic_area";      //地区码表
    public static String DIC_INFO = "dic_info";      //字典码表
    public static final String USER_OPEN_ID = "dhs_user_open_id";//用户openid
    public static final String GAME_BOX_USER = "game_box_user";//用户openid

    public static String GAME_MESSAGE_TASK = "dhs_game_message_task";//用户消息推送

    public static String BREAK_GAME_RECORD = "dhs_break_game_record";//闯关比赛当前赛场记录
    public static String BREAK_GAME_USER_RECORD = "dhs_break_game_user_record";//闯关比赛当前赛场用户记录
    public static String BREAK_GAME_NOT_MATCH_PLAYER = "dhs_break_game_no_match_player";//闯关比赛当前赛场未匹配的玩家
    public static String BREAK_GAME_WAIT_PLAYER = "dhs_break_game_wait_player";//闯关比赛赢得关卡后等到开始的玩家
    public static String BREAK_GAME_PASS_RECORD = "break_game_pass_record";

    //大话骰对战模式
    public static String DHS_FIGHT_ROOM = "dhs_fight_room";//房间
    public static String DHS_GAME_FIGHT_RECORD = "dhs_game_fight_record";//对战数据
    public static String DHS_GAME_FIGHT_USER_RECORD = "dhs_game_fight_user_record";//用户数据
    public static String DHS_FIGHT_USER_RECORD = "dhs_fight_user_record";//比赛数据
    public static String DHS_FIGHT_USER_ROOM = "dhs_user_room";//用户对应的房间号
    public static String DHS_ENTER_ROOM = "dhs_fight_enter_room:";//房间

    /**
     * 登录相关
     */
    public static String LOGIN_PASSWORD_FAIL = "login_password_fail";//用户登录错误次数
    public static String LOGIN_ACCOUNT_LOCK = "login_account_lock";//用户登录锁定
    public static final String USER_SESSION_KEY = "user_session_key:";//session_key

    /**
     * 邀请有礼
     */
    public final static String INVATE_PRIZE = "invate_prize";//邀请有礼

    //================================================================大话骰新增=====================================
    public static final String dahuashai_GAME_MODEL_SINGLE_BALLNUM_AWARD = "dahuashai_game_model_single_ballNum_award";
    public static final String CREATE_BREAK_GAME_LOCK = "create_dhs_break_model_lock";
    public static final String CLOSE_BREAK_GAME_LOCK = "close_dhs_break_model_lock";
    public static final String USER_FORM_ID = "dhs_user_form_id";//微信推送消息专用


//================================================================dhs新增=====================================
    /**
     * redis锁 key
     */
    public static final String REDIS_LOCK_TASK_WITHDRAW_ORDER_CHECK = "REDIS_LOCK_TASK_ORDER_CHECK";//订单查询任务



}
