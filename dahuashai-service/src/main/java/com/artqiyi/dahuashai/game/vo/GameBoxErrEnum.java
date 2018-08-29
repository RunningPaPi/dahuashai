package com.artqiyi.dahuashai.game.vo;

public enum GameBoxErrEnum {
    SUCCESS(0, "成功"),
    MISS_SIGN(-1, "没有携带签名"),
    ERR_SIGN(-2, "签名不正确"),
    MISS_UID(-3, "没有uid"),
    MISS_GID(-4, "没有gid"),
    MISS_RESULT(-5, "没有result"),
    MISS_OPENID(-6, "没有好友openid"),
    INSERT_FAIL(-7, "插入失败");

    private int code;
    private String msg;

    private GameBoxErrEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMsg(int code) {
        for (GameBoxErrEnum errEnum : GameBoxErrEnum.values()) {
            if (code == errEnum.code) {
                return errEnum.msg;
            }
        }
        return null;
    }

}
