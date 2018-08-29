package com.artqiyi.dahuashai.common.constant;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/23
 * Modify On: 2018/4/23 by chencunjun
 */

/**
 * 提示信息常量
 */
public class MsgConstant {

    public static String FAIL_LOGIN_NO_MATCH = "账户密码不匹配";
    public static String SUCCESS_LOGIN = "登录成功";
    public static String SUCCESS_REGISTERED = "注册成功";

    public static String SUCCESS_SEARCH = "查询成功";
    public static String FAIL_SEARCH = "查询失败";
    public static String SUCCESS_LOGINOUT = "注销登陆成功";

    public static String NO_AUTH_PARAM = "身份验证参数缺失";
    public static String LOGIN_STATUS_INVAID = "登录状态失效";
    public static String APP_SIGN_FAIL = "数据签名无效";
    public static String APP_SIGN_OVERTIME = "数据签名过期";


    public static String SUCCESS_SAVE = "保存成功";
    public static String SUCCESS_DELETE = "删除成功";
    public static String FAIL_SAVE = "保存失败，请检查参数";
    public static String ID_NOT_FOUND = "参数ID不存在";

    //商品兑换
    public static String POINT_NOT_ENOUGH = "商品兑换失败，当前账户积分不足";
    public static String COIN_NOT_ENOUGH = "商品兑换失败，当前账户趣币不足";
    public static String BALANCE_NOT_ENOUGH = "商品兑换失败，当前账户余额不足";
    public static String SUCCES_EXCHANGE = "商品兑换成功";

    //奖品领取
    public static String SUCCES_PRIZE_RECEIVE = "奖品领取成功";
    public static String FAIL_PRIZE_HAS_RECEIVED = "奖品领取失败，奖品已领取";
    public static String SUCCES_PRIZE_DELIVER = "奖品发货成功";


    //比赛
    public static String SUCCES_SIGN_UP = "报名成功";
    public static String FAIL_SIGN_UP_COIN = "趣币不足";
    public static String FAIL_SIGN_UP_POINT = "积分不足";
    public static String FAIL_SIGN_UP_BALANCE = "红包不足";
    public static String FAIL_SIGN_UP_OTHER = "报名失败";
    public static String SUCCESS_QUIT_COIN = "退赛成功，趣币已退还";
    public static String SUCCESS_QUIT_POINT = "退赛成功，积分已退还";
    public static String SUCCESS_QUIT_BALANCE = "退赛成功，红包已退还";
    public static String SUCCESS_QUIT_FREE_PLAY_TIMES = "退赛成功，试玩次数已退还";
    public static String FAIL_QUIT = "退赛失败";
    public static String SUCCESS_ADVANCED = "恭喜晋级";
    public static String FAIL_ADVANCED = "很遗憾，你被淘汰了";

    public static String GAME_NOTICE_MATCHING = "正在匹配对手，请稍后";//正在匹配
    public static String GAME_NOTICE_BEGIN = "即将开始";//即将开始
    public static String GAME_NOTICE_ROBOT_REACH_TRACK_SCORE = "机器人达到赛道终点";
    public static String GAME_NOTICE_LACK_OF_MACHINE = "机器正忙，请等待片刻";
    public static String GAME_NOTICE_GAME_CANCLE = "机器繁忙，请稍候再游戏";
    public static String GAME_NOTICE_GAME_CANCLE_FREE = "机器正忙，请稍候游戏，试玩次数已退还";
    public static String GAME_NOTICE_GAME_CANCLE_COIN = "机器正忙，请稍候游戏，趣币已退还";
    public static String GAME_NOTICE_GAME_CANCLE_POINT = "机器正忙，请稍候游戏，积分已退还";
    public static String GAME_NOTICE_GAME_CANCLE_BALANCE = "机器正忙，请稍候游戏，红包已退还";


    //绑定邀请码
    public static String USER_NOT_EXIST = "用户不存在";
    public static String BIND_INVITE_CODE_FAIL_NOT_EXIST = "邀请码不存在";
    public static String BIND_INVITE_CODE_FAIL_NOT_BY_OTHER = "不能自己邀请自己";
    public static String BIND_INVITE_CODE_FAIL_REPEAT_BIND = "该用户已绑定过邀请码";
    public static String BIND_INVITE_CODE_SUCCESS = "绑定邀请码成功";
    public static String BIND_INVITE_CODE_FAIL = "绑定邀请码失败";

    //绑定手机号
    public static String BIND_PHONE_SEND_SMS_SUCCESS = "短信验证码发送成功";
    public static String BIND_PHONE_SEND_SMS_FAIL = "短信验证码发送失败";
    public static String BIND_PHONE_FAIL_INVALID_PHONE_NUMBER = "手机号格式不正确";
    public static String BIND_PHONE_FAIL_SMS_EXPIRED = "验证码已失效";
    public static String BIND_PHONE_FAIL_SMS_ERROR = "验证码错误";
    public static String BIND_PHONE_FAIL_REPEAT_BIND = "已经绑定过手机号";
    public static String BIND_PHONE_FAIL_REPEAT_PHONE_BIND = "该手机号已绑定过其他账号";
    public static String BIND_PHONE_SUCCESS = "绑定手机成功";

    //登录or注册
    public static String PHONE_NOT_REGISTERED = "该手机号未注册";
    public static String PHONE_REGISTERED = "手机号已被注册";
    public static String BIND_PHONE_FAIL_SMS_EXCEEDED = "该手机号在24h之内发送超过5条短信";

    //绑定支付宝帐号
    public static String BIND_ALIPAY_SUCCESS = "支付宝绑定成功";
    public static String BIND_ALIPAY_FAIL_PARAM = "帐号或姓名不能为空";
    public static String BIND_ALIPAY_FAIL_REPEAT_BIND = "您已经绑定过支付宝";
    public static String BIND_ALIPAY_FAIL_USER_NOT_EXIST = "用户不存在";


    //提现
    public static String WITHDRAW_APPLY_SUCCESS = "申请提现成功";
    public static String WITHDRAW_FAIL_AMOUNT = "当前无可提现金额，无法提现";
    public static String WITHDRAW_FAIL_PHONE = "为了您的资金安全，请先绑定手机";
    public static String WITHDRAW_FAIL_ACCOUNT = "绑定提现支付宝";

    //游戏复活
    public static String SUCCES_RECOVER = "复活成功";
    public static String FAIL_RECOVER = "复活失败";

    //机器报障
    public static String REPORT_FAULT_SUCCESS = "故障上报成功";



    //===============================大话骰新增===========================
    public static final String SUCCESS_FRIEND_ASSISTANCE = "好友助力成功";
    public static final String SUCCESS_dahuashai_BEGIN = "游戏成功开始";
    public static final String SUCCESS_dahuashai_END = "游戏成功结算";
}
