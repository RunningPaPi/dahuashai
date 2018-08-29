package com.artqiyi.dahuashai.share.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artqiyi.dahuashai.common.constant.ResponseCodeConstant;
import com.artqiyi.dahuashai.response.ApiResponse;
import com.artqiyi.dahuashai.response.DefaultResponse;
import com.artqiyi.dahuashai.share.domain.FixShare;
import com.artqiyi.dahuashai.share.domain.ShareInfo;
import com.artqiyi.dahuashai.share.service.ShareInfoService;

@RestController
@RequestMapping("/api/shareInfo")
public class ShareInfoController {
    private static Logger logger = LoggerFactory.getLogger(ShareInfoController.class);

    @Autowired
    ShareInfoService shareInfoService;

    @GetMapping("/getShareInfo")
    public ApiResponse getShareInfo(@RequestParam("shareType") Integer shareType){
    	ApiResponse apiResponse = new DefaultResponse();
        apiResponse.setCode(ResponseCodeConstant.SUCCESS);
        apiResponse.setMsg("success");
        
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("shareText", "");
        data.put("shareImg", "");
        
        try{
    		//先查固定分享
    		List<FixShare> fixShareList = shareInfoService.getFixShareList(shareType);
            int fixShareNum = fixShareList.size();
            if(fixShareNum != 0) {
            	if(fixShareNum > 1) {
            		Collections.shuffle(fixShareList);
            	}
            	FixShare fixShare = fixShareList.get(0);
            	data.put("shareText", fixShare.getShareText());
            	data.put("shareImg", fixShare.getShareImg());
            	
            	apiResponse.setResult(data);
                return apiResponse;
            }
            
            //没有固定分享,看随机分享
            List<ShareInfo> shareTextList = shareInfoService.getShareInfoList(1, shareType);
            List<ShareInfo> shareImgList = shareInfoService.getShareInfoList(2, shareType);
            
            if(shareTextList != null && shareTextList.size() > 0) {
            	if(shareTextList.size() > 1) {
            		Collections.shuffle(shareTextList);
            	}
            	data.put("shareText", shareTextList.get(0).getShareContent());
            }
            
            if(shareImgList != null && shareImgList.size() > 0) {
            	if(shareImgList.size() > 1) {
            		Collections.shuffle(shareImgList);
            	}
            	data.put("shareImg", shareImgList.get(0).getShareContent());
            }
            
            apiResponse.setResult(data);
            return apiResponse;

        }catch (Exception e) {
			e.printStackTrace();
			apiResponse.setCode(ResponseCodeConstant.FAIL);
		    apiResponse.setMsg("fail");
		    apiResponse.setResult(data);
            return apiResponse;
		}

    }
        

}
