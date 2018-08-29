package com.artqiyi.dahuashai.common.constant;

import com.artqiyi.dahuashai.common.util.MessageHelper;

/**
 * 模板消息常量
 */
public class MsgModelConstant {
    /**
     * 交易流水REMARK模板
     */
    public static String BIND_PHONE_REMARK = "绑定手机";
    public static String BIND_INVITE_CODE_REMARK = "绑定邀请码";
    public static String DOUBLE_RACE_REMARK = "双人赛马";
    public static String BREAK_GAME_NOTICE_REMARK = "通关{}次";

    /**
     * 消息模板
     */
    public static String BIND_PHONE_NOTICE_TITLE = "绑定手机奖励";
    public static String BIND_PHONE_NOTICE_CONTENT = "您绑定了手机号：{}，获得奖励{}{}。";
    public static String BIND_INVITE_CODE_NOTICE_TITLE = "邀请码奖励";
    public static String BIND_INVITE_CODE_NOTICE_CONTENT = "您绑定了邀请码：{}，获得奖励{}{}。";

    /**
     * 双人赛马
     */
    public static String DOUBLE_RACE_NOTICE_TITLE = "{}  {}";
    public static String DOUBLE_RACE_NOTICE_CONTENT = "您在{}年{}月{}日参赛，最终成绩：{}强。";
    public static String DOUBLE_RACE_NOTICE_CONTENT_CHAMPION = "您在{}年{}月{}日参赛，最终成绩：冠军。";
    public static String DOUBLE_RACE_NOTICE_CONTENT_SECOND = "您在{}年{}月{}日参赛，最终成绩：亚军。";
    /**
     * 闯关游戏
     */
    public static String BREAK_GAME_NOTICE_TITLE = "闯关游戏";
    public static String BREAK_GAME_NOTICE_CONTENT = "您在{}年{}月{}日参加闯关游戏{}中,通关{}次,获得奖励{}元";

    /**
     * 短信模板
     */
    public static String SMS_MSG_MODEL = "{}为您的手机验证码，请于{}分钟内填写。如非本人操作，请忽略本短信。";


    public static void main(String[] args) {
        System.out.println(MessageHelper.generateByModel(MsgModelConstant.SMS_MSG_MODEL, 123456 + "", SystemConstant.EXPIRED_SECONDS / 60 + ""));
        System.out.println(MessageHelper.generateByModel(MsgModelConstant.BIND_PHONE_NOTICE_CONTENT, "17663556941", "50", "趣币"));
    }
}
