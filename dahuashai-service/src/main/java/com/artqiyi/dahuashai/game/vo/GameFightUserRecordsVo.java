package com.artqiyi.dahuashai.game.vo;

/**
 * 好友对战信息
 */
public class GameFightUserRecordsVo {
    private Long gameId;

    private String gameNo;//游戏场次编号

    private Long userId;

    private String nickName;

    private String headUrl;

    private Integer score;

    private Integer dice;//骰子

    private boolean isTurn;//是否当前叫数

    private Object data;//叫骰点数

    private boolean hasCallOne;//是否叫过1，若叫过1则1只能代表1

    private Object againstData;//对手叫骰点数

    private Long againstId;

    private String againstNickName;//对手昵称

    private String againstHeadUrl;//对手头像

    private boolean isWin;//是否取胜

    private Short gender;//性别

    private Short againstGender;//对手性别

    private Integer callNumRound;//叫骰回合数

    private String roomNo;

    private boolean isInviter;

    private boolean isGameStarted;

    private boolean isGameBoxPlayer;//是否是游戏盒子过来的玩家

    private String pkey;

    private int uid;

    public boolean isGameBoxPlayer() {
        return isGameBoxPlayer;
    }

    public void setGameBoxPlayer(boolean gameBoxPlayer) {
        isGameBoxPlayer = gameBoxPlayer;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        isGameStarted = gameStarted;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDice() {
        return dice;
    }

    public void setDice(Integer dice) {
        this.dice = dice;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isHasCallOne() {
        return hasCallOne;
    }

    public void setHasCallOne(boolean hasCallOne) {
        this.hasCallOne = hasCallOne;
    }

    public Object getAgainstData() {
        return againstData;
    }

    public void setAgainstData(Object againstData) {
        this.againstData = againstData;
    }

    public Long getAgainstId() {
        return againstId;
    }

    public void setAgainstId(Long againstId) {
        this.againstId = againstId;
    }

    public String getAgainstNickName() {
        return againstNickName;
    }

    public void setAgainstNickName(String againstNickName) {
        this.againstNickName = againstNickName;
    }

    public String getAgainstHeadUrl() {
        return againstHeadUrl;
    }

    public void setAgainstHeadUrl(String againstHeadUrl) {
        this.againstHeadUrl = againstHeadUrl;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getAgainstGender() {
        return againstGender;
    }

    public void setAgainstGender(Short againstGender) {
        this.againstGender = againstGender;
    }

    public Integer getCallNumRound() {
        return callNumRound;
    }

    public void setCallNumRound(Integer callNumRound) {
        this.callNumRound = callNumRound;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isInviter() {
        return isInviter;
    }

    public void setInviter(boolean inviter) {
        isInviter = inviter;
    }
}
