package com.artqiyi.dahuashai.game.impl;

import com.artqiyi.dahuashai.game.IGameModelService;
import com.artqiyi.dahuashai.game.domain.GameModel;
import com.artqiyi.dahuashai.game.domain.GameModelExample;
import com.artqiyi.dahuashai.game.mapper.GameModelMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameModelServiceImpl implements IGameModelService {
    @Autowired
    private GameModelMapper mapper;

    @Override
    public PageInfo<GameModel> page(int page, int pageSize, GameModelExample example) {
        PageHelper.startPage(page, pageSize);
        List<GameModel> GameModel = mapper.selectByExample(example);
        return new PageInfo<>(GameModel);
    }

    @Override
    public long saveOrUpdate(GameModel gameModel) {
        if (null == gameModel.getId() || gameModel.getId()==0) {
            mapper.insertSelective(gameModel);
        } else {
            mapper.updateByPrimaryKeySelective(gameModel);
        }
        return gameModel.getId();
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(GameModelExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int updateByExample(GameModel records, GameModelExample example) {
        return mapper.updateByExample(records, example);
    }

    @Override
    public List<GameModel> selectByExample(GameModelExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public GameModel selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(GameModelExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public GameModel getByGameModelKey(String gameKey) {
        GameModelExample breakGameExample = new GameModelExample();
        breakGameExample.or().andGameModelKeyEqualTo(gameKey);
        List<GameModel> games = mapper.selectByExample(breakGameExample);
        if (games != null && !games.isEmpty()) {
            return games.get(0);
        }
        return null;
    }
}
