package com.artqiyi.dahuashai.game.impl;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/03
 * Modify On: 2018/07/03 17:06 by wufuchang
 */

import com.artqiyi.dahuashai.common.constant.GameConstants;
import com.artqiyi.dahuashai.common.util.StringUtils;
import com.artqiyi.dahuashai.game.IGameConfigService;
import com.artqiyi.dahuashai.game.domain.GameConfig;
import com.artqiyi.dahuashai.game.domain.GameConfigExample;
import com.artqiyi.dahuashai.game.mapper.GameConfigMapper;
import com.artqiyi.dahuashai.game.vo.GameModelPageInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 大话骰游戏业务实现类
 */
@Service
public class GameConfigServiceImpl implements IGameConfigService {
    @Autowired
    private GameConfigMapper configMapper;

    @Override
    public GameModelPageInfoVo getGameModelPageInfo(String gameModelKey) {
        List<GameConfig> gameConfigs = getConfigsByModelKeyAndCode(gameModelKey,null);
        if (gameConfigs==null||gameConfigs.size()==0) {
            throw new RuntimeException("后台没有配置该模式的配置信息");
        }
        GameModelPageInfoVo pageInfoVo = new GameModelPageInfoVo();
        pageInfoVo.setGameConfigs(gameConfigs);
        return pageInfoVo;
    }


    public List<GameConfig> getConfigsByModelKeyAndCode(String gameModelKey,String configCode) {
        GameConfigExample gameConfigExample = new GameConfigExample();
        GameConfigExample.Criteria criteria = gameConfigExample.createCriteria();
        if (!StringUtils.isEmpty(gameModelKey)) {
            criteria.andGameModelKeyEqualTo(gameModelKey);
        }
        if (!StringUtils.isEmpty(configCode)) {
            criteria.andCodeEqualTo(configCode);
        }
        return configMapper.selectByExample(gameConfigExample);
    }

    @Override
    public Map<String, String> getByGameModelKey(String gameModelKey) {
        GameConfigExample breakGameConfigExample = new GameConfigExample();
        breakGameConfigExample.or().andGameModelKeyEqualTo(gameModelKey)
                .andStatusEqualTo(GameConstants.GAME_STATUS_1);
        List<GameConfig> breakGameConfigs = configMapper.selectByExample(breakGameConfigExample);
        if (breakGameConfigs == null || breakGameConfigs.isEmpty()) {
            return null;
        }

        Map<String, String> gameConfigMap = new HashMap<>();

        for (GameConfig breakGameConfig : breakGameConfigs) {
            gameConfigMap.put(breakGameConfig.getCode(), breakGameConfig.getTypeValue());
        }
        return gameConfigMap;
    }

    /**
     * 获取gameModelKey类型typeKey的参数
     * @param gameModelKey
     * @param typeKey
     * @return
     */
    @Override
    public List<GameConfig> getByType(String gameModelKey, String typeKey) {
        GameConfigExample example = new GameConfigExample();
        example.or().andGameModelKeyEqualTo(gameModelKey).andTypeKeyEqualTo(typeKey)
                .andStatusEqualTo(GameConstants.GAME_STATUS_1);
        List<GameConfig> breakGameConfigs = configMapper.selectByExample(example);
        if (breakGameConfigs == null || breakGameConfigs.isEmpty()) {
            return null;
        }
        return breakGameConfigs;
    }

    /**
     * 获取游戏规则
     * @param gameKey
     * @return
     */
    @Override
    public List<String> getGameRules(String gameKey) {
        List<GameConfig> breakGameConfigs = null;
        switch (gameKey) {
            case GameConstants.DHS_BREAK_MODEL:
                breakGameConfigs = getByType(gameKey, GameConstants.DHS_BREAK_MODEL_GAME_RULE);
                break;
            default:
                break;
        }
        if (breakGameConfigs == null || breakGameConfigs.isEmpty()) {
            return null;
        }
        List<String> rules = breakGameConfigs.stream()
                .map(e -> e.getTypeValue()).collect(Collectors.toList());
        return rules;
    }

    /**
     * 获取闯关规则
     * @param gameKey
     * @return
     */
    @Override
    public List<String> getBreakRules(String gameKey) {
        List<GameConfig> breakGameConfigs = getByType(gameKey, GameConstants.BREAK_RULE);
        if (breakGameConfigs == null || breakGameConfigs.isEmpty()) {
            return null;
        }
        List<String> rules = breakGameConfigs.stream()
                .map(e -> e.getTypeValue()).collect(Collectors.toList());
        return rules;
    }
}
