package com.artqiyi.dahuashai.game.impl;

import com.alibaba.fastjson.JSON;
import com.artqiyi.dahuashai.common.constant.*;
import com.artqiyi.dahuashai.common.socket.SocketConstant;
import com.artqiyi.dahuashai.common.socket.SocketResponseMsg;
import com.artqiyi.dahuashai.common.util.*;
import com.artqiyi.dahuashai.game.*;
import com.artqiyi.dahuashai.game.domain.*;
import com.artqiyi.dahuashai.game.vo.*;
import com.artqiyi.dahuashai.payment.domain.CoinTranslog;
import com.artqiyi.dahuashai.payment.service.TransLogService;
import com.artqiyi.dahuashai.redis.RedisClient;
import com.artqiyi.dahuashai.redis.RedisLock;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserExample;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;
import com.artqiyi.dahuashai.websocket.service.WebSocketHandlerService;

import com.artqiyi.dahuashai.wechat.WechatService;
import org.apache.commons.collections.MapUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 大话骰闯关游戏模式服务层
 */
@Service("gameBreakService")
public class GameBreakServiceImpl implements IGameBreakService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private WebSocketHandlerService webSocketHandlerService;
    @Autowired
    private IGameModelService gameModelService;
    @Autowired
    private IGameConfigService gameConfigService;
    @Autowired
    private IGameBreakUserQualifyService breakGameUserQualifyService;
    @Autowired
    private TransLogService transLogService;
    @Autowired
    private IGameJobService breakGameJobService;
    @Autowired
    private IGameBreakRecoverRecordsService gameBreakRecoverRecordsService;
    @Autowired
    private IGameBreakAgainstRecordsService breakGameAgainstRecordsService;
    @Autowired
    private IGameBreakRecordsService gameBreakRecordsService;
    @Autowired
    private IGameBreakUserRecordsService userRecordsService;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private RedisLock redisLock;
    @Autowired
    private IGameUserWinPercentService gameUserWinPercentService;
    @Autowired
    private WechatService wechatService;
    @Autowired
    private GameBoxService gameBoxService;

    /**
     * 开始游戏
     *
     * @param userId 用户ID
     * @param gameId 游戏ID
     */
    @Override
    public void startGame(long userId, long gameId, String gameNo) {
        redisClient.hDel(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo, String.valueOf(userId));
        //用户比赛记录放进缓存
        GameBreakUserRecordsVo breakGameUserRecordsVo = new GameBreakUserRecordsVo();
        breakGameUserRecordsVo.setCreateTime(new Date());
        breakGameUserRecordsVo.setUpdateTime(new Date());
        breakGameUserRecordsVo.setGameId(gameId);
        breakGameUserRecordsVo.setIsPass(false);
        breakGameUserRecordsVo.setPassMaxLevel((short) 0);
        breakGameUserRecordsVo.setRandomNum(RandomUtil.randomNum(1, 7, 5));
        breakGameUserRecordsVo.setTurn(false);
        breakGameUserRecordsVo.setUserId(userId);
        breakGameUserRecordsVo.setHasCallOne(false);
        breakGameUserRecordsVo.setIslive(true);
        breakGameUserRecordsVo.setRecoveryTimes(0);
        breakGameUserRecordsVo.setShareTimes(0);
        List<GameConfig> gameConfigs = gameConfigService.getByType(GameConstants.DHS_BREAK_MODEL, GameConstants.RECOVER_WAY);
        int maxTimes = -1;
        if (gameConfigs !=null && gameConfigs.get(0) != null){
            maxTimes = Integer.valueOf(gameConfigs.get(0).getTypeValue());
            breakGameUserRecordsVo.setShareType(gameConfigs.get(0).getCode());
        }
        breakGameUserRecordsVo.setMaxShareTimes(maxTimes);
        breakGameUserRecordsVo.setRobot(false);
        User user = userService.selectById(userId);


        if (user != null) {
            UserInfo userInfo = userInfoService.selectByUserId(userId);
            breakGameUserRecordsVo.setHeadUrl(userInfo.getHeadPicUrl());
            breakGameUserRecordsVo.setNickName(user.getNickName());
            breakGameUserRecordsVo.setGender(userInfo.getGender());
            if (redisClient.hGet(RedisFiledConstant.GAME_BOX_USER, user.getId().toString(), String.class) != null){
                breakGameUserRecordsVo.setPkey(user.getPkey());
                breakGameUserRecordsVo.setUid(user.getUid());
                breakGameUserRecordsVo.setGameBoxPlayer(true);
            }
            String playerType = gameUserWinPercentService.getPlayerTypeByUserId(userId);
            //判断是新手还是老手,或是特殊玩家
            if (playerType != null){
                breakGameUserRecordsVo.setPlayerType(playerType);
            }else {
                DateTime time = new DateTime();
                if (time.minusDays(3).toDate().getTime() - userInfo.getCreateTime().getTime() > 0) {
                    breakGameUserRecordsVo.setPlayerType("OLD_PLAYER");
                }else {
                    breakGameUserRecordsVo.setPlayerType("NEW_PLAYER");
                }
            }
        }

        //匹配对手
        match(breakGameUserRecordsVo);
    }

    /**
     * 继续闯关
     *
     * @param userId 用户ID
     * @param gameId 游戏ID
     * @param gameNo 游戏赛场编码
     */
    @Override
    public void continueGame(long userId, long gameId, String gameNo) {
        GameBreakUserRecordsVo breakGameUserRecordsVo = redisClient.hGet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo, String.valueOf(userId),GameBreakUserRecordsVo.class); //获取当前用户信息
        logger.info(JSONUtil.toJson(breakGameUserRecordsVo));
        if (breakGameUserRecordsVo == null) {
            logger.error("【游戏异常】该游戏当前赛场等待继续闯关用户游戏记录不存在！gameNo={},againstId={}", gameNo, userId);
            sendMessage(null, gameNo, userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_END);//本赛场已结束
            return;
        }
        //更新当前用户信息
        if (breakGameUserRecordsVo == null || !breakGameUserRecordsVo.isIslive()) {
            logger.error("【游戏异常】该游戏当前赛场等待继续闯关用户游戏记录暂未复活！gameNo={},againstId={}", gameNo, userId);
            return;
        }
        //匹配对手
        match(breakGameUserRecordsVo);
    }


    /**
     * 游戏复活
     *
     * @param userId 用户ID
     * @param gameNo 游戏编码
     * @param round  当前关卡
     */
    @Override
    public Map<String, Object> recover(long userId, long gameId, String gameNo, int round) {
        GameBreakUserRecordsVo breakGameUserRecordsVo = redisClient.hGet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo, String.valueOf(userId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (breakGameUserRecordsVo == null) {
            logger.error("【游戏异常】该游戏当前赛场等待继续闯关用户游戏记录不存在！gameNo={},againstId={}", gameNo, userId);
            return null;
        }

        int shareTimes = breakGameUserRecordsVo.getShareTimes();
        breakGameUserRecordsVo.setShareTimes(shareTimes+1);
        round = breakGameUserRecordsVo.getPassMaxLevel()+1;
        Map<String, Object> result = new HashMap<>();//封装返回结果
        List<GameConfig> gameConfigs = gameConfigService.getByType(GameConstants.DHS_BREAK_MODEL, GameConstants.RECOVER_WAY);
        boolean isRecoverSuccess = true;
        int maxTimes = -1;
        if (gameConfigs !=null && gameConfigs.get(0) != null){
            maxTimes = Integer.valueOf(gameConfigs.get(0).getTypeValue());
            breakGameUserRecordsVo.setShareType(gameConfigs.get(0).getCode());
            isRecoverSuccess = shareTimes <= maxTimes;
        }
        //获取user和user_info
        User user = userService.selectById(userId);
        UserInfo userInfo = userInfoService.selectByUserId(userId);
        //用户复活记录
        GameBreakRecoverRecords breakGameRecoverRecords = new GameBreakRecoverRecords();
        breakGameRecoverRecords.setUserId(userId);
        breakGameRecoverRecords.setGameModelId(gameId);
        breakGameRecoverRecords.setGameNo(gameNo);
        breakGameRecoverRecords.setCreateTime(new Date());
        breakGameRecoverRecords.setGameRound(round);
        breakGameRecoverRecords.setCostNum(0);

        //复活成功
        if (isRecoverSuccess) {
            result.put("isRecoverSuccess", true);
            result.put("message", MsgConstant.SUCCES_RECOVER);
            HashMap<String, Object> data = new HashMap<>();
            data.put("user", MapConventUtil.obj2Map(user));
            data.put("userInfo", MapConventUtil.obj2Map(userInfo));
            redisClient.hSet(RedisFiledConstant.FILED_USER, user.getToken(), data);//保存用户信息至redis
            userInfoService.saveOrUpdate(userInfo);//更新至数据库

            //设置已复活状态
            breakGameUserRecordsVo.setIslive(true);
            //移至redis等待继续闯关的玩家
            redisClient.hSet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo, String.valueOf(userId), breakGameUserRecordsVo);

            //保存复活记录
            gameBreakRecoverRecordsService.saveOrUpdate(breakGameRecoverRecords);
        } else {
            result.put("isRecoverSuccess", false);
            if (!result.containsKey("failReason")){
                result.put("failReason", 0);
            }
            result.put("message", MsgConstant.FAIL_RECOVER);
        }
        result.put("maxShareTimes", maxTimes);
        result.put("shareTimes", breakGameUserRecordsVo.getShareTimes());
        //推送消息给用户
        sendMessage(result, gameNo, userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RECOVER);
        return result;
    }

    /**
     * 传递玩家叫数给对手（叫骰）
     *
     * @param userId    用户id
     * @param againstId 对手id
     * @param userId    游戏赛场编码
     * @param data      传递数据
     */
    @Override
    public void follow(long userId, long againstId, String gameNo, String data) {
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, gameNo + userId);

        GameBreakUserRecordsVo currentPlayerRecordsVo = redisClient.hGet(gameNo, String.valueOf(userId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (currentPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户游戏记录不存在！gameNo={},againstId={}", gameNo, userId);
            sendMessage(null, gameNo, userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_END);//本赛场已结束
            return;
        }
        GameBreakUserRecordsVo againstPlayerRecordsVo = redisClient.hGet(gameNo, String.valueOf(againstId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (againstPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户对手游戏记录不存在！gameNo={},againstId={}", gameNo, againstId);
            return;
        }

        if (currentPlayerRecordsVo == null || !currentPlayerRecordsVo.isTurn()) {
            logger.info("【游戏异常】该游戏当前赛场用户未到叫号顺序！gameNo={},againstId={}", gameNo, againstId);
            return;
        }
        Map map = (Map) JSON.parse(data);
        map.put("hasCallOne", false);
        int number = MapUtils.getIntValue(map, "number");
        if (number == 1) {
            currentPlayerRecordsVo.setHasCallOne(true);
            againstPlayerRecordsVo.setHasCallOne(true);
            map.put("hasCallOne", true);
        }
        if (currentPlayerRecordsVo.isHasCallOne() || againstPlayerRecordsVo.isHasCallOne()) {
            map.put("hasCallOne", true);
        }
        currentPlayerRecordsVo.setUpdateTime(new Date());
        currentPlayerRecordsVo.setTurn(false);
        currentPlayerRecordsVo.setData(map);
        redisClient.hSet(gameNo, String.valueOf(userId), currentPlayerRecordsVo);

        againstPlayerRecordsVo.setUpdateTime(new Date());
        againstPlayerRecordsVo.setTurn(true);
        redisClient.hSet(gameNo, String.valueOf(againstId), againstPlayerRecordsVo);
        //若是机器人则机器算法叫骰否则推送给真实玩家
        if(againstPlayerRecordsVo.isRobot()){
            int randomNum=(int)(Math.random() * 7)+3;//休眠时间3-10秒钟
            try {
                Thread.sleep(randomNum*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RobotCallVo robotCallVo=robotCallNumber(map,againstPlayerRecordsVo.isRobotWin(),againstPlayerRecordsVo.getCallNumRound(),againstPlayerRecordsVo.getRandomNum(),
                    currentPlayerRecordsVo.getRandomNum(),MapUtils.getBooleanValue(map,"hasCallOne"));
            if(robotCallVo.isOpen()){
                boolean isWin = compute(againstPlayerRecordsVo.getRandomNum(), currentPlayerRecordsVo.getRandomNum(), map, MapUtils.getBooleanValue(map,"hasCallOne"));
                if (isWin) {
                    win(againstPlayerRecordsVo, currentPlayerRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RESULT);
                } else {
                    win(currentPlayerRecordsVo, againstPlayerRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RESULT);
                }
            }else{
                map.put("times",robotCallVo.getTimes());
                map.put("number",robotCallVo.getNumber());

                //推送消息给当前用户
                sendMessage(map, gameNo, userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_FOLLOW);
                //设置叫骰超时监测任务
                breakGameJobService.breakGameOvertimeTask(currentPlayerRecordsVo);

                currentPlayerRecordsVo.setUpdateTime(new Date());
                currentPlayerRecordsVo.setTurn(true);
                currentPlayerRecordsVo.setCallNumRound(currentPlayerRecordsVo.getCallNumRound()+1);
                redisClient.hSet(gameNo, String.valueOf(userId), currentPlayerRecordsVo);

                againstPlayerRecordsVo.setUpdateTime(new Date());
                againstPlayerRecordsVo.setData(map);
                againstPlayerRecordsVo.setTurn(false);
                againstPlayerRecordsVo.setCallNumRound(againstPlayerRecordsVo.getCallNumRound()+1);
                redisClient.hSet(gameNo, String.valueOf(againstId), againstPlayerRecordsVo);
            }
        }else {
            //推送消息给对手
            sendMessage(map, gameNo, againstId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_FOLLOW);
            //设置叫骰超时监测任务
            breakGameJobService.breakGameOvertimeTask(againstPlayerRecordsVo);
        }

    }

    /**
     * 用户认输放弃比赛
     *
     * @param userId
     * @param againstId
     * @param gameNo
     */
    @Override
    public void giveUp(long userId, long againstId, String gameNo) {
        //移除叫骰超时监测任务
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, gameNo + userId);
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, gameNo + againstId);

        GameBreakUserRecordsVo breakGameUserRecordsVo = redisClient.hGet(gameNo, String.valueOf(userId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (breakGameUserRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户游戏记录不存在！gameNo={},againstId={}", gameNo, userId);
            return;
        }
        GameBreakUserRecordsVo againstPlayerRecordsVo = redisClient.hGet(gameNo, String.valueOf(againstId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (againstPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户对手游戏记录不存在！gameNo={},againstId={}", gameNo, againstId);
            return;
        }
        win(againstPlayerRecordsVo, breakGameUserRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_GIVE_UP);
    }

    /**
     * 比赛超时未叫骰
     *
     * @param breakGameUserRecordsVo
     */
    @Override
    public void callNumberOvertime(GameBreakUserRecordsVo breakGameUserRecordsVo) {
        GameBreakUserRecordsVo againstPlayerRecordsVo = redisClient.hGet(breakGameUserRecordsVo.getGameNo(), String.valueOf(breakGameUserRecordsVo.getAgainstId()),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (againstPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户对手游戏记录不存在！gameNo={},againstId={}", breakGameUserRecordsVo.getGameNo(), breakGameUserRecordsVo.getAgainstId());
            return;
        }
        win(againstPlayerRecordsVo, breakGameUserRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_CALL_NUMBER_OVERTIME);
    }

    /**
     * 玩家开骰
     *
     * @param userId
     */
    @Override
    public void open(long userId, long againstId, String gameNo) {
        //移除叫骰超时监测任务
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, gameNo + againstId);
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, gameNo + userId);
        //当前用户信息
        GameBreakUserRecordsVo breakGameUserRecordsVo = redisClient.hGet(gameNo, String.valueOf(userId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (breakGameUserRecordsVo == null) {
            sendMessage(null, gameNo, userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_END);//本赛场已结束
            logger.info("【游戏异常】该游戏当前赛场用户游戏记录不存在！gameNo={},againstId={}", gameNo, userId);
            return;
        }
        //对手信息
        GameBreakUserRecordsVo againstPlayerRecordsVo = redisClient.hGet(gameNo, String.valueOf(againstId),GameBreakUserRecordsVo.class); //获取当前用户信息
        if (againstPlayerRecordsVo == null) {
            logger.info("【游戏异常】该游戏当前赛场用户对手游戏记录不存在！gameNo={},againstId={}", gameNo, againstId);
            return;
        }
        boolean isWin = compute(breakGameUserRecordsVo.getRandomNum(), againstPlayerRecordsVo.getRandomNum(), (Map) againstPlayerRecordsVo.getData(), againstPlayerRecordsVo.isHasCallOne());
        if (isWin) {
            win(breakGameUserRecordsVo, againstPlayerRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RESULT);
        } else {
            win(againstPlayerRecordsVo, breakGameUserRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_RESULT);
        }

    }

    /**
     * 表情
     *
     * @param userId    用户id
     * @param againstId 对手id
     * @param gameNo    赛场编码
     * @param data      表情数据
     */
    @Override
    public void emoticon(long userId, long againstId, String gameNo, String data) {
        sendMessage(data, gameNo, againstId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_EMOTICON);
    }

    /**
     * 赢得单轮pk
     *
     * @param userRecordsVo    赢家玩家记录
     * @param againstRecordsVo 对手玩家记录
     * @param resultCode       结果编码
     */
    @Override
    public void win(GameBreakUserRecordsVo userRecordsVo, GameBreakUserRecordsVo againstRecordsVo, String resultCode) {

        if (userRecordsVo == null || againstRecordsVo==null) {
            return;
        }
        //移除叫骰超时监测任务
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, userRecordsVo.getGameNo() + userRecordsVo.getUserId());
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_OVERTIME, userRecordsVo.getGameNo() + againstRecordsVo.getUserId());

        int round = userRecordsVo.getPassMaxLevel();//当前关卡数
        int lastRound = round + 1;
        int maxRound = 7;//最终关卡数
        boolean isPass = false;
        //通关
        if (lastRound >= maxRound) {
            isPass = true;
        }
        Object lastData = null;
        if (userRecordsVo.isTurn()) {
            lastData = againstRecordsVo.getData();
        } else {
            lastData = userRecordsVo.getData();
        }

        userRecordsVo.setPassMaxLevel((short) lastRound);
        userRecordsVo.setUpdateTime(new Date());
        userRecordsVo.setHasCallOne(false);
        userRecordsVo.setWin(true);
        userRecordsVo.setIslive(true);
        //当前用户推送胜利消息
        if(!userRecordsVo.isRobot()){
            PkResultVo userPkResultVo = new PkResultVo();

            userPkResultVo.setCurrentRound(lastRound);
            if (isPass) {
                userPkResultVo.setPass(true);
            } else {
                userPkResultVo.setPass(false);
            }
            userPkResultVo.setShareTimes(userRecordsVo.getShareTimes());
            userPkResultVo.setMaxShareTimes(userRecordsVo.getMaxShareTimes());
            userPkResultVo.setShareType(userRecordsVo.getShareType());
            userPkResultVo.setWin(true);
            userPkResultVo.setHasCallOne(userRecordsVo.isHasCallOne());
            userPkResultVo.setRandomNum(userRecordsVo.getRandomNum());
            userPkResultVo.setAgaistrandomNum(againstRecordsVo.getRandomNum());
            userPkResultVo.setData(userRecordsVo.getData());
            userPkResultVo.setAgaistData(againstRecordsVo.getData());
            userPkResultVo.setLastData(lastData);
            sendMessage(userPkResultVo, userRecordsVo.getGameNo(), userRecordsVo.getUserId(), resultCode);
            if (againstRecordsVo.isGameBoxPlayer()){
                gameBoxService.sendToGameBoxSystem(false, userRecordsVo.getUserId(), userRecordsVo.getUid(), true);
            }
        }


        //对手用户推送淘汰消息
        if(!againstRecordsVo.isRobot()){
            PkResultVo againstPkResultVo = new PkResultVo();
            againstPkResultVo.setShareTimes(againstRecordsVo.getShareTimes());
            againstPkResultVo.setMaxShareTimes(againstRecordsVo.getMaxShareTimes());
            againstPkResultVo.setShareType(againstRecordsVo.getShareType());
            againstPkResultVo.setHasCallOne(againstRecordsVo.isHasCallOne());
            againstPkResultVo.setCurrentRound(againstRecordsVo.getPassMaxLevel() + (short) 1);
            againstPkResultVo.setPass(false);
            againstPkResultVo.setWin(false);
            againstPkResultVo.setRandomNum(againstRecordsVo.getRandomNum());
            againstPkResultVo.setAgaistrandomNum(userRecordsVo.getRandomNum());
            againstPkResultVo.setData(againstRecordsVo.getData());
            againstPkResultVo.setAgaistData(userRecordsVo.getData());
            againstPkResultVo.setLastData(lastData);
            sendMessage(againstPkResultVo, againstRecordsVo.getGameNo(), againstRecordsVo.getUserId(), resultCode);
            if (againstRecordsVo.isGameBoxPlayer()){
                gameBoxService.sendToGameBoxSystem(false, againstRecordsVo.getUserId(), againstRecordsVo.getUid(), false);
            }
        }

        //更新在线人数
        GameBreakRecords breakGameRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(userRecordsVo.getGameId()),GameBreakRecords.class); //获取当前赛场信息
        if (breakGameRecords == null) {
            logger.info("【游戏异常】该游戏当前赛场记录不存在！gameId={}", userRecordsVo.getGameId());
            return;
        }

        //如果是通关则当前人数减2，通关人次加1；否则当前人数减1
        if (isPass) {
            breakGameRecords.setContestNum(breakGameRecords.getContestNum() - 2);
            breakGameRecords.setPassThroughNum(breakGameRecords.getPassThroughNum() + 1);
        } else {
            breakGameRecords.setContestNum(breakGameRecords.getContestNum() - 1);
        }
        breakGameRecords.setUpdateTime(new Date());
        redisClient.hSet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(userRecordsVo.getGameId()), breakGameRecords);

        //淘汰对手比赛信息保存至等待复活(如果当前是第1关则不需要)
        if (!againstRecordsVo.isRobot() && againstRecordsVo.getPassMaxLevel() > 0) {
            againstRecordsVo.setWin(false);
            againstRecordsVo.setIslive(false);
            againstRecordsVo.setData(null);
            againstRecordsVo.setTurn(false);
            againstRecordsVo.setAgaistData(null);
            redisClient.hSet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + breakGameRecords.getGameNo(), String.valueOf(againstRecordsVo.getUserId()), againstRecordsVo);
        }else {
            redisClient.hDel(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + breakGameRecords.getGameNo(), String.valueOf(againstRecordsVo.getUserId()));
        }

        //如果通关则回写当前用户比赛记录至数据库,否则继续等待匹配比赛
        if(!userRecordsVo.isRobot()) {
            if (isPass) {
//                GameBreakAgainstRecords breakGameUserRecords = new GameBreakAgainstRecords();
//                BeanUtils.copyProperties(userRecordsVo, breakGameUserRecords);
            //    breakGameUserRecordsService.saveOrUpdate(breakGameUserRecords);
                //用户领奖资格记录
                GameBreakUserQualify breakGameUserQualify = new GameBreakUserQualify();
                GameBreakUserQualifyExample breakGameUserQualifyExample = new GameBreakUserQualifyExample();
                breakGameUserQualifyExample.or().andGameModelIdEqualTo(userRecordsVo.getGameId()).andGameNoEqualTo(userRecordsVo.getGameNo()).andUserIdEqualTo(userRecordsVo.getUserId());
                List<GameBreakUserQualify> breakGameUserQualifyList = breakGameUserQualifyService.selectByExample(breakGameUserQualifyExample);
                if (null != breakGameUserQualifyList && breakGameUserQualifyList.size() > 0) {
                    breakGameUserQualify = breakGameUserQualifyList.get(0);
                    breakGameUserQualify.setPassTimes(breakGameUserQualify.getPassTimes() + 1);
                    breakGameUserQualify.setUpdateTime(new Date());
                } else {
                    breakGameUserQualify.setGameModelId(userRecordsVo.getGameId());
                    breakGameUserQualify.setGameNo(userRecordsVo.getGameNo());
                    breakGameUserQualify.setUserId(userRecordsVo.getUserId());
                    breakGameUserQualify.setNickName(userRecordsVo.getNickName());
                    breakGameUserQualify.setHeadUrl(userRecordsVo.getHeadUrl());
                    breakGameUserQualify.setIsAward(false);
                    breakGameUserQualify.setPassTimes(1);
                }
                breakGameUserQualifyService.saveOrUpdate(breakGameUserQualify);
                redisClient.hDel(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + breakGameRecords.getGameNo(), String.valueOf(userRecordsVo.getUserId()));

            } else {
                //闯关比赛赢得关卡后等待继续闯关的玩家
                userRecordsVo.setTurn(false);
                userRecordsVo.setData(null);
                userRecordsVo.setAgaistData(null);
                redisClient.hSet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + breakGameRecords.getGameNo(), String.valueOf(userRecordsVo.getUserId()), userRecordsVo);
            }
        }

        //移除玩家正在比赛记录
        redisClient.hDel(userRecordsVo.getGameNo(), String.valueOf(userRecordsVo.getAgainstId()));
        redisClient.hDel(userRecordsVo.getGameNo(), String.valueOf(userRecordsVo.getUserId()));

        //当前用户该轮次比赛记录保存
        GameBreakAgainstRecords currentRoundRecords = new GameBreakAgainstRecords();
        currentRoundRecords.setUserId(userRecordsVo.getUserId());
        currentRoundRecords.setGameModelId(userRecordsVo.getGameId());
        currentRoundRecords.setGameNo(userRecordsVo.getGameNo());
        currentRoundRecords.setGameRound(userRecordsVo.getPassMaxLevel());
        currentRoundRecords.setNickName(userRecordsVo.getNickName());
        currentRoundRecords.setHeadUrl(userRecordsVo.getHeadUrl());
        currentRoundRecords.setIsWin(true);
        currentRoundRecords.setCreateTime(new Date());
        currentRoundRecords.setAgainstHeadUrl(againstRecordsVo.getHeadUrl());
        currentRoundRecords.setAgainstNickName(againstRecordsVo.getNickName());
        currentRoundRecords.setAgainstUserId(againstRecordsVo.getUserId());
        currentRoundRecords.setGameModelKey(SystemConstant.GAME_BREAK_MODEL_KEY);
        breakGameAgainstRecordsService.saveOrUpdate(currentRoundRecords);
        //对手该轮次比赛记录保存
        GameBreakAgainstRecords againstRoundRecords = new GameBreakAgainstRecords();
        againstRoundRecords.setUserId(againstRecordsVo.getUserId());
        againstRoundRecords.setGameModelId(againstRecordsVo.getGameId());
        againstRoundRecords.setGameNo(againstRecordsVo.getGameNo());
        againstRoundRecords.setNickName(againstRecordsVo.getNickName());
        againstRoundRecords.setHeadUrl(againstRecordsVo.getHeadUrl());
        againstRoundRecords.setGameRound((short)(againstRecordsVo.getPassMaxLevel() + 1));
        againstRoundRecords.setIsWin(false);
        againstRoundRecords.setCreateTime(new Date());
        againstRoundRecords.setAgainstHeadUrl(userRecordsVo.getHeadUrl());
        againstRoundRecords.setAgainstNickName(userRecordsVo.getNickName());
        againstRoundRecords.setAgainstUserId(userRecordsVo.getUserId());
        againstRoundRecords.setGameModelKey(SystemConstant.GAME_BREAK_MODEL_KEY);
        breakGameAgainstRecordsService.saveOrUpdate(againstRoundRecords);
    }

    /**
     * 匹配对手
     *
     * @param breakGameUserRecordsVo 当前玩家游戏信息
     */
    @Override
    public synchronized void match(GameBreakUserRecordsVo breakGameUserRecordsVo) {
        GameBreakRecords breakGameRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(breakGameUserRecordsVo.getGameId()),GameBreakRecords.class); //获取当前赛场信息
        if (breakGameRecords == null) {
            logger.info("【游戏异常】该游戏当前赛场不存在！gameId={}", breakGameUserRecordsVo.getGameId());
            sendMessage(null, breakGameUserRecordsVo.getGameNo(), breakGameUserRecordsVo.getUserId(), SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_END);//本赛场已结束
            return;
        }
        long userId = breakGameUserRecordsVo.getUserId();
        final String key = RedisFiledConstant.BREAK_GAME_NOT_MATCH_PLAYER + "_" + breakGameRecords.getGameNo();
        final String field = String.valueOf(userId);
        breakGameUserRecordsVo.setGameNo(breakGameRecords.getGameNo());

        Map<String, GameBreakUserRecordsVo> userRecordsVoMap = redisClient.hGetAll(key, GameBreakUserRecordsVo.class);//获取当前赛场等待匹配玩家信息
        //如等待区无选手等待则玩家进入等待，否则匹配对手进入游戏
        if (null != userRecordsVoMap && userRecordsVoMap.size() > 0) {
            logger.info("【游戏正常】该游戏当前赛场有玩家等待，进行匹配！gameNO={}", breakGameRecords.getGameNo());
            GameBreakUserRecordsVo breakGameAgainstUserRecordsVo = userRecordsVoMap.entrySet().iterator().next().getValue();
            //是否为同一玩家
            if (breakGameUserRecordsVo.getUserId().equals(breakGameAgainstUserRecordsVo.getUserId())) {
                logger.info("【游戏正常】该游戏当前赛场无其他玩家等待！userId={},gameNO={}", breakGameUserRecordsVo.getUserId(), breakGameRecords.getGameNo());
                breakGameUserRecordsVo.setTurn(true);
                redisClient.hSetWithExpire(key, field, breakGameUserRecordsVo,30);
            } else {
                //删除机器人匹配任务
                breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_ROBOT_MATCH,breakGameAgainstUserRecordsVo.getGameNo() + breakGameAgainstUserRecordsVo.getUserId());
                //当前玩家推送消息
                breakGameUserRecordsVo.setAgainstId(breakGameAgainstUserRecordsVo.getUserId());
                breakGameUserRecordsVo.setAgaistHeadUrl(breakGameAgainstUserRecordsVo.getHeadUrl());
                breakGameUserRecordsVo.setAgaistNickName(breakGameAgainstUserRecordsVo.getNickName());
                breakGameUserRecordsVo.setAgaistGender(breakGameAgainstUserRecordsVo.getGender());
                breakGameUserRecordsVo.setHasCallOne(false);
                breakGameUserRecordsVo.setRandomNum(RandomUtil.randomNum(1, 7, 5));
                sendMessage(breakGameUserRecordsVo, breakGameRecords.getGameNo(), userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_BEGIN);

                //当前玩家PK对手推送消息
                breakGameAgainstUserRecordsVo.setAgainstId(breakGameUserRecordsVo.getUserId());
                breakGameAgainstUserRecordsVo.setAgaistHeadUrl(breakGameUserRecordsVo.getHeadUrl());
                breakGameAgainstUserRecordsVo.setAgaistNickName(breakGameUserRecordsVo.getNickName());
                breakGameAgainstUserRecordsVo.setAgaistGender(breakGameUserRecordsVo.getGender());
                breakGameAgainstUserRecordsVo.setHasCallOne(false);
                breakGameAgainstUserRecordsVo.setRandomNum(RandomUtil.randomNum(1, 7, 5));
                sendMessage(breakGameAgainstUserRecordsVo, breakGameRecords.getGameNo(), breakGameAgainstUserRecordsVo.getUserId(), SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_BEGIN);

                //记录移至比赛数据缓存热区
                redisClient.hDel(key, String.valueOf(breakGameAgainstUserRecordsVo.getUserId()));
                redisClient.hSet(breakGameRecords.getGameNo(), String.valueOf(userId), breakGameUserRecordsVo);
                redisClient.hSet(breakGameRecords.getGameNo(), String.valueOf(breakGameAgainstUserRecordsVo.getUserId()),breakGameAgainstUserRecordsVo);
                //设置叫骰超时监测任务
                breakGameJobService.breakGameOvertimeTask(breakGameAgainstUserRecordsVo);

            }
        } else {
            logger.info("【游戏正常】该游戏当前赛场无玩家等待！gameNO={}", breakGameRecords.getGameNo());
            breakGameUserRecordsVo.setTurn(true);
            redisClient.hSet(key, field,breakGameUserRecordsVo);
            //机器人匹配任务
            int randomTimes=0;
            int random=(int)(Math.random() * 100);
            if(random>=80){
                randomTimes=(int)(Math.random() * 25*1000)+50;//匹配时间50-30*1000毫秒间
                logger.info("机器人匹配时间："+randomTimes);
                breakGameJobService.robotMacthTask(breakGameUserRecordsVo,randomTimes);
            }else if(random>=30 && random<80) {
                randomTimes=(int)(Math.random() * 3*1000);//匹配时间0-3*1000毫秒间
                logger.info("机器人匹配时间："+randomTimes);
                breakGameJobService.robotMacthTask(breakGameUserRecordsVo,randomTimes);
            }else{
                Map paramMap=new HashMap();
                paramMap.put("breakGameUserRecordsVo",breakGameUserRecordsVo);
                robotMatch(paramMap);
            }
        }


        //更新当前在线人数
        breakGameRecords.setContestNum(breakGameRecords.getContestNum() + 1);
        redisClient.hSet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(breakGameUserRecordsVo.getGameId()), breakGameRecords);

    }

    /**
     * 计算骰子点数比赛PK结果
     *
     * @param currentPlayerRandomNum 当前用户骰子点数
     * @param againstPlayerRandomNum 对手用户骰子点数
     * @param map                    叫骰点数
     * @return
     */
    @Override
    public boolean compute(int currentPlayerRandomNum, int againstPlayerRandomNum, Map map, boolean hasCallOne) {
        int times = MapUtils.getIntValue(map, "times");
        int number = MapUtils.getIntValue(map, "number");
        int count = 0;//记录点数为1的个数
        //所有点数计数
        Map dataMap = new HashMap();
        String numStr = String.valueOf(currentPlayerRandomNum) + String.valueOf(againstPlayerRandomNum);
        for (int i = 0; i < numStr.length(); i++) {
            String num = String.valueOf(numStr.charAt(i));
            if ("1".equals(num)) {
                count++;
            }
            if (dataMap.containsKey(num)) {
                int countTimes = MapUtils.getIntValue(dataMap, num);
                dataMap.put(num, countTimes + 1);
            } else {
                dataMap.put(num, 1);
            }
        }
        int t = 0;
        if (dataMap.containsKey(String.valueOf(number))) {
            t = MapUtils.getIntValue(dataMap, String.valueOf(number));
        }
        //是否叫过1，若叫过1则1只能代表1
        if (!"1".equals(String.valueOf(number)) && !hasCallOne) {
            t += count;
        }
        if (times <= t) { //叫点数的个数是否大于累计个数
            return false;
        }
        return true;
    }

    /**
     * 退出比赛(长时间等待匹配对手)
     *
     * @param userId  用户ID
     * @param gameNo  游戏编码
     * @param isBegin 是否为进入比赛阶段匹配对手
     */
    @Override
    public void quit(long userId, long gameId, String gameNo, boolean isBegin) {
        if (isBegin) {
            redisClient.hDel(RedisFiledConstant.BREAK_GAME_NOT_MATCH_PLAYER + "_" + gameNo, String.valueOf(userId));
        } else {
            GameBreakUserRecordsVo userRecordsVo = redisClient.hGet(RedisFiledConstant.BREAK_GAME_NOT_MATCH_PLAYER + "_" + gameNo, String.valueOf(userId),GameBreakUserRecordsVo.class); //获取当前用户正在匹配信息
            if (userRecordsVo == null) {
                logger.info("【游戏异常】该游戏当前赛场用户游戏记录不存在！gameNo={},againstId={}", gameNo, userId);
                return;
            }
            redisClient.hDel(RedisFiledConstant.BREAK_GAME_NOT_MATCH_PLAYER + "_" + gameNo, String.valueOf(userId));
            redisClient.hSet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo, String.valueOf(userId), userRecordsVo);
        }

        //更新在线人数
        GameBreakRecords breakGameRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId),GameBreakRecords.class); //获取当前赛场信息
        if (breakGameRecords == null) {
            logger.info("【游戏异常】该游戏当前赛场记录不存在！gameId={}", gameId);
            return;
        }
        breakGameRecords.setContestNum(breakGameRecords.getContestNum() - 1);
        redisClient.hSet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId), breakGameRecords);
        //删除机器人匹配任务
        breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_ROBOT_MATCH,gameNo+ userId);

    }


    /**
     * 推送消息
     */
    public void sendMessage(Object data, String group, long userId, String msgCode) {
        SocketResponseMsg msg = new SocketResponseMsg();
        msg.setCode(msgCode);
        msg.setSuccess(true);
        msg.setResult(data);
        webSocketHandlerService.sendMessageToUser(group, "user" + userId, new TextMessage(JSONUtil.toJson(msg)));
    }


    /**
     * 机器人匹配
     * @param paramMap
     */
    public void robotMatch(Map paramMap){
        GameBreakUserRecordsVo breakGameUserRecordsVo =(GameBreakUserRecordsVo)paramMap.get("breakGameUserRecordsVo");
        GameBreakUserRecordsVo robotRecordsVo=getARobot(breakGameUserRecordsVo.getGameId());

        boolean isRobotWin=getRobotResult(breakGameUserRecordsVo.getPassMaxLevel()+1,breakGameUserRecordsVo.getPlayerType());
        robotRecordsVo.setRobotWin(isRobotWin);
        breakGameUserRecordsVo.setRobotWin(isRobotWin);

        GameBreakRecords breakGameRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(breakGameUserRecordsVo.getGameId()),GameBreakRecords.class); //获取当前赛场信息
        if (breakGameRecords == null) {
            logger.info("【游戏异常】该游戏当前赛场不存在！gameId={}", breakGameUserRecordsVo.getGameId());
            sendMessage(null, breakGameUserRecordsVo.getGameNo(), breakGameUserRecordsVo.getUserId(), SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_END);//本赛场已结束
            return;
        }
        long userId = breakGameUserRecordsVo.getUserId();
        final String key = RedisFiledConstant.BREAK_GAME_NOT_MATCH_PLAYER + "_" + breakGameRecords.getGameNo();
        final String field = String.valueOf(userId);
        breakGameUserRecordsVo.setGameNo(breakGameRecords.getGameNo());
        robotRecordsVo.setGameNo(breakGameRecords.getGameNo());
        //真实玩家推送消息
        breakGameUserRecordsVo.setAgainstId(robotRecordsVo.getUserId());
        breakGameUserRecordsVo.setAgaistHeadUrl(robotRecordsVo.getHeadUrl());
        breakGameUserRecordsVo.setAgaistNickName(robotRecordsVo.getNickName());
        breakGameUserRecordsVo.setAgaistGender(robotRecordsVo.getGender());
        breakGameUserRecordsVo.setHasCallOne(false);
        breakGameUserRecordsVo.setRandomNum(RandomUtil.randomNum(1, 7, 5));
        breakGameUserRecordsVo.setTurn(true);
        sendMessage(breakGameUserRecordsVo, breakGameRecords.getGameNo(), userId, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_BEGIN);


        //记录移至比赛数据缓存热区
        redisClient.hDel(key, String.valueOf(breakGameUserRecordsVo.getUserId()));
        redisClient.hSet(breakGameRecords.getGameNo(), String.valueOf(userId), breakGameUserRecordsVo);
        redisClient.hSet(breakGameRecords.getGameNo(), String.valueOf(robotRecordsVo.getUserId()), robotRecordsVo);
        //设置叫骰超时监测任务
        breakGameJobService.breakGameOvertimeTask(breakGameUserRecordsVo);

        //更新当前在线人数
        breakGameRecords.setContestNum(breakGameRecords.getContestNum() + 1);
        redisClient.hSet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(breakGameUserRecordsVo.getGameId()), breakGameRecords);
        logger.info("机器人骰数："+robotRecordsVo.getRandomNum()+" 真实玩家骰数："+breakGameUserRecordsVo.getRandomNum());

    }


    /**
     * 获取机器人用户
     * @return
     */
    public GameBreakUserRecordsVo getARobot(long gameId){
        User user = new User();
        UserExample userExample=new UserExample();
        userExample.or().andIsRobotEqualTo(true).andStatusEqualTo(SystemConstant.VALID);
        List<User> userList=userService.selectByExample(userExample);
        if(null!=userList && userList.size()>0){
            int randomIndex =(int)(Math.random() * (userList.size()-1));
            user=userList.get(randomIndex);//产生随机机器人用户
        }

        //机器人比赛记录
        GameBreakUserRecordsVo breakGameUserRecordsVo = new GameBreakUserRecordsVo();
        breakGameUserRecordsVo.setCreateTime(new Date());
        breakGameUserRecordsVo.setUpdateTime(new Date());
        breakGameUserRecordsVo.setGameId(gameId);
        breakGameUserRecordsVo.setIsPass(false);
        breakGameUserRecordsVo.setPassMaxLevel((short) 0);
        breakGameUserRecordsVo.setRandomNum(RandomUtil.randomNum(1, 7, 5));
        breakGameUserRecordsVo.setTurn(false);
        breakGameUserRecordsVo.setUserId(user.getId());
        breakGameUserRecordsVo.setHasCallOne(false);
        breakGameUserRecordsVo.setIslive(true);
        breakGameUserRecordsVo.setRecoveryTimes(0);
        breakGameUserRecordsVo.setRobot(true);

        if (user != null) {
            UserInfo userInfo = userInfoService.selectByUserId(user.getId());
            breakGameUserRecordsVo.setHeadUrl(userInfo.getHeadPicUrl());
            breakGameUserRecordsVo.setNickName(user.getNickName());
            breakGameUserRecordsVo.setGender(userInfo.getGender());
        }
        return breakGameUserRecordsVo;
    }

    private boolean getRobotResult(int round,String playerType){
        if (playerType == null){
            playerType = "NEW_PLAYER";
        }
        List<GameConfig> gameConfigs = gameConfigService.getByType(GameConstants.DHS_BREAK_MODEL, "GAME_WIN_PERCENT");
        Map<String, String> map = gameConfigs.stream().collect(Collectors.toMap(GameConfig::getCode, a -> a.getTypeValue()));
        List<Integer> winPercent = (List<Integer>)JSON.parse(map.get(playerType));
        logger.info("winPercent=",winPercent);
        int wp = winPercent.get(round-1);
        logger.info("robot winPercent={}",wp);
        Random r = new Random();
        int rp = r.nextInt(99) + 1;
        if(rp <= wp){
            logger.info("第"+round+"关卡机器人预测结果为胜利");
            return true;
        }
        logger.info("第"+round+"关卡机器人预测结果为失败");
        return false;
    }

    /**
     * 根据预设概率获取机器人pk结果
     * @param round 关卡数
     * @return
     */
    public boolean getRobotResult(int round,boolean isOldPlayer){
        //机器人胜率：第一关：20% 第二关：30% 第三关：50% 第四关：50% 第五关：50% 第六关：50% 第七关：65%
        int[]  winPercent=null;
        if (isOldPlayer){
            winPercent=new int[]{20,30,50,50,50,50,70};
        }else {
            winPercent=new int[]{20,20,20,20,30,30,30};
        }
        int wp=winPercent[round-1];
        int randomNum=(int)(Math.random() * 99)+1;//获取1-100随机数
        logger.info("随机数："+randomNum);
        if(randomNum<=wp){
            logger.info("第"+round+"关卡机器人预测结果为胜利");
            return true;
        }
        logger.info("第"+round+"关卡机器人预测结果为失败");
        return false;
    }


    /**
     * 机器人叫骰
     * @param againstDataMap  对手叫骰数
     * @param isRobotWin  预设输赢
     * @param turn 叫骰轮次
     * @param currentPlayerRandomNum 机器人点数
     * @param againstPlayerRandomNum 对手点数
     * @param hasCallOne  是否叫1
     * @return
     */
    public RobotCallVo robotCallNumber(Map againstDataMap, boolean isRobotWin,int turn,int currentPlayerRandomNum, int againstPlayerRandomNum,boolean hasCallOne){
        RobotCallVo robotCallVo=new RobotCallVo();
        robotCallVo.setOpen(false);
        int times = MapUtils.getIntValue(againstDataMap, "times");
        int number = MapUtils.getIntValue(againstDataMap, "number");
        /**
         * 叫骰规则
         * 1.预设赢：1）第一、二回合对手叫骰小于等于实际点数则跟，大于实际点数则开；2)第三回合后，轮到机器人叫骰直接叫死；若对手玩家叫骰点数大于实际点数则开；若对手叫死，则继续跟直至对手开；
         * 2.预设输：若叫骰数未达上限"10个X",则继续跟；若达上限则开
         */
        if(isRobotWin){
            boolean isWin=compute(currentPlayerRandomNum,againstPlayerRandomNum,againstDataMap,hasCallOne);
            if(isWin || times>=8){
                robotCallVo.setOpen(true);
            }else{
                if(turn<3){
                    robotCallVo.setNumber(number);
                    robotCallVo.setTimes(times+1);
                }else{
                    Map dataMap=countNum(currentPlayerRandomNum,againstPlayerRandomNum);
                    int maxTimes=MapUtils.getIntValue(dataMap,String.valueOf(number));//叫死个数
                    if(!hasCallOne){
                        if(dataMap.containsKey("1")){
                            maxTimes+=MapUtils.getIntValue(dataMap,"1");
                        }
                    }
                    robotCallVo.setTimes(maxTimes);
                    robotCallVo.setNumber(number);
                }
            }
        }else {
            boolean hasTimes=false;//如果机器人骰数已经够了，则不开
            int count=0;
            String numStr=String.valueOf(currentPlayerRandomNum);
            for(int i=0;i<numStr.length();i++) {
                String c=String.valueOf(numStr.charAt(i));
                if(String.valueOf(number).equals(c)||("1".equals(c)  && !hasCallOne)){
                    count++;
                }
            }
            if(count>=times){
                hasTimes=true;
            }
            int randomNum = (int) (Math.random() * 99) + 1;//获取1-100随机数
            if ((!hasTimes && randomNum >= 80) || times >= 8) {//1.叫骰到上限开；2.每回合设置20%概率开骰
                robotCallVo.setOpen(true);
            } else {
                int disTimes=10-times;
                disTimes=disTimes>=3?1:disTimes;
                int randomCallTimes = (int) (Math.random() * disTimes) + 1;//获取1-10随机数
                if (number == 6) {
                    robotCallVo.setNumber(number);
                    robotCallVo.setTimes(times+randomCallTimes);
                } else {
                    int flag = (int) Math.random()*2;
                    if(flag==0){
                        robotCallVo.setNumber(number+1);
                        robotCallVo.setTimes(times);
                    }else{
                        robotCallVo.setNumber(number);
                        robotCallVo.setTimes(times+randomCallTimes);
                    }

                }
            }
        }
        return robotCallVo;
    }

    /**
     * 计算骰子点数
     * @param currentPlayerRandomNum 当前用户骰子点数
     * @param againstPlayerRandomNum 对手用户骰子点数
     * @return
     */
    public Map countNum(int currentPlayerRandomNum, int againstPlayerRandomNum){
        Map dataMap = new HashMap();
        String numStr = String.valueOf(currentPlayerRandomNum) + String.valueOf(againstPlayerRandomNum);
        for (int i = 0; i < numStr.length(); i++) {
            String num = String.valueOf(numStr.charAt(i));
            if (dataMap.containsKey(num)) {
                int countTimes = MapUtils.getIntValue(dataMap, num);
                dataMap.put(num, countTimes + 1);
            } else {
                dataMap.put(num, 1);
            }
        }
        return  dataMap;
    }

    /**
     * 游戏结算
     *
     * @param gameId
     */
    @Override
    public void closeGame(Long gameId) {
        String requestId = UUID.randomUUID().toString();
        int expireTime = 1000*60*60;//过期时间毫秒数 1hour
        //redis分布式锁 加锁
        if (!redisLock.tryGetDistributedLock(RedisFiledConstant.CLOSE_BREAK_GAME_LOCK, requestId, expireTime)){
            return;
        }
        logger.info("【大话骰结算】 开始闯关结算");
        String gameNo = null;

        GameModel game = gameModelService.selectById(gameId);
        if (game == null) {
            return;
        }
        GameBreakRecords gameRecord = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId), GameBreakRecords.class);
        Map<String, String> configs = gameConfigService.getByGameModelKey(game.getGameModelKey());

        //游戏结算
        if (gameRecord != null) {
            try {
                gameNo = gameRecord.getGameNo();
                closeGame(gameId, gameRecord, configs);
            } catch (Exception e) {
                logger.error("【大话骰结算】 发放奖励结算失败。Exception:{}", e.toString());
            }
        }
        //推送通关消息
        wechatService.sendModelMsg();
        //保存等待区用户游戏记录
        if (gameNo != null) {
            try {
                Map<String, GameBreakUserRecordsVo> userRecordsVoMap = redisClient.hGetAll(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo, GameBreakUserRecordsVo.class);
                if (userRecordsVoMap != null || !userRecordsVoMap.isEmpty()) {
                    for (Map.Entry<String, GameBreakUserRecordsVo> entry : userRecordsVoMap.entrySet()) {
                        GameBreakUserRecords records = new GameBreakUserRecords();
                        BeanUtils.copyProperties(entry.getValue(), records);
                        userRecordsService.saveOrUpdate(records);
                    }
                }
                redisClient.del(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameNo);
                redisClient.del(gameRecord.getGameNo());
            } catch (Exception e) {
                logger.error("【大话骰结算】 保存等待区用户失败。Exception:{}", e.toString());
            }
        }


        logger.info("【大话骰结算】 大话骰结算结束");
        //结算完毕，开启新一轮比赛
        try {
            breakGameJobService.removeGameJob(SystemConstant.TASK_GROUP_BREAK_GAME_CLOSE, gameNo);
            logger.info("【大话骰结算】 创建大话骰结算任务开始");
            redisClient.hDel(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId));
            createNewGame(gameId);
            logger.info("【大话骰结算】 创建大话骰结算任务结束");
        } catch (Exception e) {
            logger.error("【大话骰结算】 创建大话骰结算任务失败。Exception:{}", e.toString());
        }

    }

    /**
     * 定时结算，分离出来处理事务和异常
     *
     * @param gameId
     * @param gameRecord
     * @param configs
     */
    @Transactional
    public void closeGame(Long gameId, GameBreakRecords gameRecord, Map<String, String> configs) {
        //通关人数
        Integer passNum = gameRecord.getPassThroughNum();

        if (passNum != null && passNum > 0) {
            //生成随机红包
            int bonusMax = Integer.valueOf(configs.get(GameConstants.BONUS_MAX));
            int bonusMin = Integer.valueOf(configs.get(GameConstants.BONUS_MIN));
            int bonusMaxToOne = Integer.valueOf(configs.get(GameConstants.BONUS_MAX_TO_ONE));
            Random random = new Random();
            int bonus = bonusMin + random.nextInt(bonusMax - bonusMin);
            gameRecord.setPerAward(bonus);
            gameRecord.setPassThroughNum(passNum);
            //给用户发放奖金
            GameBreakUserQualifyExample qualifyExample = new GameBreakUserQualifyExample();
            //根据gameNo和gameId查询有获奖资格的用户
            qualifyExample.or().andGameNoEqualTo(gameRecord.getGameNo())
                    .andGameModelIdEqualTo(gameId).andIsAwardEqualTo(false);
            List<GameBreakUserQualify> qualifies = breakGameUserQualifyService.selectByExample(qualifyExample);
            //奖励资格表不为空才进行发放
            if (qualifies != null && !qualifies.isEmpty()) {
                for (GameBreakUserQualify qualify : qualifies) {
                    UserInfo userInfo = userInfoService.selectByUserId(qualify.getUserId());
                    Integer moneyGet = qualify.getPassTimes() * bonus;
                    //上限3元
                    if (moneyGet > bonusMaxToOne){
                        moneyGet = bonusMaxToOne;
                    }
                    PassAwardRecord passAwardRecord = new PassAwardRecord();
                    passAwardRecord.setAwardNum(moneyGet.longValue());
                    passAwardRecord.setPassTimes(qualify.getPassTimes());
                    passAwardRecord.setUserId(qualify.getUserId());
                    passAwardRecord.setLatestPassTime(qualify.getUpdateTime());
                    passAwardRecord.setReadStat(false);
                    redisClient.hSet(RedisFiledConstant.BREAK_GAME_PASS_RECORD, qualify.getUserId().toString(),passAwardRecord);

                    userInfo.setBalance(userInfo.getBalance() + moneyGet);
                    userInfoService.saveOrUpdate(userInfo);
                    //将奖励资格表中的该用户领奖状态设置为已颁发
                    qualify.setIsAward(true);
                    breakGameUserQualifyService.saveOrUpdate(qualify);
                    //交易流水
                    User user = userService.selectById(userInfo.getUserId());
                    CoinTranslog translog = new CoinTranslog();
                    translog.setUserId(userInfo.getUserId());
                    translog.setUserName(user.getNickName());
                    translog.setTransType(SystemConstant.TRANS_TYPE_PLAY_GAME);
                    translog.setAccountType(SystemConstant.ACC_TYPE_BALANCE);
                    translog.setTransFlag(SystemConstant.TRANS_DIRECT_INCOM);
                    translog.setTransTime(new Date());
                    translog.setUserId(userInfo.getUserId());
                    translog.setBalance(userInfo.getBalance().intValue());
                    translog.setTransAmount(Integer.valueOf(moneyGet));
                    translog.setRemark(MessageHelper.generateByModel(MsgModelConstant.BREAK_GAME_NOTICE_REMARK,qualify.getPassTimes()));
                    transLogService.addTranslog(translog);

                }
            }
        } else {
            //无人通关结算
            gameRecord.setPerAward(0);
            gameRecord.setPassThroughNum(0);
        }
        //更改游戏状态为已结算
        gameRecord.setGameStatus(GameConstants.GAME_STATUS_2);
        gameBreakRecordsService.saveOrUpdate(gameRecord);
    }


    /**
     * 创建一个新游戏并创建结算定时任务
     *
     * @param gameId
     */
    @Transactional
    public synchronized GameBreakRecords createNewGame(Long gameId) {

        //redis分布式锁 加锁
        String requestId = UUID.randomUUID().toString();
        int expireTime = 30000;//过期时间毫秒数 30秒
        while (!redisLock.tryGetDistributedLock(RedisFiledConstant.CREATE_BREAK_GAME_LOCK, requestId, expireTime)){
            try {
                Thread.sleep(100);
                if (redisLock.tryGetDistributedLock(RedisFiledConstant.CREATE_BREAK_GAME_LOCK, requestId, expireTime)){
                    GameBreakRecords gameRecord = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId),GameBreakRecords.class);
                    redisLock.releaseDistributedLock(RedisFiledConstant.CREATE_BREAK_GAME_LOCK, requestId);
                    return gameRecord;
                }
            } catch (Exception e) {
                logger.error("【闯关游戏】 创建游戏获取锁异常Exception={}",e);
            }
        }
        GameModel game = gameModelService.selectById(gameId);
        GameBreakRecords redisGameRecord = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId),GameBreakRecords.class);
        //设置游戏结算时间
        Map<String, String> configs = gameConfigService.getByGameModelKey(game.getGameModelKey());
        String awardTime = configs.get(GameConstants.TIME);
        //已经存在记录说明游戏已经创建,防止重复创建游戏
        if (redisGameRecord != null) {
            if (redisGameRecord.getEndTime().equals(DateUtil.getEndTime(awardTime))) {
                logger.info("【大话骰闯关】 重复创建游戏：{}", game.getGameModelName());
                redisLock.releaseDistributedLock(RedisFiledConstant.CREATE_BREAK_GAME_LOCK,requestId);
                return redisGameRecord;
            }
        }

        //开启下一场
        DateTime time = new DateTime();
        GameBreakRecords gameRecord = new GameBreakRecords();
        gameRecord.setContestNum(0);
        gameRecord.setGameFiledName(game.getGameModelName());
        gameRecord.setGameModelId(game.getId());
        //游戏场次编号
        gameRecord.setGameNo(GameNoGeneratorUtil.dailyGameNo(game.getGameModelKey()));
        //游戏唯一编号
        gameRecord.setGameModelKey(game.getGameModelKey());
        gameRecord.setPassThroughNum(0);
        gameRecord.setGameStatus(GameConstants.GAME_STATUS_1);
        //关卡数
        gameRecord.setTotalRound(Integer.parseInt(configs.get(GameConstants.LEVEL)));
        gameRecord.setStartTime(time.toDate());
        gameRecord.setEndTime(DateUtil.getEndTime(awardTime));

        long recordId = gameBreakRecordsService.saveOrUpdate(gameRecord);
        gameRecord.setId(recordId);
        //更新redis上的游戏信息
        redisClient.hSet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId), gameRecord);
        //redis分布式锁 解锁
        redisLock.releaseDistributedLock(RedisFiledConstant.CREATE_BREAK_GAME_LOCK,requestId);
        //创建任务
        Map<String, Object> params = new HashMap<>();
        params.put("game", game);
        params.put("gameRecord", gameRecord);
        breakGameJobService.addCloseBreakGameJob(params);
        return gameRecord;
    }
}
