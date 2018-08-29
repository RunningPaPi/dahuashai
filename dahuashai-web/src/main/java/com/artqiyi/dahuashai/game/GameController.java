package com.artqiyi.dahuashai.game;

import com.artqiyi.dahuashai.aspect.AuthPassport;
import com.artqiyi.dahuashai.common.constant.GameConstants;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.constant.ResponseCodeConstant;
import com.artqiyi.dahuashai.common.socket.SocketConstant;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.game.domain.*;
import com.artqiyi.dahuashai.game.vo.GameBreakIntroductionVo;
import com.artqiyi.dahuashai.game.vo.GameBreakUserRecordsVo;
import com.artqiyi.dahuashai.game.vo.PassAwardRecord;
import com.artqiyi.dahuashai.game.vo.UserRankVo;
import com.artqiyi.dahuashai.redis.RedisClient;
import com.artqiyi.dahuashai.response.UserResponse;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;
import com.artqiyi.dahuashai.wechat.WechatService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private static final Logger log = LoggerFactory.getLogger(GameController.class);
    @Autowired
    private IGameModelService gameModelService;
    @Autowired
    private IGameBreakService gameBreakService;
    @Autowired
    private IGameConfigService breakGameConfigService;
    @Autowired
    private IGameBreakUserQualifyService BreakGameUserQualifyService;
    @Autowired
    private IGameBreakRecoverCostService breakGameRecoverCostService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IGameRankService gameRankService;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private IGameFightService gameFightService;
    @Autowired
    private WechatService wechatService;

    @AuthPassport(checkLogin = true,checkSign = false)
    @GetMapping("/fight/{userId}/room")
    public UserResponse newRoom(@PathVariable("userId") Long userId){
        String roomNo = gameFightService.newRoom(userId);
        UserResponse rsp = new UserResponse();
        Map map = new HashMap();
        map.put("roomNo",roomNo);
        rsp.setResult(map);
        rsp.setCode(ResponseCodeConstant.SUCCESS);
        return rsp;
    }

    @AuthPassport(checkLogin = true,checkSign = false)
    @DeleteMapping("/noticed/{userId}")
    public UserResponse noticed(@PathVariable("userId") Long userId){
        UserResponse rsp = new UserResponse();
        redisClient.hDel(RedisFiledConstant.BREAK_GAME_PASS_RECORD,userId.toString());
        rsp.setCode(ResponseCodeConstant.SUCCESS);
        return rsp;
    }

    /**
     * 游戏规则
     *
     * @param gameKey
     * @return
     */
    @AuthPassport(checkLogin = false,checkSign = true)
    @GetMapping("/rules/{gameKey}")
    @ResponseBody
    public UserResponse getBigBonusRules(@PathVariable("gameKey") String gameKey) {
        UserResponse response = new UserResponse();
        List<GameConfig> breakGameConfigs = null;
        switch (gameKey) {
            case GameConstants.DHS_BREAK_MODEL:
                breakGameConfigs = breakGameConfigService.getByType(gameKey, GameConstants.DHS_BREAK_MODEL_GAME_RULE);
                break;
            default:
                break;
        }


        if (breakGameConfigs == null) {
            response.setMsg("没有查到游戏规则");
            response.setResult(null);
            response.setCode(ResponseCodeConstant.SERVICE_FAIL);
            return response;
        }

        List<String> rules = breakGameConfigs.stream()
                .map(e -> e.getTypeValue()).collect(Collectors.toList());
        response.setResult(rules);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }

    /**
     * 闯关规则
     *
     * @param gameKey
     * @return
     */
    @AuthPassport(checkLogin = false,checkSign = true)
    @GetMapping("/rules/break/{gameKey}")
    @ResponseBody
    public UserResponse getBreakRules(@PathVariable("gameKey") String gameKey) {
        UserResponse response = new UserResponse();
        List<GameConfig> breakGameConfigs = breakGameConfigService.getByType(gameKey, GameConstants.BREAK_RULE);
        if (breakGameConfigs == null) {
            response.setMsg("没有查到闯关规则");
            response.setResult(null);
            response.setCode(ResponseCodeConstant.SERVICE_FAIL);
            return response;
        }
        List<String> rules = breakGameConfigs.stream()
                .map(e -> e.getTypeValue()).collect(Collectors.toList());
        response.setResult(rules);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }

    /**
     * 游戏统计
     *
     * @param gameKey
     * @return
     */

    @CrossOrigin(allowCredentials = "true")
    @GetMapping("/statistics/{gameKey}")
    @ResponseBody
    public UserResponse getTotalPlayers(@PathVariable("gameKey") String gameKey) {
        UserResponse response = new UserResponse();
        GameModel breakGame = gameModelService.getByGameModelKey(gameKey);
        if (breakGame == null) {
            log.error("【游戏统计】 break_game未配置game_key={}的相关参数", gameKey);
            response.setMsg("数据出错,没有gameKey=" + gameKey + "相关数据");
            response.setResult(null);
            response.setCode(ResponseCodeConstant.SERVICE_FAIL);
            return response;
        }
        //获取当前赛场信息
        GameBreakRecords gameBreakRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(breakGame.getId()), GameBreakRecords.class);
        if (gameBreakRecords == null) {
            log.error("【游戏统计】 从Redis上获取当前场次游戏信息为空key:{},hKey:{}", RedisFiledConstant.BREAK_GAME_RECORD, breakGame.getId());
            response.setMsg("数据出错");
            response.setResult(null);
            response.setCode(ResponseCodeConstant.SERVICE_FAIL);
            return response;
        }
        ;
        Map<String, Integer> map = new HashMap();
        map.put("contestNum", gameBreakRecords.getContestNum());
        map.put("passThroughNum", gameBreakRecords.getPassThroughNum());
        response.setResult(map);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }

    /**
     * 每关消耗
     *
     * @param gameKey
     * @return
     */
    @AuthPassport(checkLogin = false,checkSign = true)
    @GetMapping("/levelCost/{gameKey}")
    @ResponseBody
    public UserResponse levelCost(@PathVariable("gameKey") String gameKey) {
        UserResponse response = new UserResponse();
        List<GameBreakRecoverCost> list = breakGameRecoverCostService.getByGameModelKey(gameKey);
        if (list == null || list.isEmpty()) {
            log.error("【每关消耗】 game_break_recover_cost未配置game_key={}的相关参数", gameKey);
            response.setCode(ResponseCodeConstant.SUCCESS);
            response.setResult(new ArrayList<>());
            return response;
        }
        response.setResult(list);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }

    /**
     * 获取动态参赛/通关人数
     *
     * @param configs
     * @return
     */
    private Integer getContestNum(Map<String, String> configs, int type) {
        Integer contestNum = 0;
        if (configs.get(GameConstants.CONTEST) != null && configs.get(GameConstants.TIME) != null && configs.get(GameConstants.CHEAT) != null) {
            Date endTime = DateUtil.getEndTime(configs.get(GameConstants.TIME));
            long period = endTime.getTime() - System.currentTimeMillis();
            int totalNum = 0;
            if (type == 0) {
                totalNum = Integer.valueOf(configs.get(GameConstants.CONTEST));
            } else if (type == 1) {
                totalNum = Integer.valueOf(configs.get(GameConstants.CHEAT));
            }
            int times = 60 * 24;//24小时分钟数
            int minutes = (int) period / 1000 / 60;//距离结束总分钟数
            if (minutes <= GameConstants.THRESHOLD) {
                contestNum = totalNum;
            } else {
                contestNum = totalNum - (int) (minutes / (times * 1.0) * totalNum);
            }
        }
        return contestNum;
    }

    /**
     * 游戏介绍
     *
     * @param userId
     * @param gameKey
     * @return
     */
    @AuthPassport(checkLogin = false,checkSign = true)
    @GetMapping("/introduction/{userId}/{gameKey}")
    @ResponseBody
    public UserResponse getIntroduction(@PathVariable("userId") Long userId,
                                        @PathVariable("gameKey") String gameKey) {
        UserResponse response = new UserResponse();
        //获取游戏信息
        GameModel game = gameModelService.getByGameModelKey(gameKey);
        if (game == null) {
            response.setMsg("gameKey错误");
            response.setCode(ResponseCodeConstant.PARAM_ID_FAIL);
            return response;
        }
        Long gameId = game.getId();
        //获取当前场次游戏信息
        GameBreakRecords gameBreakRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(gameId), GameBreakRecords.class);//获取当前赛场信息

        GameBreakIntroductionVo introductionVo = new GameBreakIntroductionVo();
        //获取游戏参数信息
        Map<String, String> configs = breakGameConfigService.getByGameModelKey(game.getGameModelKey());

        if (configs == null) {
            log.error("【游戏介绍】 游戏配置表break_game_config未未配置game_key={}的相关参数", gameKey);
            response.setMsg("数据出错");
            response.setCode(ResponseCodeConstant.FAIL);
            return response;
        }
        if (gameBreakRecords == null) {
            //如果游戏的状态为0,表示游戏暂不开放
            if (GameConstants.GAME_STATUS_INVALID.equals(game.getStatus())) {
                response.setMsg("游戏暂不开放");
                response.setCode(ResponseCodeConstant.SERVICE_FAIL);
                return response;
            }
            //否则创建游戏场次相关信息
            gameBreakRecords = gameBreakService.createNewGame(game.getId());
        }
        GameBreakUserQualify userPrize = BreakGameUserQualifyService.getLatestUserPrize(userId, gameId, gameBreakRecords.getGameNo());

        introductionVo.setUserId(userId);
        //通关人数
        Integer cheat = 0;
        if (configs.get(GameConstants.CHEAT) != null) {
            cheat = Integer.valueOf(getContestNum(configs,1));
        }
        introductionVo.setPassThroughNum(gameBreakRecords.getPassThroughNum() + cheat);
        //参赛人数
        Integer contestNum = 0;
        if (configs.get(GameConstants.CONTEST) != null) {
            contestNum = Integer.valueOf(getContestNum(configs,0));
        }
        introductionVo.setContestNum(gameBreakRecords.getContestNum() + contestNum);
        //分享次数限制
        List<GameConfig> gameConfigs = breakGameConfigService.getByType(GameConstants.DHS_BREAK_MODEL, GameConstants.RECOVER_WAY);
        if(gameConfigs != null && gameConfigs.get(0) != null && gameConfigs.get(0).getTypeValue() != null){
            introductionVo.setMaxShareTimes(Integer.valueOf(gameConfigs.get(0).getTypeValue()));
            introductionVo.setShareType(gameConfigs.get(0).getCode());
        }else {
            introductionVo.setMaxShareTimes(-1);
        }
        //结算时间
        introductionVo.setAwardTime(configs.get(GameConstants.TIME));
        //奖池
        introductionVo.setMoney(NumberUtils.createInteger(configs.get(GameConstants.MONEY)));
        //奖池图片
        introductionVo.setPosterUrl(configs.get(GameConstants.POSTER_URL));
        //游戏总关次
        introductionVo.setTotalLevels(NumberUtils.createInteger(configs.get(GameConstants.LEVEL)));
        //赛场编号
        introductionVo.setGameNo(gameBreakRecords.getGameNo());
        //游戏gameKey
        introductionVo.setGameKey(game.getGameModelKey());
        //游戏名称
        introductionVo.setGameName(game.getGameModelName());
        //游戏id
        introductionVo.setGameId(gameId);
        //通关次数
        introductionVo.setPassTimes(0);
        //游戏规则
        introductionVo.setGameRules(breakGameConfigService.getGameRules(gameKey));
        //闯关规则
        introductionVo.setBreakRules(breakGameConfigService.getBreakRules(gameKey));
        introductionVo.setShareTimes(0);
        if (userPrize != null) {
            introductionVo.setPassTimes(userPrize.getPassTimes());
        }
        introductionVo.setSystemTime(new Date());

        //先到游戏数据区获取数据
        GameBreakUserRecordsVo userRecordsVo = redisClient.hGet(gameBreakRecords.getGameNo(), String.valueOf(userId),GameBreakUserRecordsVo.class);
        //如果数据热区存在该条记录，则该玩家是逃跑玩家，先结算该场游戏
        if (userRecordsVo != null) {
            //如果抛异常，都是数据有问题
            try {
                GameBreakUserRecordsVo against = redisClient.hGet(gameBreakRecords.getGameNo(), String.valueOf(userRecordsVo.getAgainstId()),GameBreakUserRecordsVo.class);
                gameBreakService.win(against, userRecordsVo, SocketConstant.SOCKET_OPERATE_SEND_BREAK_GAME_GIVE_UP);
            } catch (Exception e) {
                response.setMsg("数据异常");
                response.setCode(ResponseCodeConstant.FAIL);
                return response;
            }
        }
        introductionVo.setLevelCost(0);
        //获取关卡相关数据
        userRecordsVo = redisClient.hGet(RedisFiledConstant.BREAK_GAME_WAIT_PLAYER + "_" + gameBreakRecords.getGameNo(), String.valueOf(userId),GameBreakUserRecordsVo.class);
        //为空，表示没玩过
        if (userRecordsVo == null) {
            introductionVo.setCurrentLevel(1);
            introductionVo.setIsLive(false);
        } else {
            //获取闯关游戏每关的消耗配置参数
            GameBreakRecoverCost roundCost = breakGameRecoverCostService.getRoundCost(gameId, userRecordsVo.getPassMaxLevel() + 1);
            if (roundCost == null) {
                log.error("【游戏介绍】 未配置break_game_recover_cost的game_key={}对应的game_round={} 的参数", gameKey, introductionVo.getCurrentLevel());
                response.setCode(ResponseCodeConstant.SERVICE_FAIL);
                response.setMsg("数据异常");
                return response;
            }
            //复活消耗
            introductionVo.setLevelCost(roundCost.getCostNum());
            //消耗账户类型
            introductionVo.setCostType(roundCost.getCostType());
            introductionVo.setCurrentLevel(userRecordsVo.getPassMaxLevel() + 1);
            introductionVo.setIsLive(userRecordsVo.isIslive());
            introductionVo.setShareTimes(userRecordsVo.getShareTimes());
        }
        introductionVo.setPassAwardRecord(redisClient.hGet(RedisFiledConstant.BREAK_GAME_PASS_RECORD, userId.toString(),PassAwardRecord.class));
        response.setResult(introductionVo);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }

    /**
     * 我的排名
     *
     * @param userId
     * @param gameKey
     * @return
     */
    @AuthPassport(checkLogin = false, checkSign = true)
    @GetMapping("/myRank/{wayOfRank}/{userId}/{gameKey}")
    @ResponseBody
    public UserResponse getMyRank(@PathVariable("wayOfRank") String wayOfRank,
                                  @PathVariable("userId") Long userId,
                                  @PathVariable("gameKey") String gameKey) {

        UserResponse response = new UserResponse();
        //获取游戏信息
        GameModel game = gameModelService.getByGameModelKey(gameKey);
        if (game == null) {
            log.error("【我的排名】 break_game未配置game_key={}的相关参数", gameKey);
            response.setCode(ResponseCodeConstant.FAIL);
            response.setMsg("数据出错");
            return response;
        }
        Long gameId = game.getId();
        //获取获奖资格信息
        UserRankVo userRank = gameRankService.getRankByUserId(userId, gameId, wayOfRank);
        if (userRank == null) {
            userRank = new UserRankVo();
            User user = userService.selectById(userId);
            UserInfo userInfo = userInfoService.selectByUserId(userId);
            userRank.setHeadPicUrl(userInfo.getHeadPicUrl());
            userRank.setMoney(0);
            userRank.setRank(0);
            userRank.setPassTimes(0);
            userRank.setUserName(user.getNickName());
            userRank.setUserId(userId);
        }
        response.setResult(userRank);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }

    /**
     * 排名
     *
     * @param gameKey
     * @return
     */
    @AuthPassport(checkLogin = false, checkSign = true)
    @GetMapping("/rank/{wayOfRank}/{gameKey}")
    @ResponseBody
    public UserResponse getRank(@PathVariable("wayOfRank") String wayOfRank,
                                @PathVariable("gameKey") String gameKey,
                                @RequestParam("page") Integer page,
                                @RequestParam("pageSize") Integer pageSize) {
        UserResponse response = new UserResponse();
        //获取游戏信息
        GameModel game = gameModelService.getByGameModelKey(gameKey);
        if (game == null) {
            log.error("【玩家排名】 break_game未配置game_key={}的相关参数", gameKey);
            response.setCode(ResponseCodeConstant.FAIL);
            response.setMsg("数据出错");
            return response;
        }
        Long gameId = game.getId();
        //
        PageInfo<UserRankVo> userRanks = gameRankService.getRank(page, pageSize, gameId, wayOfRank);
        response.setResult(userRanks);
        response.setCode(ResponseCodeConstant.SUCCESS);
        return response;
    }
}
