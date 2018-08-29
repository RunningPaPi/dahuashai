package com.artqiyi.dahuashai.user.service;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/06
 * Modify On: 2018/07/06 16:37 by wufuchang
 */

/**
 *
 */
public interface IUserShareService {
    void addUserShare(Long userId, String shareTitle, String shareDesc, String shareLink, String shareImgUrl, String shareType, String dataUrl, Short contentType, Short contentSubType);
}
