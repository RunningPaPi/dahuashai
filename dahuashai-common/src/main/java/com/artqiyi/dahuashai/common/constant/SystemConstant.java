package com.artqiyi.dahuashai.common.constant;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/25
 * Modify On: 2018/4/25 by chencunjun
 */

/**
 * 系统常量
 */
public class SystemConstant {

    /*
    * 用户注册方式
     */
    public static short REGISTE_PHONE=1; //手机注册
    public static short REGISTE_EMAIL=2; //邮箱注册
    public static short REGISTE_WEIXIN=3; //微信注册
    public static short REGISTE_QQ=4;    //qq注册

    public static short LOGIN_FAIL_LOCK=1;    //登录失败，账号被锁定
    public static short LOGIN_FAIL_PHONE_NO_REGISTER=2;    //登录失败，手机号未注册
    public static short LOGIN_FAIL_PASSWORD_NO_MATCH=3;    //登录失败，账号密码不匹配
    public static short LOGIN_FAIL_VALIDATECODE_ERROR=4;    //登录失败，手机验证码错误
    public static short LOGIN_FAIL_VALIDATECODE_OVERTIME=5;    //登录失败，手机验证码过期

    /**
     * 信息状态
     */
    public static short VALID=1; //有效
    public static short INVALID=0; //无效

    /**
     * 奖品类型
     */
    public static short PRIZE_POINT=1; //兑换奖品
    public static short PRIZE_GAME=2; //游戏奖品

    /**
     * 任务状态
     */
    public static short TASK_STATUS_VAILD=-2; //无效
    public static short TASK_STATUS_FAIL=-1;  //执行失败
    public static short TASK_STATUS_READY=0;  //准备就绪
    public static short TASK_STATUS_RUN=1;   //执行中
    public static short TASK_STATUS_SUCCESS=2; //执行失成功
    /**
     * 任务分组
     */
    public static String TASK_GROUP_GAME_MATCH="game_match";  //比赛匹配
    public static String TASK_GROUP_GAME_ROBOT_REACH_TRACK_SCORE="game_robot_reach_track_score"; //机器人到达跑马线结算
    public static String TASK_GROUP_SEND_MESSAGE="game_send_msg";  //比赛匹配
    public static String TASK_GROUP_REDPACK_GROUP_TASK_ROTATION = "redpack_group_task_rotation";//红包提现组合任务每天轮询任务
    public static String TASK_GROUP_GAME_END = "game_end";
    public static String TASK_GROUP_BREAK_GAME_PK = "break_game_pk";
    public static String TASK_GROUP_BREAK_GAME_OVERTIME = "break_game_overtime"; //
    public static String TASK_GROUP_DEPOSIT_ORDER_CHECK_TASK = "deposit_order_check";//充值订单定时检查任务
    public static final String TASK_GROUP_WITHDRAW_ORDER_CHECK_TASK = "withdraw_order_check";//提现订单定时检查任务

    /**
     * 账户类型
     */
    public  static final Integer ACC_TYPE_GOLDCOIN=1;//趣币
    public  static final Integer ACC_TYPE_SCORE=2;//积分
    public  static final Integer ACC_TYPE_BALANCE=3;//红包

    /**
     * 订单状态
     */
    public  static final Integer ORDER_PAY_STAT_UNDER_AUDIT=0;//待审核状态
    public  static final Integer ORDER_PAY_STAT_WAIT=1;
    public  static final Integer ORDER_PAY_STAT_SUCESS=2;
    public  static final Integer ORDER_PAY_STAT_CANCEL=3;
    //支付折扣
    public static final String ORDER_DISCOUNT = "0";//订单折扣
    //支付有效时间1个小时
    public static final int ORDER_PAY_EXPIRED_HOURS = 1;
    //支付渠道
    public static final int PAY_CHANNEL_ALIPAY = 1;//支付宝
    public static final int PAY_CHANNEL_WXAPP = 2;//微信app
    public static final int PAY_CHANNEL_WXAPPLET = 3;//微信小程序

