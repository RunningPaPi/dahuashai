/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan-service
 * Author: author  wushyue@gmail.com
 * Create On: Jun 19, 2018 5:34:01 PM
 * Modify On: Jun 19, 2018 5:34:01 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.share.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artqiyi.dahuashai.share.domain.FixShare;
import com.artqiyi.dahuashai.share.domain.FixShareExample;
import com.artqiyi.dahuashai.share.domain.ShareInfo;
import com.artqiyi.dahuashai.share.domain.ShareInfoExample;
import com.artqiyi.dahuashai.share.domain.ShareInfoExample.Criteria;
import com.artqiyi.dahuashai.share.mapper.FixShareMapper;
import com.artqiyi.dahuashai.share.mapper.ShareInfoMapper;

/** 
 *
 */
@Service("shareInfoService")
public class ShareInfoService {
	private static Logger logger = LoggerFactory.getLogger(ShareInfoService.class);
	
	@Autowired
	private ShareInfoMapper shareInfoMapper;
	
	@Autowired
	private FixShareMapper fixShareMapper;
	
	
	
	public List<ShareInfo> getShareInfoList(Integer contentType, Integer shareType){
		ShareInfoExample example = new ShareInfoExample();
		Criteria criteria = example.createCriteria();
		
		if(contentType != null && contentType > 0) {
			criteria.andContentTypeEqualTo(contentType);
		}
		if(shareType != null && shareType > 0) {
			criteria.andShareTypeEqualTo(shareType);
		}
		
		return shareInfoMapper.selectByExample(example);
	}
	
	
	public List<FixShare> getFixShareList(Integer shareType){
		FixShareExample example = new FixShareExample();
		com.artqiyi.dahuashai.share.domain.FixShareExample.Criteria criteria = example.createCriteria();
		
		if(shareType != null && shareType > 0) {
			criteria.andShareTypeEqualTo(shareType);
		}
		criteria.andStatusEqualTo(1); //有效
		return fixShareMapper.selectByExample(example);
	}
	
}
