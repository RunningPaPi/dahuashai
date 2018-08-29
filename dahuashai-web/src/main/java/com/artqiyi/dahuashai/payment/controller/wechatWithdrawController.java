/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: tanqiu-web
 * Author: author  wushyue@gmail.com
 * Create On: Jul 4, 2018 3:27:06 PM
 * Modify On: Jul 4, 2018 3:27:06 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.payment.controller;

import com.artqiyi.dahuashai.common.constant.MsgConstant;
import com.artqiyi.dahuashai.common.constant.ResponseCodeConstant;
import com.artqiyi.dahuashai.common.constant.SystemConfig;
import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrder;
import com.artqiyi.dahuashai.payment.service.AccountService;
import com.artqiyi.dahuashai.payment.service.PayService;
import com.artqiyi.dahuashai.payment.service.TransLogService;
import com.artqiyi.dahuashai.response.ApiResponse;
import com.artqiyi.dahuashai.response.DefaultResponse;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.GettransferinfoResult;
import weixin.popular.bean.paymch.Transfers;
import weixin.popular.bean.paymch.TransfersResult;
import weixin.popular.client.LocalHttpClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * 用户提现余额到微信零钱
 *
 * @author wushuang
 * @since 2018-07-04
 */
@Controller
@RequestMapping("/api/webchatpay")
public class wechatWithdrawController {
	private static final Logger logger = LoggerFactory.getLogger(wechatWithdrawController.class);

	@Value("${wxapplet.appId}")
	private String appid;

	@Value("${cert.file.path}")
	private String certFilePath;

	@Autowired
	PayService payService;

	@Autowired
	IUserService userService;

	@Autowired
	IUserInfoService userInfoService;

	@Autowired
	TransLogService transLogService;

	@Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
	AccountService accountService;

	private static final SystemConfig sysConfig = ConfigCache.getOrCreate(SystemConfig.class);