    /**
     * 1,趣币,2积分，3红包
     */
    public  static final Integer VIR_PROD_TYPE_GOLD=1;
    public  static final Integer VIR_PROD_TYPE_SCORE=2;
    public  static final Integer VIR_PROD_TYPE_BALANCE=3;

    /**
     * 交易类型
     */
    public  static final String TRANS_TYPE_DEPOSIT="TRANS_TYPE_DEPOSIT";//充值
    public  static final String TRANS_TYPE_DEPOSIT_REWARD="TRANS_TYPE_DEPOSIT_REWARD";//充值奖励
    public  static final String TRANS_TYPE_INVITED_REWARD="TRANS_TYPE_INVITED_REWARD";//绑定邀请码奖励
    public  static final String TRANS_TYPE_INVITOR_REWARD="TRANS_TYPE_INVITOR_REWARD";//邀请成功奖励
    public  static final String TRANS_TYPE_PHONE_REWARD="TRANS_TYPE_PHONE_REWARD";//绑定手机号奖励
    public  static final Integer TRANS_DIRECT_INCOM=1;//交易方向, 收入
    public  static final Integer TRANS_DIRECT_OUTCOME=2;//交易方向,支出
    public  static final String TRANS_TYPE_PLAY_GAME="TRANS_TYPE_PLAY_GAME";//玩游戏奖励
    public  static final String TRANS_TYPE_SIGNUP="TRANS_TYPE_SIGNUP";//报名
    public  static final String TRANS_TYPE_QUIT="TRANS_TYPE_QUIT";//退赛
    public  static final String TRANS_TYPE_WITHDRAW_APPLY="TRANS_TYPE_WITHDRAW_APPLY";//申请提现
    public  static final String TRANS_TYPE_REGISTER_GRANT = "TRANS_TYPE_REGISTER_GRANT";//首次注册登录获得奖励
    public  static final String TRANS_TYPE_SIGN_REWARD = "TRANS_TYPE_SIGN_REWARD";//签到获得奖励
    public  static final String TRANS_TYPE_DISTRIBUTE_REWARD = "TRANS_TYPE_DISTRIBUTE_REWARD";//分销模块中获得的红包奖励
    public  static final String TRANS_TYPE_DEPOSIT_AWARD_FOR_INVITOR = "TRANS_TYPE_DEPOSIT_AWARD_FOR_INVITOR";//下线充值时给与邀请人的奖励
    public  static final String TRANS_TYPE_BREAK_GAME_RECOVER = "TRANS_TYPE_BREAK_GAME_RECOVER";//闯关游戏复活
    public  static final String TRANS_TYPE_AWARD_FOR_FINISH_TASK = "TRANS_TYPE_DEPOSIT_AWARD_FOR_FINISH_TASK";//领取任务奖励
    public  static final String TRANS_TYPE_GOOD_EXCHANGE = "TRANS_TYPE_GOOD_EXCHANGE";//商品兑换

    public static final String TRANS_TYPE_WITHDRAW = "TRANS_TYPE_WITHDRAW";//提现
    public static final String TRANS_TYPE_WITHDRAW_TRANSFER_FAILED = "TRANS_TYPE_WITHDRAW_TRANSFER_FAILED";//提现转账失败

    /**
     * 奖励方式
     */
    public static final String COIN_INVITED_CODE = "COIN_INVITED_CODE";//被邀请者通过绑定邀请码获得的奖励
    public static final String COIN_INVITOR_CODE = "COIN_INVITOR_CODE";//邀请者在他人绑定邀请码时获得的奖励
    public static final String COIN_REGISTER_CODE = "COIN_REGISTER_CODE";//注册奖励
    public static final String COIN_BIND_PHONE = "COIN_BIND_PHONE";//绑定手机号奖励

