package com.artqiyi.dahuashai.wechat.controller;

import com.artqiyi.dahuashai.aspect.AuthPassport;
import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.constant.ResponseCodeConstant;
import com.artqiyi.dahuashai.redis.RedisClient;
import com.artqiyi.dahuashai.response.UserResponse;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wechat")
public class WechatController {
    private static Logger log = LoggerFactory.getLogger(WechatController.class);
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private IUserService userService;

    @AuthPassport(checkSign = false,checkLogin = true)
    @PostMapping("/formId/save")
    public UserResponse saveFormIdb(@RequestParam("userId") Long userId,
                                   @RequestParam("formId") String formId){
        UserResponse rsp = new UserResponse();
        if (userId == null){
            rsp.setCode(ResponseCodeConstant.SERVICE_FAIL);
            rsp.setMsg("id为空");
            return rsp;
        }
        if (formId == null){
            rsp.setCode(ResponseCodeConstant.SERVICE_FAIL);
            rsp.setMsg("formId为空");
            return rsp;
        }
        User user = userService.selectById(userId);
        if (user == null){
            rsp.setCode(ResponseCodeConstant.SERVICE_FAIL);
            rsp.setMsg("用户不存在");
            return rsp;
        }
        redisClient.hSet(RedisFiledConstant.USER_FORM_ID, userId.toString(), formId);
        rsp.setCode(ResponseCodeConstant.SUCCESS);
        return rsp;
    }
}
