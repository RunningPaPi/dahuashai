package com.artqiyi.dahuashai.game.vo;

import java.util.Date;

/**
 * 闯关游戏比赛记录vo
 */
public class GameBreakUserRecordsVo {

    private Long id;

    private Long gameId;

    private String gameNo;

    private Long userId;

    private String nickName;

    private boolean isRobot; //是否是机器人

    private String headUrl;

    private Integer recoveryTimes;

    private Short passMaxLevel;

    private Boolean isPass;

    private Integer score;

    private String note;

    private Date createTime;

    private Date updateTime;

    private int randomNum;//产生随机数

    private boolean isTurn;//是否当前叫数

    private Object data;//叫骰点数

    private boolean hasCallOne;//是否叫过1，若叫过1则1只能代表1

    private long againstId;//对手id

    private Object agaistData;//对手叫骰点数

    private String agaistNickName;//对手昵称

    private String agaistHeadUrl;//对手头像

    private boolean isWin;//是否取胜

    private boolean islive;//是否存活

    private int gender;//性别

    private int agaistGender;//对手性别

    private boolean isRobotWin;//预设是否机器人赢

    private int callNumRound;//叫骰回合数

    private int maxShareTimes;

    private int shareTimes;

    private String shareType;

    private String playerType;

    private boolean isGameBoxPlayer;//是否是游戏盒子过来的玩家

    private String pkey;

    private int uid;

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

    public boolean isGameBoxPlayer() {
        return isGameBoxPlayer;
    }

    public void setGameBoxPlayer(boolean gameBoxPlayer) {
        isGameBoxPlayer = gameBoxPlayer;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public int getMaxShareTimes() {
        return maxShareTimes;
    }

    public void setMaxShareTimes(int maxShareTimes) {
        this.maxShareTimes = maxShareTimes;
    }

    public int getShareTimes() {
        return shareTimes;
    }

    public void setShareTimes(int shareTimes) {
        this.shareTimes = shareTimes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.gameNo = gameNo == null ? null : gameNo.trim();
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
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public Integer getRecoveryTimes() {
        return recoveryTimes;
    }

    public void setRecoveryTimes(Integer recoveryTimes) {
        this.recoveryTimes = recoveryTimes;
    }

    public Short getPassMaxLevel() {
        return passMaxLevel;
    }

    public void setPassMaxLevel(Short passMaxLevel) {
        this.passMaxLevel = passMaxLevel;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getPass() {
        return isPass;
    }

    public void setPass(Boolean pass) {
        isPass = pass;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public long getAgainstId() {
        return againstId;
    }

    public void setAgainstId(long againstId) {
        this.againstId = againstId;
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

    public Object getAgaistData() {
        return agaistData;
    }

    public void setAgaistData(Object agaistData) {
        this.agaistData = agaistData;
    }

    public String getAgaistNickName() {
        return agaistNickName;
    }

    public void setAgaistNickName(String agaistNickName) {
        this.agaistNickName = agaistNickName;
    }

    public String getAgaistHeadUrl() {
        return agaistHeadUrl;
    }

    public void setAgaistHeadUrl(String agaistHeadUrl) {
        this.agaistHeadUrl = agaistHeadUrl;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public boolean isIslive() {
        return islive;
    }

    public void setIslive(boolean islive) {
        this.islive = islive;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAgaistGender() {
        return agaistGender;
    }

    public void setAgaistGender(int agaistGender) {
        this.agaistGender = agaistGender;
    }

    public boolean isRobot() {
        return isRobot;
    }

    public void setRobot(boolean robot) {
        isRobot = robot;
    }

    public boolean isRobotWin() {
        return isRobotWin;
    }

    public void setRobotWin(boolean robotWin) {
        isRobotWin = robotWin;
    }

    public int getCallNumRound() {
        return callNumRound;
    }

    public void setCallNumRound(int callNumRound) {
        this.callNumRound = callNumRound;
    }
}
