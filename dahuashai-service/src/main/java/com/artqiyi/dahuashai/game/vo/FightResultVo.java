package com.artqiyi.dahuashai.game.vo;

/**
 * 好友对战结果
 */
public class FightResultVo {
    private boolean isWin; //是否赢得当前pk
    private Object data;//上次叫骰数据
    private Object againstData;//对手上次叫骰数据
    private Object lastData;//最后回合叫骰数据
    private int dice;  //骰子
    private int againstDice;  //对手骰子
    private boolean hasCallOne;//是否叫过1
    private boolean isInviter;

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getAgainstData() {
        return againstData;
    }

    public void setAgainstData(Object againstData) {
        this.againstData = againstData;
    }

    public Object getLastData() {
        return lastData;
    }

    public void setLastData(Object lastData) {
        this.lastData = lastData;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getAgainstDice() {
        return againstDice;
    }

    public void setAgainstDice(int againstDice) {
        this.againstDice = againstDice;
    }

    public boolean isHasCallOne() {
        return hasCallOne;
    }

    public void setHasCallOne(boolean hasCallOne) {
        this.hasCallOne = hasCallOne;
    }

    public boolean isInviter() {
        return isInviter;
    }

    public void setInviter(boolean inviter) {
        isInviter = inviter;
    }
}
