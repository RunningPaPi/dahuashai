package com.artqiyi.dahuashai.payment.service;

import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.util.DateUtil;
import com.artqiyi.dahuashai.common.util.PaginationUtil;
import com.artqiyi.dahuashai.payment.domain.CoinTranslog;
import com.artqiyi.dahuashai.payment.domain.CoinTranslogExample;
import com.artqiyi.dahuashai.payment.mapper.CoinTranslogMapper;
import com.artqiyi.dahuashai.payment.mapper.ext.CustomCoinTranslogMapper;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;

@Service
public class TransLogService {
    private static Logger logger = LoggerFactory.getLogger(TransLogService.class);
    @Autowired
    private CoinTranslogMapper coinTranslogMapper;
    
    @Autowired
    private CustomCoinTranslogMapper customCoinTranslogMapper;

    public int addTranslog(CoinTranslog translog){
        return coinTranslogMapper.insertSelective(translog);
    }

    /**
     * 生成首次注册登录发放红包流水
     * @param userInfo 已经保存过的userInfo，即账户余额已经变化
     * @param user
     * @param transAmount 账户变化数量
     */
    public void generateRedpackForRegisterLog(UserInfo userInfo, User user, Long transAmount) {
        CoinTranslog translog = new CoinTranslog();
        translog.setUserId(user.getId());
        translog.setUserName(user.getNickName());
        translog.setAccountType(SystemConstant.ACC_TYPE_BALANCE);
        translog.setTransType(SystemConstant.TRANS_TYPE_REGISTER_GRANT);
        translog.setTransFlag(SystemConstant.TRANS_DIRECT_INCOM);
        translog.setTransAmount(Integer.valueOf(transAmount+""));
        translog.setBalance(Integer.valueOf(userInfo.getBalance()+""));
        translog.setRemark("新手红包");
        coinTranslogMapper.insertSelective(translog);
    }

    /**
     * 生成提现申请账户流水
     * @param userInfo 已经保存过的userInfo，即账户余额已经变化
     * @param user
     * @param transAmount 账户变化数量
     */
    public void generateRedpackWithdrawApplyLog(UserInfo userInfo, User user, Long transAmount) {
        CoinTranslog translog = new CoinTranslog();
        translog.setUserId(user.getId());
        translog.setUserName(user.getNickName());
        translog.setAccountType(SystemConstant.ACC_TYPE_BALANCE);
        translog.setTransType(SystemConstant.TRANS_TYPE_WITHDRAW_APPLY);
        translog.setTransFlag(SystemConstant.TRANS_DIRECT_OUTCOME);
        translog.setTransAmount(Integer.valueOf(transAmount+""));
        translog.setBalance(Integer.valueOf(userInfo.getBalance()+""));
        translog.setRemark("红包提现");
        coinTranslogMapper.insertSelective(translog);
    }
    
    /**
     * 用户是否充值过趣币
     * @param userId
     */
    public boolean isDeposit(Long userId) {
    	CoinTranslogExample example = new CoinTranslogExample();
    	CoinTranslogExample.Criteria criteria = example.createCriteria();
    	criteria.andUserIdEqualTo(userId);
    	criteria.andTransTypeEqualTo(SystemConstant.TRANS_TYPE_DEPOSIT); //充值
    	criteria.andAccountTypeEqualTo(SystemConstant.ACC_TYPE_GOLDCOIN);//趣币
    	List<CoinTranslog> coinTranslogList = coinTranslogMapper.selectByExample(example);
    	if(coinTranslogList == null || coinTranslogList.size() == 0) { //没充值过
    		return false;
    	}
    	
    	return true;
    }
    
    
    /**
     * 用户是否消耗过趣币
     * @param userId
     */
    public boolean isConsumeCoin(Long userId) {
    	CoinTranslogExample example = new CoinTranslogExample();
    	CoinTranslogExample.Criteria criteria = example.createCriteria();
    	criteria.andUserIdEqualTo(userId);
    	criteria.andAccountTypeEqualTo(SystemConstant.ACC_TYPE_GOLDCOIN); //趣币
    	criteria.andTransFlagEqualTo(2); //支出
    	List<CoinTranslog> coinTranslogList = coinTranslogMapper.selectByExample(example);
    	if(coinTranslogList == null || coinTranslogList.size() == 0) { //没记录
    		return false;
    	}else{
    	    //不计入退赛返回(目前只有赛马游戏)的费用，相当于没有消费
            Integer ignoreSum = customCoinTranslogMapper.getIgnoreSumCoinByUserId(userId, SystemConstant.TRANS_TYPE_QUIT);
            ignoreSum = ignoreSum == null ? 0 : ignoreSum;
            IntSummaryStatistics intSummaryStatistics = coinTranslogList.stream().mapToInt(value -> value.getTransAmount()==null?0:value.getTransAmount()).summaryStatistics();
            Integer sumConsume = Integer.valueOf(intSummaryStatistics.getSum()+"");
            if (ignoreSum.compareTo(sumConsume)>0) {
                logger.warn("流水异常，退赛总费用大于消费总费用");
                return false;
            }
            return ignoreSum.compareTo(sumConsume)<0;
        }
    }
    