	/**
	 * 申请提现
	 * @param request
	 * @param response
	 * @param userId
	 * @param userName
	 * @param openid
	 * @param amount
	 * @return
	 */
	@RequestMapping(value = "withdraw", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ApiResponse withdraw(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam(value = "userId", required = true) Long userId,
                                @RequestParam(value = "userName", required = true) String userName,
                                @RequestParam(value = "openid", required = true) String openid,
                                @RequestParam(value = "amount", required = true) Long amount) {

		String notify_url = sysConfig.getNotifyUrl();

		String clientIp = request.getRemoteAddr();

		ApiResponse apiResponse = new DefaultResponse();
		Map<Object, Object> result = new HashMap<>();
		apiResponse.setResult(result);

		if (null == userId || 0 > userId) {
			apiResponse.setCode(ResponseCodeConstant.PARAM_FAIL);
			apiResponse.setMsg("Bad Request Parameter:userId can not be null,or,less than 0");
			result.put("isOprSuccess", false);
			result.put("remainBalance", null);
			return apiResponse;
		}

		if (StringUtils.isEmpty(userName)) {
			apiResponse.setCode(ResponseCodeConstant.PARAM_FAIL);
			apiResponse.setMsg("Bad Request Parameter:userName can not be null,or,blank String");
			result.put("isOprSuccess", false);
			result.put("remainBalance", null);
			return apiResponse;
		}

		// 提现金额的合法性校验

		// 单笔提现金额最低为50元
		if (50 * 100 > amount) {
			apiResponse.setCode(ResponseCodeConstant.PARAM_FAIL);
			apiResponse.setMsg("单笔提现金额最低为50元");
			result.put("isOprSuccess", false);
			result.put("remainBalance", null);
			return apiResponse;
		}

		// 单笔提现金额最高1000元
		if (1000 * 100 < amount) {
			apiResponse.setCode(ResponseCodeConstant.PARAM_FAIL);
			apiResponse.setMsg("单笔提现金额最高1000元");
			result.put("isOprSuccess", false);
			result.put("remainBalance", null);
			return apiResponse;
		}

		UserInfo userInfo = userInfoService.selectByUserId(userId);
		if (userInfo==null) {
			apiResponse.setCode(ResponseCodeConstant.FAIL);
			apiResponse.setMsg("没有该用户");
			result.put("isOprSuccess", false);
			result.put("remainBalance", null);
			return apiResponse;
		}

		//如果金额不足，不再执行下面的操作
		if (userInfo.getBalance()<amount) {
			apiResponse.setCode(ResponseCodeConstant.FAIL);
			apiResponse.setMsg("余额不足");
			result.put("isOprSuccess", false);
			result.put("remainBalance", userInfo.getBalance());
			return apiResponse;
		}

//		if (!accountService.isEnoughBalance(userId, amount)) {
//			apiResponse.setCode(ResponseCodeConstant.PARAM_FAIL);
//			apiResponse.setMsg("余额不足");
//			result.put("isOprSuccess", false);
//			result.put("remainBalance", null);
//			return apiResponse;
//		}

		PayWithdrawOrder withdrawOrder = new PayWithdrawOrder();
		
		withdrawOrder.setUserId(userId);
		withdrawOrder.setUserName(userName);
		withdrawOrder.setClientIp(clientIp);
		withdrawOrder.setWithdrawAmount(amount);
		withdrawOrder.setOrderAmount(amount);
		withdrawOrder.setOpenid(openid);

		
		// 生成自己的订单
		String outTradeNo = "";
		try {
			outTradeNo = payService.createWithdrawOrder(userId, userName, clientIp, withdrawOrder,SystemConstant.PAY_CHANNEL_WXAPPLET);
		} catch (Exception e) {
			logger.error("生成内部订单错误", e);

		}

		if (StringUtils.isEmpty(outTradeNo)) {
			apiResponse.setCode(ResponseCodeConstant.FAIL);
			apiResponse.setMsg("生成内部订单错误");
			result.put("isOprSuccess", false);
			result.put("remainBalance", null);
			return apiResponse;
		}

		//先扣账
		User user = userService.selectById(userId);
		long balanceAfter = userInfo.getBalance() - amount;
		userInfo.setBalance(balanceAfter);
		userInfoService.saveOrUpdate(userInfo);
		//记流水
		transLogService.generateTransLogForWithdraw(amount, user, userInfo);

		apiResponse.setCode(ResponseCodeConstant.SUCCESS);
		apiResponse.setMsg("提现成功，奖励将于7个工作日内发放");

		result.put("isOprSuccess", true);
		result.put("remainBalance", balanceAfter);
		apiResponse.setResult(result);
		return apiResponse;
	}

	/**
	 * 转账接口
	 */
	@PostMapping("withdrawOrderTransfer")
	@ResponseBody
	public ApiResponse withdrawOrderTransfer(@RequestParam(value = "outTradeNos", required = true) String outTradeNos,HttpServletResponse servletResponse) {
		ApiResponse apiResponse = new DefaultResponse();
		servletResponse.setHeader("Access-Control-Allow-Origin", "*");
		servletResponse.setHeader("Access-Control-Allow-Credentials", "true");

		if (StringUtils.isEmpty(outTradeNos)) {
			apiResponse.setCode(ResponseCodeConstant.FAIL);
			apiResponse.setMsg("请至少选中一个订单号");
			return apiResponse;
		}

		List<String> outTradeNoList;
		if (outTradeNos.contains(",")) {
			String[] split = outTradeNos.split(",");
			outTradeNoList = Arrays.asList(split);
		}else{
			outTradeNoList = new ArrayList<>();
			outTradeNoList.add(outTradeNos);
		}

		//封装数据
		Map<String, Object> result = new HashMap<>();
		List<String> successList = new ArrayList<>();
		List<String> alreadySuccessList = new ArrayList<>();
		List<String> alreadyFailedList = new ArrayList<>();
		List<String> unknownList = new ArrayList<>();
		result.put("successList", successList);
		result.put("alreadySuccessList", alreadySuccessList);
		result.put("alreadyFailedList", alreadyFailedList);
		result.put("unknownList", unknownList);


		for (String outTradeNo : outTradeNoList) {
			PayWithdrawOrder withdrawOrder = payService.findWithdrawOrder(outTradeNo);
			if (withdrawOrder == null) {
				logger.info("数据库中没有找到该订单!", outTradeNo);
				unknownList.add(outTradeNo);
				continue;
			}

			Integer orderState = withdrawOrder.getOrderState();
			Long userId = withdrawOrder.getUserId();
			String userName = withdrawOrder.getUserName();
			Long amount = withdrawOrder.getWithdrawAmount();
			String clientIp = withdrawOrder.getClientIp();
			String openid = withdrawOrder.getOpenid();

			//如果处于待审核状态，说明第一次点击转账按钮，将状态改为待转账，可以让定时任务进行自动查找转账失败的，进行退钱
			if (orderState != null && SystemConstant.ORDER_PAY_STAT_UNDER_AUDIT.equals(orderState)) {
				withdrawOrder.setOrderState(SystemConstant.ORDER_PAY_STAT_WAIT);
				payService.updateWithdrawOrder(withdrawOrder);
			}
			//如果处于转账成功或转账失败
			if (orderState != null && SystemConstant.ORDER_PAY_STAT_SUCESS.equals(orderState)) {
				logger.info("转账单{}已经成功转账，可通过查询接口查询，如果已经超过一个月，可能需要登录商户号进行查询！!", outTradeNo);
				alreadySuccessList.add(outTradeNo);
				continue;
			}

			if (orderState != null && SystemConstant.ORDER_PAY_STAT_CANCEL.equals(orderState)) {
				logger.info("转账单{}已经转账失败，可通过查询接口查询，如果已经超过一个月，可能需要登录商户号进行查询！", outTradeNo);
				alreadyFailedList.add(outTradeNo);
				continue;
			}

			String appid = sysConfig.getWxappletAppId();
			String merchantId = sysConfig.getPartner();
			String partnerKey = sysConfig.getPartnerKey();
			String certFilePath = sysConfig.getCertFilePath();

			StringBuilder sb = new StringBuilder();
			sb.append("用户").append(":").append(userName).append(" 提现:").append(BigDecimal.valueOf(amount).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN)+"元");
			String desc = sb.toString();

			String finalOutTradeNo = outTradeNo;
			//与微信对接 转账
			Transfers transfers = new Transfers();

			transfers.setAmount(String.valueOf(amount));
			transfers.setDesc(desc);
			transfers.setMch_appid(appid);
			transfers.setMchid(merchantId);
			transfers.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
			transfers.setPartner_trade_no(finalOutTradeNo);
			transfers.setSpbill_create_ip(clientIp);
			transfers.setOpenid(openid);
			transfers.setRe_user_name(userName);
			transfers.setCheck_name("NO_CHECK");

			LocalHttpClient.initMchKeyStore(merchantId, certFilePath);
			TransfersResult transfersResult = PayMchAPI.mmpaymkttransfersPromotionTransfers(transfers, partnerKey);
			logger.info("转账单{}微信返回的结果为{}", finalOutTradeNo, transfersResult);
			//支付成功修改订单状态为2-支付成功, 并更新channel_pay_time 为支付平台的payment_time
			if (transfersResult != null && "SUCCESS".equals(transfersResult.getReturn_code()) && "SUCCESS".equals(transfersResult.getResult_code())) {
				withdrawOrder.setOrderState(SystemConstant.ORDER_PAY_STAT_SUCESS);
				Date channelPayTime = null;
				try {
					channelPayTime = DateUtil.parseDate(transfersResult.getPayment_time(), DateUtil.DATESEC_FORMAT);
				} catch (Exception e1) {
					try {
						channelPayTime = DateUtil.parseDate(transfersResult.getPayment_time(), DateUtil.DATESEC_FORMAT_NO_DASH);
					} catch (Exception e2) {
						logger.error("parseDate() exception", e1);
						logger.error("parseDate() exception", e2);

					}
				}
				if (null == channelPayTime) {
					channelPayTime = new Date();
				}
				withdrawOrder.setChannelPayTime(channelPayTime);
				int updateLine = payService.updateWithdrawOrder(withdrawOrder);
				if (updateLine == 0) {
					logger.error("转账单{}修改失败，订单已经转账过", outTradeNo,withdrawOrder.getWithdrawOrderNum());
					unknownList.add(outTradeNo);
				} else {
					logger.info("转账单{}成功转账", finalOutTradeNo);
					successList.add(outTradeNo);
				}
			} else if (transfersResult != null && "SUCCESS".equals(transfersResult.getReturn_code()) && "FAIL".equals(transfersResult.getResult_code())) {
				logger.info("转账单{}业务状态不明确，请查看错误描述，建议按照原订单号重试", finalOutTradeNo);
				unknownList.add(outTradeNo);
			} else if (transfersResult == null) {
				logger.info("提现单{}没有获取到结果", finalOutTradeNo);
				unknownList.add(outTradeNo);
			} else {
				logger.info("提现单{}请求不成功", finalOutTradeNo);
				unknownList.add(outTradeNo);
			}
		}
		apiResponse.setCode(ResponseCodeConstant.SUCCESS);
		apiResponse.setResult(result);
		StringBuilder msg = new StringBuilder();
		msg.append("转账情况如下");
		if (successList.size()>0) {
			msg.append("，转账成功：" + successList);
		}
		if (alreadySuccessList.size()>0) {
			msg.append("，已经转账过：" + alreadySuccessList);
		}
		if (unknownList.size()>0) {
			msg.append("，转账状态未明确：" + unknownList);
		}
		if (alreadyFailedList.size()>0) {
			msg.append("，已经转账失败：" + alreadyFailedList);
		}
		apiResponse.setMsg(msg.toString());
		return apiResponse;
	}



