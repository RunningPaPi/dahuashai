package com.artqiyi.dahuashai.common.socket;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/8
 * Modify On: 2018/5/8 by chencunjun
 */

/**
 * sockect常量
 */
public class SocketConstant {
    /**
     * 闯关比赛socket相关操作
     */
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_END="dhs_beark_game_end"; //比赛结束
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_BEGIN="dhs_beark_game_begin"; //比赛开始
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_CONTINUE="dhs_beark_game_continue"; //继续闯关
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_GIVE_UP="dhs_beark_game_give_up"; //放弃比赛
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_RECOVER="dhs_beark_game_recover"; //比赛复活
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_RESULT="dhs_beark_game_result"; //比赛结果
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_EMOTICON="dhs_beark_game_emoticon"; //表情
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_CALL_NUMBER_OVERTIME="dhs_break_game_call_number_overtime" ;//比赛叫骰超时
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_QUIT_WAIT="dhs_beark_game_quit_wait"; //退出等待
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_FOLLOW="dhs_beark_game_follow"; //比赛跟叫数
    public static  final String SOCKET_OPERATE_SEND_BREAK_GAME_OPEN="dhs_beark_game_open"; //开骰

    /**
     * 好友对战比赛socket相关操作
     */
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_CREATE_ROOM="dhs_fight_game_create_room"; //创建房间
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM="dhs_fight_game_enter_room"; //加入房间
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM_FAIL="dhs_fight_game_enter_room_fail"; //加入房间失败
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_START ="dhs_fight_game_start"; //比赛开始
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_EMOTICON="dhs_fight_game_emoticon"; //表情
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_RESULT="dhs_fight_game_result"; //比赛结果
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_GIVE_UP="dhs_fight_game_give_up"; //放弃比赛
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_FOLLOW="dhs_fight_game_follow"; //比赛数据
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_AGAIN="dhs_fight_game_again"; //再来一局
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_LEAVE="dhs_fight_game_leave"; //离开
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_OVERTIME="dhs_fight_game_overtime" ;//比赛超时未叫骰
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_QUIT_WAIT="dhs_fight_game_quit_wait"; //退出等待
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_END="dhs_fight_game_end"; //比赛结束
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_OPEN="dhs_fight_game_open"; //开骰
    public static  final String SOCKET_OPERATE_SEND_FIGHT_GAME_OFFLINE="dhs_fight_game_offline"; //掉线

}
