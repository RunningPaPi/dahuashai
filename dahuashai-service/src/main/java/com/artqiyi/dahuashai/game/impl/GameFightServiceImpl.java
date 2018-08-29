package com.artqiyi.dahuashai.game.impl;

import com.alibaba.fastjson.JSON;
import com.artqiyi.dahuashai.common.constant.GameConstants;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.socket.SocketConstant;
import com.artqiyi.dahuashai.common.socket.SocketResponseMsg;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.common.util.GameUtil;
import com.artqiyi.dahuashai.common.util.JSONUtil;
import com.artqiyi.dahuashai.game.*;
import com.artqiyi.dahuashai.game.domain.GameFightRecords;
import com.artqiyi.dahuashai.game.domain.GameFightUserRecord;
import com.artqiyi.dahuashai.game.domain.GameModel;
import com.artqiyi.dahuashai.game.vo.FightResultVo;
import com.artqiyi.dahuashai.game.vo.FightRoom;
import com.artqiyi.dahuashai.game.vo.GameFightUserRecordsVo;
import com.artqiyi.dahuashai.redis.RedisClient;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;
import com.artqiyi.dahuashai.websocket.service.WebSocketHandlerService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 好友对战模式
 */
@Service("gameFightService")
public class GameFightServiceImpl implements IGameFightService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private WebSocketHandlerService webSocketHandlerService;
    @Autowired
    private IGameJobService gameJobService;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private IGameFightRecordsService gameFightRecordsService;
    @Autowired
    private IGameModelService gameModelService;
    @Autowired
    private IGameFightUserRecordsService gameFightUserRecordsService;
    @Autowired
    private GameBoxService gameBoxService;


    /**
     * 开房间邀请好友对战(http接口)
     *
     * @param userId 用户ID
     */
    @Override
    public String newRoom(Long userId) {
        String lastRoomNo = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString(), String.class);
        if (lastRoomNo != null) {
            redisClient.hDel(RedisFiledConstant.DHS_FIGHT_ROOM, lastRoomNo);
        }

        GameFightRecords record = redisClient.get(RedisFiledConstant.DHS_GAME_FIGHT_RECORD, GameFightRecords.class);
        if (record == null) {
            String gameNo = DateUtil.formatDate(new Date(), DateUtil.DATESEC_FORMAT_NO_DASH);
            record = new GameFightRecords();
            record.setContestNum(1);
            record.setGameNo(gameNo);
            record.setPkTimes(0);
            record.setCreateTime(new Date());
        }
        //游戏数据
        redisClient.set(RedisFiledConstant.DHS_GAME_FIGHT_RECORD, record);
        String roomNo = DateUtil.formatDate(new Date(), DateUtil.DATESEC_FORMAT_NO_DASH) + "_" + userId;//房间号
        GameFightUserRecordsVo recordsVo = initPlayerInfo(userId);
        recordsVo.setRoomNo(roomNo);
        recordsVo.setGameNo(record.getGameNo());
        recordsVo.setInviter(true);
        FightRoom room = new FightRoom();
        room.setMasterId(userId);
        room.setMasterInfo(recordsVo);
        redisClient.hSet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, room);
        redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString(), roomNo);
        logger.info("【房间创建】roomNo为{}", roomNo);

        //玩家数据
        GameFightUserRecord playRecord = redisClient.hGet(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, String.valueOf(recordsVo.getUserId()), GameFightUserRecord.class);
        if (playRecord == null) {
            //参赛人数+1
            record.setContestNum(record.getContestNum() + 1);
            playRecord = new GameFightUserRecord();
            playRecord.setGameNo(record.getGameNo());
            playRecord.setUserId(recordsVo.getUserId());
            playRecord.setHeadUrl(recordsVo.getHeadUrl());
            playRecord.setPlayTimes(0);
            playRecord.setWinTimes(0);
            playRecord.setInviteTimes(1);
            playRecord.setSuccessInviteTimes(0);
            playRecord.setCreateTime(new Date());
        } else {
            //邀请次数
            playRecord.setInviteTimes(playRecord.getInviteTimes() == null ? 0 : playRecord.getInviteTimes() + 1);
        }
        redisClient.hSet(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, String.valueOf(recordsVo.getUserId()), playRecord);
        return roomNo;
    }

    /**
     * 游戏统计
     *
     * @param recordsVo
     * @param isInviter 是否是要请者
     */
    private synchronized void statistics(GameFightUserRecordsVo recordsVo, boolean isInviter) {
        try {
            GameFightRecords record = redisClient.get(RedisFiledConstant.DHS_GAME_FIGHT_RECORD, GameFightRecords.class);
            GameFightUserRecord playRecord = redisClient.hGet(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, String.valueOf(recordsVo.getUserId()), GameFightUserRecord.class);
            if (playRecord == null) {
                //参赛人数+1
                record.setContestNum(record.getContestNum() + 1);

                playRecord = new GameFightUserRecord();
                playRecord.setGameNo(record.getGameNo());
                playRecord.setUserId(recordsVo.getUserId());
                playRecord.setHeadUrl(recordsVo.getHeadUrl());
                playRecord.setPlayTimes(1);
                playRecord.setWinTimes(0);
                playRecord.setInviteTimes(isInviter ? 1 : 0);
                playRecord.setSuccessInviteTimes(isInviter ? 1 : 0);
                playRecord.setCreateTime(new Date());
            } else {
                playRecord.setPlayTimes(playRecord.getPlayTimes() + 1);
                if (isInviter) {
                    //成功邀请次数
                    playRecord.setSuccessInviteTimes(playRecord.getSuccessInviteTimes() + 1);
                }
            }

            logger.info("【游戏统计】 游戏人数：{}", record.getContestNum());
            //玩家数据
            redisClient.hSet(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, String.valueOf(recordsVo.getUserId()), playRecord);
            //游戏数据
            redisClient.set(RedisFiledConstant.DHS_GAME_FIGHT_RECORD, record);
        } catch (Exception e) {
            logger.error("【游戏统计】{}{}", e.getMessage(), e);
        }
    }


    /**
     * 初始化玩家信息
     *
     * @param userId
     * @return
     */
    private GameFightUserRecordsVo initPlayerInfo(Long userId) {
        GameFightUserRecordsVo player = new GameFightUserRecordsVo();
        player.setUserId(userId);
        GameModel gameModel = gameModelService.getByGameModelKey(GameConstants.DHS_FIGHT_MODEL);
        player.setGameId(gameModel.getId());
        player.setTurn(false);
        player.setUserId(userId);
        player.setHasCallOne(false);
        player.setInviter(false);
        User user = userService.selectById(userId);
        if (user != null) {
            UserInfo userInfo = userInfoService.selectByUserId(userId);
            player.setHeadUrl(userInfo.getHeadPicUrl());
            player.setNickName(user.getNickName());
            player.setGender(userInfo.getGender());
            //判断是否是游戏盒子过来的玩家
            if (redisClient.hGet(RedisFiledConstant.GAME_BOX_USER, user.getId().toString(), String.class) != null){
                player.setPkey(user.getPkey());
                player.setUid(user.getUid());
                player.setGameBoxPlayer(true);
            }
        }
        return player;
    }

    /**
     * 加入房间
     *
     * @param userId 用户id
     * @param roomNo 房间编码
     */
    public void enterRoom(Long userId, String roomNo) {
        //并发控制
        try {
            if (!redisClient.setNx(RedisFiledConstant.DHS_ENTER_ROOM + roomNo, "enterRoom")) {
                logger.error("【加入房间】该房间已满！roomNo={}", roomNo);
                Map resultMap = new HashMap<>();
                resultMap.put("failCode", 1);
                resultMap.put("failReason", "房间已满");
                sendMessage(resultMap, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM_FAIL);
                return;
            }
            roomNo = roomNo.trim();
            //获取邀战玩家
            FightRoom room = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, FightRoom.class);
            if (room == null) {
                logger.info("【加入房间】该游戏房间不存在！roomNo={}", roomNo);
                Map resultMap = new HashMap<>();
                resultMap.put("failCode", 1);
                resultMap.put("failReason", "房间已解散");
                sendMessage(resultMap, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM_FAIL);
                return;
            }

            if (room.getMatchInfo() != null) {
                logger.error("【加入房间】该房间已满！roomNo={}", roomNo);
                Map resultMap = new HashMap<>();
                resultMap.put("failCode", 1);
                resultMap.put("failReason", "房间已满");
                sendMessage(resultMap, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM_FAIL);
                return;
            }

            GameFightUserRecordsVo invitePlayer = room.getMasterInfo();
            //是否为同一玩家
            if (invitePlayer.getUserId().longValue() == userId.longValue()) {
                logger.info("【加入房间】玩家进入自己的房间！userId={},roomNo={}", invitePlayer.getUserId(), roomNo);
                return;
            } else {
                logger.info("【加入房间】该游戏当前赛场有玩家等待，进行匹配！roomNo={}", roomNo);
                GameFightUserRecordsVo invitedPlayer = initPlayerInfo(userId);

                //向发起邀请的玩家推送消息
                invitePlayer.setAgainstId(userId);
                invitePlayer.setAgainstHeadUrl(invitedPlayer.getHeadUrl());
                invitePlayer.setAgainstNickName(invitedPlayer.getNickName());
                invitePlayer.setAgainstGender(invitedPlayer.getGender());
                invitePlayer.setInviter(true);
                String msgCode = SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM;
                sendMessage(invitePlayer, GameConstants.DHS_FIGHT_MODEL, invitePlayer.getUserId(), msgCode);

                //向被邀请的玩家推送消息
                invitedPlayer.setGameNo(invitePlayer.getGameNo());
                invitedPlayer.setRoomNo(invitePlayer.getRoomNo());
                invitedPlayer.setAgainstId(invitePlayer.getUserId());
                invitedPlayer.setAgainstHeadUrl(invitePlayer.getHeadUrl());
                invitedPlayer.setAgainstNickName(invitePlayer.getNickName());
                invitedPlayer.setAgainstGender(invitePlayer.getGender());
                room.setMatchInfo(invitedPlayer);

                sendMessage(invitedPlayer, GameConstants.DHS_FIGHT_MODEL, userId, msgCode);
                //玩家对应的房间号
                redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString(), roomNo);
                redisClient.hSet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, room);
                redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, invitePlayer.getUserId().toString(), invitePlayer);
                redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, userId.toString(), invitedPlayer);
            }
        } finally {
            redisClient.del(RedisFiledConstant.DHS_ENTER_ROOM + roomNo);
        }
    }


    /**
     * 开始游戏
     *
     * @param userId
     */
    public void start(Long userId, Long againstId, String roomNo) {
        logger.info("【开始游戏】");
        //获取当前用户对战记录
        FightRoom room = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, FightRoom.class);
        GameFightUserRecordsVo master = room.getMasterInfo();
        GameFightUserRecordsVo match = room.getMatchInfo();
        //发骰子
        master.setDice(Integer.valueOf(GameUtil.getNum(GameConstants.TOTAL_DICE_NUM)));
        Random random = new Random();
        boolean isTurn = random.nextBoolean();
        master.setTurn(isTurn);

        //游戏已经开始
        master.setGameStarted(true);
        sendMessage(master, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_START);
        redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, userId.toString(), master);

        match.setDice(Integer.valueOf(GameUtil.getNum(GameConstants.TOTAL_DICE_NUM)));
        match.setTurn(!isTurn);
        match.setGameStarted(true);
        sendMessage(match, GameConstants.DHS_FIGHT_MODEL, againstId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_START);
        redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, match.getUserId().toString(), match);
        //统计
        statistics(master, true);
        statistics(match, false);
        //设置叫骰超时监测任务
        gameJobService.fightGameOvertimeTask(match);
    }

    /**
     * 放弃比赛
     *
     * @param userId 用户id
     * @param roomNo 房间编码
     */
    @Override
    public void giveUp(long userId, String roomNo) {
        //获取当前用户对战记录
        GameFightUserRecordsVo currentPlayer = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(userId), GameFightUserRecordsVo.class);
        if (currentPlayer == null) {
            logger.error("【游戏正常】该游戏用户记录不存在！userId={}", userId);
            return;
        }
        //获取对手用户对战记录
        GameFightUserRecordsVo againstPlayer = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(currentPlayer.getAgainstId()), GameFightUserRecordsVo.class);
        if (againstPlayer == null) {
            logger.error("【游戏正常】该游戏用户记录不存在！userId={}", currentPlayer.getAgainstId());
            return;
        }
        win(againstPlayer, currentPlayer, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_GIVE_UP);
    }

    /**
     * 表情
     *
     * @param userId 当前用户id
     * @param roomNo 房间编码
     * @param data   传输表情数据
     */
    @Override
    public void emoticon(long userId, String roomNo, String data) {
        //获取当前用户对战记录
        GameFightUserRecordsVo player = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(userId), GameFightUserRecordsVo.class);
        if (player == null) {
            logger.error("【游戏正常】该游戏用户记录不存在！userId={}", userId);
            return;
        }
        //推送消息
        sendMessage(data, GameConstants.DHS_FIGHT_MODEL, player.getAgainstId(), SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_EMOTICON);
    }

    /**
     * 数据传递
     *
     * @param userId
     * @param data
     */
    public void follow(long userId, long againstId, String roomNo, String data) {
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + userId);

        GameFightUserRecordsVo currentPlayer = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(userId), GameFightUserRecordsVo.class); //获取当前用户信息
        if (currentPlayer == null) {
            logger.info("【数据传递】此玩家记录不存在！roomNo={},againstId={}", roomNo, userId);
            sendMessage(null, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_END);//本赛场已结束
            return;
        }
        GameFightUserRecordsVo againstPlayer = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(againstId), GameFightUserRecordsVo.class); //获取当前用户信息
        if (currentPlayer == null) {
            logger.info("【数据传递】此玩家对手记录不存在！roomNo={},againstId={}", roomNo, againstId);
            return;
        }

        if (!currentPlayer.isTurn()) {
            logger.info("【数据传递】此玩家未到叫号顺序！roomNo={},againstId={}", roomNo, againstId);
            return;
        }
        Map map = (Map) JSON.parse(data);
        map.put("hasCallOne", false);
        int number = MapUtils.getIntValue(map, "number");
        if (number == 1) {
            currentPlayer.setHasCallOne(true);
            againstPlayer.setHasCallOne(true);
            map.put("hasCallOne", true);
        }
        if (currentPlayer.isHasCallOne() || againstPlayer.isHasCallOne()) {
            map.put("hasCallOne", true);
        }
        currentPlayer.setTurn(false);
        currentPlayer.setData(map);
        redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(userId), currentPlayer);

        againstPlayer.setTurn(true);
        againstPlayer.setAgainstData(map);
        redisClient.hSet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(againstId), againstPlayer);

        //推送消息给对手
        sendMessage(map, GameConstants.DHS_FIGHT_MODEL, againstId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_FOLLOW);
        //设置叫骰超时监测任务
        gameJobService.fightGameOvertimeTask(againstPlayer);
    }

    /**
     * 再来一局
     *
     * @param userId
     * @param roomNo
     */
    @Override
    public void again(long userId, long againstId, String roomNo) {
        FightRoom room = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, FightRoom.class);
        if (room != null) {
            if (userId == room.getMasterId().longValue()) {
                sendMessage(room.getMasterInfo(), GameConstants.DHS_FIGHT_MODEL, againstId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_AGAIN);
            } else {
                sendMessage(room.getMasterInfo(), GameConstants.DHS_FIGHT_MODEL, againstId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_AGAIN);
            }
        } else {
            Map resultMap = new HashMap<>();
            resultMap.put("failCode", 1);
            resultMap.put("failReason", "房间已解散");
            sendMessage(resultMap, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_ENTER_ROOM_FAIL);
        }
    }


    /**
     * 玩家离开房间
     *
     * @param userId
     * @param roomNo
     */
    @Override
    public void leave(Long userId, String roomNo) {
        FightRoom room = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, FightRoom.class);
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + userId);
        if (room != null) {
            //是否是房主
            if (room.getMasterId().intValue() == userId) {
                redisClient.hDel(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo);
                redisClient.hDel(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString());
                GameFightUserRecordsVo match = room.getMatchInfo();
                if (match != null) {
                    gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + match.getUserId());
                    sendMessage(null, GameConstants.DHS_FIGHT_MODEL, match.getUserId(), SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_LEAVE);
                }
            } else {
                room.setMatchInfo(null);
                redisClient.hSet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, room);
                redisClient.hDel(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString());
                gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + room.getMasterId());
                sendMessage(null, GameConstants.DHS_FIGHT_MODEL, room.getMasterId(), SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_LEAVE);
            }
        }
    }

    /**
     * 退出等待 房主开始创建后，没人进来，退出等待
     *
     * @param userId
     * @param roomNo
     */
    @Override
    public void quit(Long userId, String roomNo) {
        leave(userId, roomNo);
    }

    /**
     * 掉线
     *
     * @param userId
     */
    @Override
    public void offLine(Long userId) {
        String roomNo = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString(), String.class);
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + userId);
        if (roomNo != null) {
            FightRoom room = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, FightRoom.class);
            if (room != null) {
                //是房主则销毁房间,否则清除房间占用状态
                if (room.getMasterId().longValue() == userId.longValue()) {
                    redisClient.hDel(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo);
                } else {
                    //否则解除占用
                    room.setMatchInfo(null);
                    gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + room.getMasterId());
                    redisClient.hSet(RedisFiledConstant.DHS_FIGHT_ROOM, roomNo, room);
                }
                //删除对应的房间号
                redisClient.hDel(RedisFiledConstant.DHS_FIGHT_USER_ROOM, userId.toString());

                GameFightUserRecordsVo player = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(userId), GameFightUserRecordsVo.class);

                if (player != null) {
                    Long againstId = player.getAgainstId();
                    if (againstId != null) {
                        GameFightUserRecordsVo againstPlayer = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(againstId), GameFightUserRecordsVo.class);
                        if (againstPlayer != null) {
                            //如果是在游戏进行中掉线则直接判输
                            if (player.isGameStarted()) {
                                win(againstPlayer, player, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_OFFLINE);
                                return;
                            }
                        }
                        //如果还没开始游戏则把信息发给对手
                        sendMessage(againstPlayer, GameConstants.DHS_FIGHT_MODEL, againstId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_OFFLINE);
                    }
                }
            }
        }
    }

    /**
     * 开骰
     *
     * @param userId
     * @param againstId
     * @param roomNo
     */
    public void open(long userId, long againstId, String roomNo) {
        //移除叫骰超时监测任务
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + againstId);
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, roomNo + userId);
        //当前用户信息
        GameFightUserRecordsVo breakGameUserRecordsVo = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(userId), GameFightUserRecordsVo.class); //获取当前用户信息
        if (breakGameUserRecordsVo == null) {
            sendMessage(null, GameConstants.DHS_FIGHT_MODEL, userId, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_END);//本赛场已结束
            logger.info("【游戏异常】该游戏当前赛场用户游戏记录不存在！roomNo={},againstId={}", roomNo, userId);
            return;
        }
        //对手信息
        GameFightUserRecordsVo againstPlayerRecordsVo = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(againstId), GameFightUserRecordsVo.class); //获取当前用户信息
        if (againstPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户对手游戏记录不存在！roomNo={},againstId={}", roomNo, againstId);
            return;
        }
        Map data = (Map) againstPlayerRecordsVo.getData();
        int m = MapUtils.getIntValue(data, "times");
        int n = MapUtils.getIntValue(data, "number");
        boolean isWin = GameUtil.compute(breakGameUserRecordsVo.getDice().toString(), againstPlayerRecordsVo.getDice().toString(), m, n, againstPlayerRecordsVo.isHasCallOne());
        if (isWin) {
            win(breakGameUserRecordsVo, againstPlayerRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_RESULT);
        } else {
            win(againstPlayerRecordsVo, breakGameUserRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_RESULT);
        }

    }

    /**
     * 赢得比赛PK
     *
     * @param winner 赢家记录
     * @param loser  输家记录
     */
    @Override
    public void win(GameFightUserRecordsVo winner, GameFightUserRecordsVo loser, String msgCode) {
        if (winner == null || loser == null) {
            return;
        }
        //移除叫骰超时监测任务
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, winner.getRoomNo() + winner.getUserId());
        gameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, winner.getRoomNo() + loser.getUserId());

        Object lastData = null;
        if (winner.isTurn()) {
            lastData = loser.getData();
        } else {
            lastData = winner.getData();
        }

        winner.setHasCallOne(false);
        winner.setWin(true);
        //向赢方推送胜利消息
        FightResultVo winnerResult = new FightResultVo();
        winnerResult.setWin(true);
        winnerResult.setHasCallOne(winner.isHasCallOne());
        winnerResult.setDice(winner.getDice());
        winnerResult.setAgainstDice(loser.getDice());
        winnerResult.setData(winner.getData());
        winnerResult.setAgainstData(loser.getData());
        winnerResult.setLastData(lastData);
        winnerResult.setInviter(winner.isInviter());
        winnerResult.setHasCallOne(loser.isHasCallOne());
        sendMessage(winnerResult, GameConstants.DHS_FIGHT_MODEL, winner.getUserId(), msgCode);
        GameFightUserRecord playRecord = redisClient.hGet(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, String.valueOf(winner.getUserId()), GameFightUserRecord.class);
        if (playRecord != null) {
            playRecord.setWinTimes(playRecord.getWinTimes() + 1);
            redisClient.hSet(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, String.valueOf(winner.getUserId()), playRecord);
        }
        if (winner.isGameBoxPlayer()) {
            gameBoxService.sendToGameBoxSystem(true, winner.getUserId(), winner.getUid(), true);
        }
        //向输方推送消息
        FightResultVo loserResult = new FightResultVo();
        loserResult.setHasCallOne(loser.isHasCallOne());
        loserResult.setWin(false);
        loserResult.setDice(loser.getDice());
        loserResult.setAgainstDice(winner.getDice());
        loserResult.setData(loser.getData());
        loserResult.setAgainstData(winner.getData());
        loserResult.setLastData(lastData);
        loserResult.setInviter(loser.isInviter());
        sendMessage(loserResult, GameConstants.DHS_FIGHT_MODEL, loser.getUserId(), msgCode);
        //移除玩家正在比赛记录
        redisClient.hDel(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(winner.getAgainstId()));
        redisClient.hDel(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(winner.getUserId()));
        if (loser.isGameBoxPlayer()) {
            gameBoxService.sendToGameBoxSystem(true, loser.getUserId(), loser.getUid(), false);
        }
    }

    /**
     * 比赛超时未叫骰
     *
     * @param player
     */
    @Override
    public void callNumberOvertime(GameFightUserRecordsVo player) {
        GameFightUserRecordsVo againstPlayerRecordsVo = redisClient.hGet(RedisFiledConstant.DHS_FIGHT_USER_RECORD, String.valueOf(player.getAgainstId()), GameFightUserRecordsVo.class); //获取当前用户信息
        if (againstPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户对手游戏记录不存在！gameNo={},againstId={}", player.getRoomNo(), player.getAgainstId());
            return;
        }
        win(againstPlayerRecordsVo, player, SocketConstant.SOCKET_OPERATE_SEND_FIGHT_GAME_OVERTIME);
    }

    /**
     * 推送消息
     */
    private void sendMessage(Object data, String group, long userId, String msgCode) {
        SocketResponseMsg msg = new SocketResponseMsg();
        msg.setCode(msgCode);
        msg.setSuccess(true);
        msg.setResult(data);
        webSocketHandlerService.sendMessageToUser(group, "user" + userId, new TextMessage(JSONUtil.toJson(msg)));
    }


    /**
     * 随机获取提示文案
     *
     * @return
     */
    private String getText() {
        String[] templetText = {"来战来战~", "不要走，决战到天亮！", "我准备好啦，快点进来~", "再来一局啊~"};
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        return templetText[randomNum];
    }


    /**
     * 保存数据
     */
    public void saveData(Object o) {
        try {
            GameFightRecords record = redisClient.get(RedisFiledConstant.DHS_GAME_FIGHT_RECORD, GameFightRecords.class);
            if (record != null) {
                gameFightRecordsService.save(record);
                String gameNo = DateUtil.formatDate(new Date(), DateUtil.DATESEC_FORMAT_NO_DASH);
                record = new GameFightRecords();
                record.setContestNum(0);
                record.setGameNo(gameNo);
                record.setPkTimes(0);
                record.setCreateTime(new Date());
                redisClient.set(RedisFiledConstant.DHS_GAME_FIGHT_RECORD, record);
            }
        } catch (Exception e) {
            logger.error("【保存数据】 保存好友对战游戏统计数据失败 {}{}", e.getMessage(), e);
        }
        Map<String, GameFightUserRecord> map = redisClient.hGetAll(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD, GameFightUserRecord.class);
        try {
            if (map != null && map.size() != 0) {
                for (Map.Entry<String, GameFightUserRecord> entry : map.entrySet()) {
                    gameFightUserRecordsService.save(entry.getValue());
                }
                redisClient.del(RedisFiledConstant.DHS_GAME_FIGHT_USER_RECORD);
            }
        } catch (Exception e) {
            logger.error("【保存数据】 保存好友对战玩家游戏数据失败 {}{}", e.getMessage(), e);
        }
    }

}
