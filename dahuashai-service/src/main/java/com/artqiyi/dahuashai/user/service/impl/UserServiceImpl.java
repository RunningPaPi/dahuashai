package com.artqiyi.dahuashai.user.service.impl;

import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserExample;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.mapper.UserMapper;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;
import com.artqiyi.dahuashai.user.service.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/23
 * Modify On: 2018/4/23 by chencunjun
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public PageInfo<User> page(int page, int pageSize, UserExample example){
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public long saveOrUpdate(User user) {
         if(null==user.getId() || user.getId()==0){
             userMapper.insertSelective(user);
         }else{
             userMapper.updateByPrimaryKeySelective(user);
         }
        return user.getId();
    }

    @Override
    public int deleteById(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(UserExample userExample) {
        return userMapper.deleteByExample(userExample);
    }

    @Override
    public int updateByExample(User user, UserExample userExample) {
        return userMapper.updateByExample(user,userExample);
    }

    @Override
    public List<User> selectByExample(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User selectById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(UserExample userExample) {
        return userMapper.countByExample(userExample);
    }

    @Override
    public boolean hasLogin(String token) {
        UserExample userExample=new UserExample();
        userExample.or().andTokenEqualTo(token);
        List<User> users=userMapper.selectByExample(userExample);
        if(null!=users && users.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public User getByPhone(String phone) {
        UserExample userExample=new UserExample();
        userExample.or().andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public UserVo getByUnionId(String unionId) {
        UserExample userExample=new UserExample();
        userExample.or().andUnionIdEqualTo(unionId);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.isEmpty()){
            return null;
        }
        User user = users.get(0);
        UserInfo userInfo = userInfoService.selectByUserId(user.getId());
        if (userInfo==null){
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        BeanUtils.copyProperties(userInfo,userVo,"id");
        return userVo;
    }
}
