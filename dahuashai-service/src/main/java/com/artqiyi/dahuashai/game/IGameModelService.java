package com.artqiyi.dahuashai.game;

import com.artqiyi.dahuashai.base.service.IBaseService;
import com.artqiyi.dahuashai.game.domain.GameModel;
import com.artqiyi.dahuashai.game.domain.GameModelExample;

public interface IGameModelService extends IBaseService<GameModel,GameModelExample> {
    GameModel getByGameModelKey(String gameKey);
}
