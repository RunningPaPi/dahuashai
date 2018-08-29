package com.artqiyi.dahuashai.user.service;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/04
 * Modify On: 2018/07/04 11:34 by wufuchang
 */

import java.util.Date;
import java.util.List;

import com.artqiyi.dahuashai.user.domain.UserInvite;

/**
 *
 */
public interface IUserInviteService {
    List<Long> getFriendIdList(Long userId);
    
    public void addUserInvite(Long userId, Long invitorUserId, Boolean isNew);
    
    public UserInvite findUserInvite(Long userId, Long invitorUserId, Boolean isNew, Date startDate, Date endDate); 
    
}
