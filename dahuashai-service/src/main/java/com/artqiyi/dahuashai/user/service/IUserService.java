package com.artqiyi.dahuashai.user.service;

import com.artqiyi.dahuashai.base.service.IBaseService;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserExample;
import com.artqiyi.dahuashai.user.service.vo.UserVo;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/23
 * Modify On: 2018/4/23 by chencunjun
 */
public interface IUserService extends IBaseService<User,UserExample>{
    //是否登录
    boolean hasLogin(String token);
    //根据手机获取用户
    User getByPhone(String phone);

    UserVo getByUnionId(String unionId);
}
