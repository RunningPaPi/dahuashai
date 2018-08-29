package com.artqiyi.dahuashai.game.vo;


public class FightRoom {
    private Long masterId;//房主id

    private GameFightUserRecordsVo masterInfo;

    private GameFightUserRecordsVo matchInfo;

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public GameFightUserRecordsVo getMasterInfo() {
        return masterInfo;
    }

    public void setMasterInfo(GameFightUserRecordsVo masterInfo) {
        this.masterInfo = masterInfo;
    }

    public GameFightUserRecordsVo getMatchInfo() {
        return matchInfo;
    }

    public void setMatchInfo(GameFightUserRecordsVo matchInfo) {
        this.matchInfo = matchInfo;
    }

    public Long getMathId(){
        if (null!=matchInfo){
            return matchInfo.getUserId();
        }
        return null;
    }
}
