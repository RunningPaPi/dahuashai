package com.artqiyi.dahuashai.common.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.util.Properties;


public class PropertiesUtils {
	private static  Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private static volatile Properties properties;
    private static Object lock=new Object();

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return getProperty(key,null);
    }
    /**
     * 根据key获取value,如果不存在返回默认值
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public static String getProperty(String key,String defaultValue){
        if(!StringUtils.hasText(key)){
            return null;
        }
        if(properties==null){
            synchronized (lock){
                if(properties!=null){
                    return properties.getProperty(key,defaultValue);
                }
                try {
                    //可以指定配置文件，默认读app.properties
                    String fileName=System.getProperty("conf_file","app.properties");
                    properties = PropertiesLoaderUtils.loadAllProperties(fileName);
                } catch (IOException e) {
                	logger.error("读配置文件失败",e);
                }
            }
        }
        return properties.getProperty(key,defaultValue);
    }

}