    /**
     * 短信验证码过期时间
     */
    public static final Integer EXPIRED_SECONDS = 600;//秒
    public static final Integer INTERVAL_SECONDS = 60;//秒 重新发送验证码的间隔
    public static final Integer SMS_SEND_LIMIT = 24*60*60;//一天之内只能发送5次

    /**
     * 系统通知类型
     */
    public static final Integer SYSTEM_NOTICE_TYPE1 = 1;//系统通知
    public static final Integer SYSTEM_NOTICE_TYPE2 = 2;//玩游戏

    /**
     * 系统通知状态
     */
    public static final Integer SYSTEM_NOTICE_STATUS_TOBE_READ = 0;//未读
    public static final Integer SYSTEM_NOTICE_STATUS_ALREADY_READ = 1;//已读

    /**
     * 联系方式
     */
    public static final String CONTACT_WECHAT = "CONTACT_WECHAT";//微信
    public static final String CONTACT_EMAIL = "CONTACT_EMAIL";//邮箱

    /**
     * 邀请码长度
     */
    public static final Integer INVITE_CODE_LENGTH = 6;
    /**
     * 验证码长度
     */
    public static final Integer SMS_CODE_LENGTH = 6;
    /**
     * 24h内短信发送次数
     */
    public static final Integer SMS_SEND_TIMES = 5;

    /**
     * 用户随机编号长度
     */
    public static final Integer USER_RANDOM_NO = 6;
    
    /**
     * 任务有关
     */
    
    public static final String TASK_TYPE_BIND_MOBILE = "BindMobile";//绑定手机
    public static final String TASK_TYPE_AUTHENT = "Authenticate";//实名认证
    public static final String TASK_TYPE_BIND_INVITE = "BindInviteCode";//绑定邀请码
    public static final String TASK_TYPE_FIRST_EXCHANGE = "ExchangeGood";//首次兑换
    public static final String TASK_TYPE_CHANGE_NICK = "ChangeNick";
    public static final String TASK_TYPE_CHANGE_AVATAR = "ChangeAvatar";
    public static final String TASK_TYPE_FIRST_DEPOSIT = "FirstDeposited";
    public static final String TASK_TYPE_FIRST_CONSUME = "FirstConsume";
    public static final String TASK_TYPE_ACCUMULATE_CONSUME = "AccumulateConsume";
    public static final String TASK_TYPE_WIN_SHARE = "WinShare";
    public static final String TASK_TYPE_LOGIN_NIGHT = "LoginNight";
    public static final String TASK_TYPE_LOGIN_MIDDLE = "LoginMiddle";

    public static final Short  TASK_TYPE_ATTR_DAILY_=0;//每日任务
    public static final Short  TASK_TYPE_ATTR_ONLYONCE=1;//一次性新手任务
    public static final Short  TASK_TYPE_CATALOG_NORMAL=1;//普通任务
    public static final Short  TASK_TYPE_CATALOG_GAME=2;//游戏类任务
    public static final Short  TASK_TYPE_CATALOG_BREAK_GAME=3;//闯关游戏类任务
    public static final Short  TASK_STAT_NOFINISHED=0;//已经完成未领取;
    public static final Short  TASK_STAT_FINISHED=1;//已经完成未领取;
    public static final Short  TASK_STAT_AACPT=2;//已经完成已领取;
    public static final Short  TASK_AWARD_TYPE_COIN=1;//奖励趣币
    public static final Short  TASK_AWARD_TYPE_SCORE=2;//奖励积分
    public static final Short  TASK_AWARD_TYPE_HONGBAO=3;//奖励红包
    public static final Short  TASK_DISP_HIDDEN=0;//任务初始隐藏
    public static final Short  TASK_DISP_RENDER=1;//任务初始显示

