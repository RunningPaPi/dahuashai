package com.artqiyi.dahuashai.user.service.impl;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/04
 * Modify On: 2018/07/04 11:35 by wufuchang
 */

import com.artqiyi.dahuashai.game.domain.GameBreakAgainstRecordsExample.Criteria;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserInvite;
import com.artqiyi.dahuashai.user.domain.UserInviteExample;
import com.artqiyi.dahuashai.user.mapper.UserInviteMapper;
import com.artqiyi.dahuashai.user.service.IUserInviteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class UserInviteServiceImpl implements IUserInviteService {
    @Autowired
    private UserInviteMapper userInviteMapper;

    @Override
    public List<Long> getFriendIdList(Long userId) {
        UserInviteExample userInviteExample = new UserInviteExample();
        userInviteExample.or().andInvitorUserIdEqualTo(userId);
        List<UserInvite> userInvites = userInviteMapper.selectByExample(userInviteExample);
        return userInvites.stream().map(UserInvite::getUserId).collect(Collectors.toList());
    }
    
    
    /**
     * 添加邀请记录
     * @param userId
     * @param invitorUserId
     * @param isNew
     */
    public void addUserInvite(Long userId, Long invitorUserId, Boolean isNew) {
    	Date now = new Date();
    	UserInvite userInvite = new UserInvite();
    	userInvite.setUserId(userId);
    	userInvite.setInvitorUserId(invitorUserId);
    	userInvite.setIsNew(isNew);
    	userInvite.setCreateTime(now);
    	userInvite.setUpdateTime(now);
    	userInviteMapper.insert(userInvite);
    }
    
    
    /**
     * 查找邀请记录
     * @param userId
     * @param isNew
     * @param invitorUserId
     * @param startDate
     * @param endDate
     * @return
     */
    public UserInvite findUserInvite(Long userId, Long invitorUserId, Boolean isNew, Date startDate, Date endDate) {
    	  UserInviteExample userInviteExample = new UserInviteExample();
    	  com.artqiyi.dahuashai.user.domain.UserInviteExample.Criteria criteria = userInviteExample.createCriteria();
    	  criteria.andUserIdEqualTo(userId);
    	  criteria.andInvitorUserIdEqualTo(invitorUserId);
    	  
    	  if(isNew != null) {
    		  criteria.andIsNewEqualTo(isNew);
    	  }
    	  
    	  
    	  if(startDate != null) {
    		  criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
    	  }
    	  
    	  if(endDate != null) {
    		  criteria.andCreateTimeLessThanOrEqualTo(endDate);
    	  }
    	  
    	  List<UserInvite> userInviteList = userInviteMapper.selectByExample(userInviteExample);
    	  if(userInviteList != null && userInviteList.size() > 0) {
    		  return userInviteList.get(0);
    	  }
    	  
    	  return null;
    	  
    }
    
}
