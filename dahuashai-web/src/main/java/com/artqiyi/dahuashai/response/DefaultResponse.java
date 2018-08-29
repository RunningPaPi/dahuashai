/**
* COPYRIGHT. Foresee Inc. ALL RIGHTS RESERVED.
* Project: dc-api-gateway-core
* Author: wushyue@gmail.com
*/

package com.artqiyi.dahuashai.response;

/**
 * 类或者接口作用描述
 * 
 * @author wushuang
 *
 */
public class DefaultResponse extends ApiResponse {
    private static final long serialVersionUID = -9095836698638464824L;
    

    public DefaultResponse() {
        super();
    }
    /**
     * @param code
     * @param msg
     */
    public DefaultResponse(String code, String msg) {
        super(code, msg);
    }



}
