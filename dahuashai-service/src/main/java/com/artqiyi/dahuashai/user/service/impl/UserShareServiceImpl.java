package com.artqiyi.dahuashai.user.service.impl;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/06
 * Modify On: 2018/07/06 16:37 by wufuchang
 */

import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.user.domain.UserShare;
import com.artqiyi.dahuashai.user.mapper.UserShareMapper;
import com.artqiyi.dahuashai.user.service.IUserShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserShareServiceImpl implements IUserShareService {
    @Autowired
    private UserShareMapper userShareMapper;

    /**
     * app 分享值微信后 回调我们接口 插入分享记录
     */
    @Override
    public void addUserShare(Long userId,String shareTitle,String shareDesc,String shareLink,String shareImgUrl,String shareType,String dataUrl,Short contentType,Short contentSubType) {
        UserShare userShare = new UserShare();
        userShare.setUserId(userId);
        userShare.setShareTitle(shareTitle);
        userShare.setShareDesc(shareDesc);
        userShare.setShareLink(shareLink);
        userShare.setShareImgUrl(shareImgUrl);
        if (shareType==null||shareType=="") {
            shareType = SystemConstant.USER_SHARE_TYPE_DEFAULT;
            dataUrl = "";
        }
        userShare.setShareType(shareType);
        userShare.setDataUrl(dataUrl);
        userShare.setContentType(contentType);
        userShare.setContentSubType(contentSubType);
        userShareMapper.insert(userShare);
    }
}
