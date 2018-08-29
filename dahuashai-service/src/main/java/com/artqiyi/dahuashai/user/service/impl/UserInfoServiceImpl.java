package com.artqiyi.dahuashai.user.service.impl;

import com.artqiyi.dahuashai.common.constant.MsgConstant;
import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.exception.UserException;
import com.artqiyi.dahuashai.user.domain.*;
import com.artqiyi.dahuashai.user.mapper.UserInfoMapper;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/25
 * Modify On: 2018/4/25 by chencunjun
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    private static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private IUserService userService;


    @Override
    public PageInfo<UserInfo> page(int page, int pageSize, UserInfoExample example) {
        PageHelper.startPage(page, pageSize);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public long saveOrUpdate(UserInfo userInfo) {
        if(null==userInfo.getId() || userInfo.getId()==0){
            userInfoMapper.insertSelective(userInfo);
        }else{
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        return userInfo.getId();
    }

    @Override
    public int deleteById(long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(UserInfoExample userInfoExample) {
        return userInfoMapper.deleteByExample(userInfoExample);
    }

    @Override
    public int updateByExample(UserInfo userInfo, UserInfoExample userInfoExample) {
        return userInfoMapper.updateByExample(userInfo,userInfoExample);
    }

    @Override
    public List<UserInfo> selectByExample(UserInfoExample userInfoExample) {
        return userInfoMapper.selectByExample(userInfoExample);
    }

    @Override
    public UserInfo selectById(long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(UserInfoExample userInfoExample) {
        return userInfoMapper.countByExample(userInfoExample);
    }

    @Override
    public UserInfo selectByUserId(long userId) {
        UserInfoExample userInfoExample=new UserInfoExample();
        userInfoExample.or().andUserIdEqualTo(userId);
        List<UserInfo> userInfos=userInfoMapper.selectByExample(userInfoExample);
        if(null!=userInfos && userInfos.size()>0){
            return userInfos.get(0);
        }
        return null;
    }

    @Override
    public boolean isInviteCodeExist(String inviteCode) {
        UserInfoExample userInfoExample=new UserInfoExample();
        userInfoExample.or().andInvaiteCodeEqualTo(inviteCode);
        long count = userInfoMapper.countByExample(userInfoExample);
        if (count>0){
            return true;
        }
        return false;
    }

    /**
     * 绑定支付宝
     * @param userId
     * @param alipayAccount
     * @param alipayRealname
     */
    @Override
    public void bindAlipayAccount(Long userId, String alipayAccount, String alipayRealname) {
        UserInfo userInfo = selectByUserId(userId);
        if (userInfo == null) {
            throw new UserException(MsgConstant.BIND_ALIPAY_FAIL_USER_NOT_EXIST);
        }
        //不允许重复绑定
        if (userInfo.getAlipayAccountValidated()!=null&&userInfo.getAlipayAccountValidated()) {
            throw new UserException(MsgConstant.BIND_ALIPAY_FAIL_REPEAT_BIND);
        }
        userInfo.setAlipayAccount(alipayAccount);
        userInfo.setAlipayRealname(alipayRealname);
        userInfo.setAlipayAccountValidated(true);
        userInfoMapper.updateByPrimaryKey(userInfo);
    }



    @Override
    public boolean isUserRandomNoExist(Integer userRandomNo) {
        UserInfoExample userInfoExample=new UserInfoExample();
        userInfoExample.or().andUserRandomNoEqualTo(userRandomNo);
        long count = userInfoMapper.countByExample(userInfoExample);
        if (count>0){
            return true;
        }
        return false;
    }
}
