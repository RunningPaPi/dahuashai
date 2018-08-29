/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-common
 * Author: author  wushyue@gmail.com
 * Create On: May 14, 2018 2:51:55 PM
 * Modify On: May 14, 2018 2:51:55 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.common.constant;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

/** 
 * 系统级配置 
 * 
 * 使用例子：
 * SystemConfig config = ConfigCache.getOrCreate(SystemConfig.class);
 * config.getAppId();
 * @author wushuang
 * @since 2018-05-14
 */
@Sources("classpath:system.properties")
public interface SystemConfig extends Config {
    @Key("pay.notify.url")
    String getNotifyUrl();
    
    @Key("pay.app.id")
    String getAppId();

    @Key("wxapplet.appId")
    String getWxappletAppId();
    
    @Key("pay.app.key")
    String getAppKey();
    
    @Key("pay.app.secret")
    String getAppSecret();

    @Key("pay.partner")
    String getPartner();

    @Key("pay.app.partner")
    String getAppPartner();

    @Key("pay.partner.key")
    String getPartnerKey();

    @Key("pay.app.partner.key")
    String getAppPartnerKey();

    @Key("pay.token.url")
    String getTokenUrl();
    
    @Key("pay.gate.url")
    String getGateUrl();
    
    @Key("pay.packageValue")
    String getPackageValue();

    @Key("app.sign.key")
    String getAppSignKey();

    @Key("app.platform")
    String getAppPlatform();

    @Key("cert.file.path")
    String getCertFilePath();
}
