/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-web
 * Author: author  wushyue@gmail.com
 * Create On: Jun 19, 2018 5:26:48 PM
 * Modify On: Jun 19, 2018 5:26:48 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.system.controller;

import com.artqiyi.dahuashai.common.constant.ResponseCodeConstant;
import com.artqiyi.dahuashai.response.ApiResponse;
import com.artqiyi.dahuashai.response.DefaultResponse;
import com.artqiyi.dahuashai.system.domain.SystemDistribution;
import com.artqiyi.dahuashai.system.service.DistributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distribution")
public class DistributionController {
    private static Logger logger = LoggerFactory.getLogger(DistributionController.class);

    @Autowired
    DistributionService distributionService;

    @GetMapping("/find")
    public ApiResponse findDistribution(@RequestParam("appType") Short appType,
                                        @RequestParam(value = "version", required = false) String version){
        ApiResponse apiResponse = new DefaultResponse();

        SystemDistribution distribution = distributionService.findSystemDistribution(appType,version);

        apiResponse.setCode(ResponseCodeConstant.SUCCESS);
        apiResponse.setMsg("success");
        apiResponse.setResult(distribution);

        return apiResponse;

    }

    //@RequestMapping(value = "findList", method = RequestMethod.GET)
    public ApiResponse findDistribution(@RequestParam(value = "appType", required = true) Short appType,
                                        @RequestParam(value = "version", required = false) String version,
                                        @RequestParam(value = "appStoreId", required = false) Short appStoreId){
        ApiResponse apiResponse = new DefaultResponse();

        List<SystemDistribution> distributionList = distributionService.findSystemDistribution(appType,version,appStoreId);

        apiResponse.setCode(ResponseCodeConstant.SUCCESS);
        apiResponse.setMsg("success");
        apiResponse.setResult(distributionList);

        return apiResponse;

    }


}