    /**
     * 查询用户当天累计消耗趣币的总数
     * @param userId
     * @return
     */
    public Integer sumConsumeAmountOfCurrDay(Long userId) {
    	return customCoinTranslogMapper.getSumCoinByUserIdAndTime(userId, DateUtil.getCurrentStartTimeDaily(), DateUtil.getCurrentEndTimeDaily());
    }
    /**
     * 查询用户当天累计退赛返还趣币的总数
     * @param userId
     * @return
     */
    public Integer sumReturnAmountOfCurrDay(Long userId) {
    	return customCoinTranslogMapper.getIgnoreSumCoinByUserIdAndTime(userId, SystemConstant.TRANS_TYPE_QUIT,DateUtil.getCurrentStartTimeDaily(), DateUtil.getCurrentEndTimeDaily());
    }


    /**
     * 生成下线充值时给邀请人的奖励
     * @param invitorUserInfo 账户已经加上奖励了
     * @param invitorUser
     * @param awardAmountForInvitor
     * @param percent
     * @param depositMoneyAmount
     * @param userId
     */
    public void rewardForInvitor(UserInfo invitorUserInfo, User invitorUser, long awardAmountForInvitor, int percent, Integer depositMoneyAmount, Long userId) {
        CoinTranslog translog = new CoinTranslog();
        translog.setUserId(invitorUser.getId());
        translog.setUserName(invitorUser.getNickName());
        translog.setAccountType(SystemConstant.ACC_TYPE_BALANCE);
        translog.setTransType(SystemConstant.TRANS_TYPE_DEPOSIT_AWARD_FOR_INVITOR);
        translog.setTransFlag(SystemConstant.TRANS_DIRECT_INCOM);
        translog.setTransAmount(Integer.valueOf(awardAmountForInvitor+""));
        translog.setBalance(Integer.valueOf(invitorUserInfo.getBalance()+""));
        BigDecimal amount = BigDecimal.valueOf(depositMoneyAmount).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN);
        translog.setRemark("好友充值"+amount+"元");
        translog.setAwardPercentInvitor(percent);
        translog.setAwardFromUserId(userId);
        coinTranslogMapper.insertSelective(translog);
    }



    public List<CoinTranslog> selectByExample(CoinTranslogExample coinTranslogExample) {
        return coinTranslogMapper.selectByExample(coinTranslogExample);
    }

    /**
     * 写交易流水
     * @param translog
     */

    @Transactional(readOnly = false,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void addTransLog(CoinTranslog translog){
        coinTranslogMapper.insertSelective(translog);
    }



    /**
     * 生成提现交易流水
     * @param amount
     * @param user
     * @param userInfo
     */
    public void generateTransLogForWithdraw(Long amount, User user, UserInfo userInfo) {
        CoinTranslog coinTranslog = new CoinTranslog();
        coinTranslog.setUserId(userInfo.getUserId());
        coinTranslog.setUserName(user.getNickName());
        coinTranslog.setAccountType(SystemConstant.ACC_TYPE_BALANCE);
        coinTranslog.setTransType(SystemConstant.TRANS_TYPE_WITHDRAW);
        coinTranslog.setTransFlag(SystemConstant.TRANS_DIRECT_OUTCOME);
        coinTranslog.setTransAmount(Integer.valueOf(amount+""));
        coinTranslog.setBalance(Integer.valueOf(userInfo.getBalance()+""));
        coinTranslog.setRemark("余额提现");
        coinTranslog.setTransTime(new Date());
        addTransLog(coinTranslog);
    }

    /**
     * 企业转账失败退款流水
     * @param withdrawAmount
     * @param user
     * @param userInfo
     */
    public void generateTransLogForTransferFailed(Long withdrawAmount, User user, UserInfo userInfo) {
        CoinTranslog coinTranslog = new CoinTranslog();
        coinTranslog.setUserId(userInfo.getUserId());
        coinTranslog.setUserName(user.getNickName());
        coinTranslog.setAccountType(SystemConstant.ACC_TYPE_BALANCE);
        coinTranslog.setTransType(SystemConstant.TRANS_TYPE_WITHDRAW_TRANSFER_FAILED);
        coinTranslog.setTransFlag(SystemConstant.TRANS_DIRECT_INCOM);
        coinTranslog.setTransAmount(Integer.valueOf(withdrawAmount+""));
        coinTranslog.setBalance(Integer.valueOf(userInfo.getBalance()+""));
        coinTranslog.setRemark("提现失败");
        coinTranslog.setTransTime(new Date());
        addTransLog(coinTranslog);
    }



    /**
     * 分页查询交易记录
     * @param userId
     * @param accountType
     * @param transType
     * @param transFlag
     * @return
     */
    public List<CoinTranslog> findTransLogList(Integer pageNum, Integer pageSize, Long userId, Integer accountType, String transType, Integer transFlag) {
        if (pageNum == null) {
            pageNum = 1;
        }

        if (pageSize == null ) {
            pageSize = 20;
        }

        Integer startNum = PaginationUtil.getStartNum(pageNum, pageSize, 20);

        CoinTranslogExample example = new CoinTranslogExample();
        example.setOrderByClause("trans_time desc");
        example.setOffset(startNum);
        example.setLimit(pageSize);

        CoinTranslogExample.Criteria criteria = example.createCriteria();

        if(userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }
        if(accountType != null && accountType > 0) {
            criteria.andAccountTypeEqualTo(accountType);
        }
        if(transType != null && !"".equals(transType)) {
            criteria.andTransTypeEqualTo(transType);
        }
        if(transFlag != null && transFlag > 0) {
            criteria.andTransFlagEqualTo(transFlag);
        }

        return coinTranslogMapper.selectByExample(example);
    }
    
    /**
     * 获取用户总奖励--奖金
     * @param userId 用户ID
     * @return
     */
    public Integer getSumRewardByUserId(Long userId) {
    	return customCoinTranslogMapper.getSumRewardByUserId(userId);
    }

}
