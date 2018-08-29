package com.artqiyi.dahuashai.initializer;

import com.artqiyi.dahuashai.common.constant.GameConstants;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.game.IGameBreakService;
import com.artqiyi.dahuashai.game.IGameConfigService;
import com.artqiyi.dahuashai.game.IGameJobService;
import com.artqiyi.dahuashai.game.IGameModelService;
import com.artqiyi.dahuashai.game.domain.GameBreakRecords;
import com.artqiyi.dahuashai.game.domain.GameModel;
import com.artqiyi.dahuashai.redis.RedisClient;
import org.apache.commons.collections.map.HashedMap;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GameBreakTaskInitiator implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger(GameBreakTaskInitiator.class);

    @Autowired
    private IGameJobService gameJobService;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private IGameModelService gameModelService;
    @Autowired
    private IGameBreakService gameBreakService;
    @Autowired
    private IGameConfigService gameConfigService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                gameJobService.saveFightGameData();
            } catch (Exception e) {
                log.error("【定时任务】 启动设置失败{}{}", e.getMessage(), e);
            }


            try {

                GameModel game = gameModelService.getByGameModelKey(GameConstants.DHS_BREAK_MODEL);
                if (game == null) {
                    log.error("【大话骰游戏列表】 表game_break未添加闯关游戏");
                    return;
                }
                //获取当前赛场信息
                GameBreakRecords gameBreakRecords = redisClient.hGet(RedisFiledConstant.BREAK_GAME_RECORD, String.valueOf(game.getId()),GameBreakRecords.class);

                Map<String, String> gameConfigs = gameConfigService.getByGameModelKey(game.getGameModelKey());
                //Redis为空代表游戏还没有人玩过
                if (gameBreakRecords == null) {
                    //如果游戏的状态为0,表示游戏暂不开放
                    if (GameConstants.GAME_STATUS_INVALID.equals(game.getStatus())) {
                        return;
                    } else {
                        if (gameConfigs == null) {
                            log.error("【大话骰游戏列表】 break_game_config未配置game_key={}的相关参数", game.getGameModelKey());
                            return;
                        }
                        //否则创建游戏场次相关信息
                        log.info("【大话骰游戏】 创建一个新游戏:{}", game.getGameModelName());
                        gameBreakService.createNewGame(game.getId());
                    }
                } else {
                    //如果Redis上数据不为空,获取游戏的相关信息
                    DateTime dateTime = new DateTime();
                    if (gameBreakRecords != null && gameBreakRecords.getEndTime() != null) {
                        //当前时间是否在期内
                        boolean isTimeout = dateTime.plusMinutes(GameConstants.THRESHOLD)
                                .toDate().after(gameBreakRecords.getEndTime());
                        if (isTimeout) {
                            //如果过了结算时间结算上一场次游戏
                            gameBreakService.closeGame(gameBreakRecords.getGameModelId());
                            return;
                        }
                        //否则继续旧任务
                        Map<String, Object> params = new HashedMap();
                        params.put("game", game);
                        params.put("gameRecord", gameBreakRecords);
                        gameJobService.addCloseBreakGameJob(params);

                    } else {
                        log.error("【大话骰游戏】 {}创建游戏时未设置EndTime", game.getGameModelName());
                    }
                }
            } catch (Exception e) {
                log.error("【定时任务】 闯关游戏结算定时任务启动出错。Exception:{}", e.toString());
            }
        }
    }

}
