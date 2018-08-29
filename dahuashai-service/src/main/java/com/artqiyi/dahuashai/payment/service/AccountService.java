/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan-service
 * Author: author  wushyue@gmail.com
 * Create On: May 9, 2018 3:19:37 PM
 * Modify On: May 9, 2018 3:19:37 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.payment.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.exception.PaymentException;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserService;

/**
 * 支付账户服务
 *
 * @author wushuang
 * @since 2018-05-09
 */
@Service("accountService")
public class AccountService {

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	IUserInfoService userInfoService;

	@Autowired
	IUserService userService;

	/**
	 * 入账, 充值, 做任务奖励, 打游戏奖励都会调用这个接口存入趣币或者积分数量
	 * 
	 * @param userId
	 * @param accountType
	 * @param depositAmount
	 */
	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Integer debit(Long userId, Integer accountType, Integer depositAmount) {

		// 查询对应用户
		UserInfo userInfo = userInfoService.selectByUserId(userId);

		if (userInfo == null || userInfo.getId() <= 0) {// 找不到用户信息
			logger.warn("入账时找不到用户账户");
			return 0;
		}
		userInfo.setUpdateTime(new Date());

		Integer coinBalance = userInfo.getCoin();
		Integer scoreBalance = userInfo.getPoint();
		if (SystemConstant.ACC_TYPE_GOLDCOIN.equals(accountType)) {
			// 入账到趣币账户
			coinBalance = coinBalance + depositAmount;
			userInfo.setCoin(coinBalance);
			userInfoService.saveOrUpdate(userInfo);
			logger.info("存入{}趣币成功", depositAmount);
			return coinBalance;

		}
		if (SystemConstant.ACC_TYPE_SCORE.equals(accountType)) {
			// 入账到积分账户
			scoreBalance = scoreBalance + depositAmount;
			userInfo.setPoint(scoreBalance);
			userInfoService.saveOrUpdate(userInfo);
			logger.info("存入{}积分成功", depositAmount);
			return scoreBalance;
		}

		return 0;
	}

	/**
	 * 扣费. 玩游戏报名,需要减少账户余额的都会调用这个方法
	 * 
	 * @param userId
	 * @param accountType
	 * @param depositAmount
	 */
	public void credit(Long userId, Integer accountType, Integer depositAmount) {

		// 查询对应用户
		UserInfo userInfo = userInfoService.selectByUserId(userId);
		credit(userInfo, accountType, depositAmount);

	}

	/**
	 * 扣费. 玩游戏报名,需要减少账户余额的都会调用这个方法
	 * 
	 * @param userInfo
	 * @param accountType
	 * @param depositAmount
	 */
	private void credit(UserInfo userInfo, Integer accountType, Integer depositAmount) {

		if (userInfo == null || userInfo.getId() <= 0) {// 找不到用户信息
			logger.warn("出账时找不到用户账户");
			return;
		}
		userInfo.setUpdateTime(new Date());

		if (SystemConstant.ACC_TYPE_GOLDCOIN.equals(accountType)) {
			// 入账到趣币账户
			userInfo.setCoin(userInfo.getCoin() - depositAmount);
			userInfoService.saveOrUpdate(userInfo);
			logger.info("扣费{}趣币成功", depositAmount);
			return;

		}
		if (SystemConstant.ACC_TYPE_SCORE.equals(accountType)) {
			// 入账到积分账户
			userInfo.setPoint(userInfo.getPoint() - depositAmount);
			userInfoService.saveOrUpdate(userInfo);
			logger.info("扣费{}积分成功", depositAmount);
			return;
		}

	}

	/**
	 * 转账
	 * 
	 * @param userId
	 * @param toUserId
	 * @param accountType
	 * @param depositAmount
	 */
	public void transfer(Long userId, Long toUserId, Integer accountType, Integer depositAmount) {

		deduct(userId, accountType, depositAmount);
		debit(toUserId, accountType, depositAmount);

		logger.info("转账{}给{}成功", depositAmount, toUserId);
	}

	public String findAccName(Long userId) {

		return userService.selectById(userId).getNickName();

	}

	/**
	 * 扣费. 玩游戏报名,需要减少账户余额的都会调用这个方法 @param userId @param accountType @param
	 * depositAmount @return boolean @throws
	 */
	public boolean deduct(Long userId, Integer accountType, Integer depositAmount) {
		UserInfo userInfo = userInfoService.selectByUserId(userId);
		if (isEnoughBalance(userInfo, accountType, depositAmount)) {
			throw new PaymentException("余额不足");
		}
		credit(userInfo, accountType, depositAmount);
		return true;
	}

	/**
	 * 判断用户账户余额是否足够
	 * 
	 * @param userId
	 * @param accountType
	 * @param depositAmount
	 * @return
	 */
	public boolean isEnoughBalance(Long userId, Integer accountType, Integer depositAmount) {
		// 查询对应用户
		UserInfo userInfo = userInfoService.selectByUserId(userId);
		return isEnoughBalance(userInfo, accountType, depositAmount);
	}
	
	public boolean isEnoughBalance(Long userId, Long amount) {
		// 查询对应用户
		UserInfo userInfo = userInfoService.selectByUserId(userId);
		return isEnoughBalance(userInfo, amount);
	}

	/**
	 * 判断用户账户余额是否足够, 如果调用方已经拿到UserInfo 直接调用这个方法
	 * 
	 * @param userInfo
	 * @param accountType
	 * @param amount
	 * @return
	 */
	public boolean isEnoughBalance(UserInfo userInfo, Integer accountType, Integer amount) {

		if (SystemConstant.ACC_TYPE_GOLDCOIN.equals(accountType)) {
			if (userInfo.getCoin() > amount) {
				return true;
			}
		}
		if (SystemConstant.ACC_TYPE_SCORE.equals(accountType)) {
			if (userInfo.getPoint() > amount) {
				return true;
			}
		}

		if (SystemConstant.ACC_TYPE_BALANCE.equals(accountType)) {
			if (userInfo.getBalance() >= amount) {
				return true;
			}
		}
		return false;
	}

	public boolean isEnoughBalance(UserInfo userInfo, Long amount) {

		if (userInfo.getBalance() >= amount) {
			return true;
		}

		return false;
	}

	public Long getBalance(Long userId, Integer accountType) {
		// 查询对应用户
		UserInfo userInfo = userInfoService.selectByUserId(userId);

		return userInfo.getBalance();

	}

}
