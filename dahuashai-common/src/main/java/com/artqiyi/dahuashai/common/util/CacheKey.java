package com.artqiyi.dahuashai.common.util;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.TreeSet;

/**
 * 封装redis key * 
 * @author tangxlf
 * 
 */
public class CacheKey {  
	private String businessMark;//业务标志
	private TreeSet<String> keySet = new TreeSet<String>();//主键Map
	
	//构造器
	public CacheKey(String mark){	
		this.businessMark = mark;
	}
	
	//设置主键
	public void addKey(String key){
	    if(StringUtils.isEmpty(key)) {
	        return;
	    }
		keySet.add(key);
	}

	//设置主键
	public void addKeySet(TreeSet<String>  set){
		keySet.addAll(set);
	}
	
	//生成CacheKey
	public String genKey(){		
		Assert.notNull(businessMark,"businessMark 不能为空");
		StringBuilder sb = new StringBuilder(businessMark);		
		for(String key:keySet){
		    if(StringUtils.isEmpty(key)) {
		        continue;
		    }
			sb.append(":"+key);
		}
		return sb.toString();
	}
}
