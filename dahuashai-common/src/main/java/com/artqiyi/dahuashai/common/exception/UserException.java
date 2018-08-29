/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-common
 * Author: author  wushyue@gmail.com
 * Create On: May 21, 2018 4:26:42 PM
 * Modify On: May 21, 2018 4:26:42 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.common.exception;

/** 
 * 类或接口作用描述 
 *
 * @author wushuang
 * @since 2018-05-21
 */
public class UserException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException(String msg) {
        super(msg);
    }

    public UserException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
