package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameUserWinPercentService;
import com.artqiyi.dahuashai.game.domain.GameUserWinPercent;
import com.artqiyi.dahuashai.game.domain.GameUserWinPercentExample;
import com.artqiyi.dahuashai.game.mapper.GameUserWinPercentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameUserWinPercentServiceImpl implements IGameUserWinPercentService {

    @Autowired
    private GameUserWinPercentMapper mapper;

    @Override
    public String getPlayerTypeByUserId(Long userId) {
        GameUserWinPercentExample example = new GameUserWinPercentExample();
        example.or().andUserIdEqualTo(userId);
        List<GameUserWinPercent> list = mapper.selectByExample(example);
        if (list==null ||list.isEmpty()){
            return null;
        }

        return list.get(0).getWinPercentCode();
    }
}