    //红包任务
    public static final String REDPACK_GROUP_TASK_ROTATION_TRIGGER="0 0 0 * * ?";//每天0时，轮询任务
    //public static final String REDPACK_GROUP_TASK_ROTATION_TRIGGER="0 0/2 * * * ?";//测试
    //大话骰结算任务
    public static final String BREAK_GAME_TASK_ROTATION_TRIGGER="0 0 21 * * ?";//每天21时，轮询任务
    //充值订单检查任务
    public static final String DEPOSIT_ORDER_CHECK_TASK_TRIGGER = "0 0/5 * * * ?";//每隔5分钟检查
    //提现订单检查任务
    public static final String WITHDRAW_ORDER_CHECK_TASK_TRIGGER = "0 0/5 * * * ?";//每隔5分钟检查;

    /**
     * 提现相关
     */
    public static final Short WITHDRAW_STATE_APPLYING = 0;//新申请
    public static final Short WITHDRAW_STATE_AUDITED = 1;//审核通过
    public static final Short WITHDRAW_STATE_PAYED = 2;//已经支付


    /**
     * 红包分销模块相关
     */
    public static final int SHARE_AWARD_NUM = 1000;//首次通过分享链接邀请好友获得红包数 10元 即1000分
    public static final int FIRST_HELP_AWARD_NUM = 200; //好友第一次完成提现任务,分享者获得的红包数
    public static final int SECOND_HELP_AWARD_NUM = 300; //好友第二次完成提现任务,分享者获得的红包数
    public static final int THIRD_HELP_AWARD_NUM = 500; //好友第三次完成提现任务,分享者获得的红包数

    public static final String DEPOSIT_AWARD_PERCENT_FOR_INVITOR = "DEPOSIT_AWARD_PERCENT_FOR_INVITOR";//充值趣币抽佣字典code

    /**
     * 游戏状态
     */
    public static final Short GAME_READY = 0;//玩游戏
    public static final Short GAME_RUN = 1;//玩游戏
    public static final Short GAME_FINISH = 2;//玩游戏

    /**
     * 新用户赠送红包配置
     */
    public static long REGISTER_REWARD_REDPACK_NUM = 500;//首次注册登录获得5元红包 单位为分
    /**
     * 充值满特定金额，才给邀请人发放金额
     */
    public static final Integer DEPOSIT_MIN_AMOUNT_FOR_INVITOR = 1000;//单位为分

    /**
     * 用户登录判定中午与晚间时间点
     */
    public static final int USER_LOGIN_GAME_NOON_BEGIN_HOUR=12;
    public static final int USER_LOGIN_GAME_NOON_END_HOUR = 14;
    public static final int USER_LOGIN_GAME_NIGHT_BEGIN_HOUR=18;
    public static final int USER_LOGIN_GAME_NIGHT_END_HOUR=21;
    /**
     * 用户分享
     */
    public static final String USER_SHARE_TYPE_DEFAULT="link";//分享类型，默认类型 link  可选 music video
    public static final Short USER_SHARE_CONTENT_TYPE_GAME_FINISHED = 1; //分享内容类型：游戏结束后分享

    //banner默认显示个数，如果没有配置到redis中，显示4个
    public static final Integer BANNER_LIST_DEFAULT_PAGESIZE = 4;

    /**
     * 趣电玩系统配置相关
     */
    public static final String DEFAULT_HEAD_URL = "DEFAULT_HEAD_URL";//系统默认头像


//================================================================dhs新增=====================================
    /**
     * redis锁过期时间
     */
    public static final int REDIS_LOCK_EXPIRE_TIME_WITHDRAW_ORDER_CHECK = 3*60*1000;//提现订单检查过期时间，单位为毫秒
    public static final String GAME_BREAK_MODEL_KEY="DHS_BREAK_MODEL";//闯关模式
    public static String TASK_GROUP_BREAK_GAME_ROBOT_MATCH = "break_game_robot_match"; //大话骰机器人匹配任务

    public static final String TASK_GROUP_BREAK_GAME_CLOSE = "TASK_GROUP_BREAK_GAME_CLOSE";

}