	/**
	 * 查询订单接口
	 * @param outTradeNo
	 * @return
	 */
	@GetMapping("withdrawOrderQuery")
	@ResponseBody
	public ApiResponse withdrawOrderQuery(@RequestParam(value = "outTradeNo", required = true) String outTradeNo, HttpServletResponse servletResponse) {
		ApiResponse response = new DefaultResponse();
		servletResponse.setHeader("Access-Control-Allow-Origin", "*");
		servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		try {
			GettransferinfoResult gettransferinfoResult = payService.withdrawOrderQueryByWxApplet(outTradeNo);
			response.setResult(gettransferinfoResult);
			response.setCode(ResponseCodeConstant.SUCCESS);
			response.setMsg(MsgConstant.SUCCESS_SEARCH);
		} catch (Exception e) {
			response.setResult(null);
			response.setCode(ResponseCodeConstant.SERVICE_FAIL);
			response.setMsg(e.getMessage());
			logger.error("【查询订单错误】",e);
		}
		return response;
	}

	/**
	 * 测试用 检查接口
	 * @return
	 */
	//@PostMapping("withdrawOrderCheck")
	//@ResponseBody
	public ApiResponse withdrawOrderCheck() {
		ApiResponse response = new DefaultResponse();
		try {
			payService.withdrawOrderCheck(null);
			response.setCode(ResponseCodeConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCodeConstant.SERVICE_FAIL);
			response.setMsg(e.getMessage());
		}
		return response;
	}





	public static void main(String[] args) {
		try {
			System.out.println(DateUtil.parseDate("2015-04-21 20:00:00", DateUtil.DATESEC_FORMAT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
