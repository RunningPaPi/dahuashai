/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan-service
 * Author: author  wushyue@gmail.com
 * Create On: May 10, 2018 11:49:41 AM
 * Modify On: May 10, 2018 11:49:41 AM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.payment.service;

import com.artqiyi.dahuashai.common.constant.RedisFiledConstant;
import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.common.util.PaginationUtil;
import com.artqiyi.dahuashai.common.util.SequenceGenerator;
import com.artqiyi.dahuashai.job.domain.ScheduleJob;
import com.artqiyi.dahuashai.payment.domain.CoinTranslog;
import com.artqiyi.dahuashai.payment.domain.CoinTranslogExample;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrder;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrderExample;
import com.artqiyi.dahuashai.payment.mapper.CoinTranslogMapper;
import com.artqiyi.dahuashai.payment.mapper.PayWithdrawOrderMapper;
import com.artqiyi.dahuashai.redis.RedisLock;
import com.artqiyi.dahuashai.redis.RedisService;
import com.artqiyi.dahuashai.service.IQuartzService;
import com.artqiyi.dahuashai.user.domain.User;
import com.artqiyi.dahuashai.user.domain.UserInfo;
import com.artqiyi.dahuashai.user.service.IUserInfoService;
import com.artqiyi.dahuashai.user.service.IUserInviteService;
import com.artqiyi.dahuashai.user.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.Gettransferinfo;
import weixin.popular.bean.paymch.GettransferinfoResult;
import weixin.popular.client.LocalHttpClient;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 支付业务逻辑 
 *
 * @author wushuang
 * @since 2018-05-10
 */
@Service("payService")
public class PayService {
    private static final Logger logger = LoggerFactory.getLogger(PayService.class);


    @Value("${wxapplet.appId}")
    private String appid;

    @Value("${pay.partner}")
    private String merchantId;

    @Value("${pay.partner.key}")
    private String partnerKey;

    @Value("${cert.file.path}")
    private String certFilePath;

    @Autowired
    PayWithdrawOrderMapper withdrawOrderMapper;

    
    @Autowired
    CoinTranslogMapper coinTranslogMapper;

    @Autowired
    AccountService accountService;


    @Autowired
    IUserInfoService userInfoService;

    @Autowired
    IUserService userService;

    @Autowired
    IUserInviteService userInviteService;

    @Autowired
    TransLogService transLogService;

    @Autowired
    RedisService redisService;

    @Autowired
    IQuartzService quartzService;

    @Autowired
    RedisLock redisLock;


    /**
     * 创建提现订单
     * @param userId
     * @param userName
     * @param clientIp
     * @param coinProduct
     * @return
     */
    public String createWithdrawOrder(Long userId, String userName, String clientIp, PayWithdrawOrder withdrawOrder, Integer channel) {
    	

		String depositOrderId = SequenceGenerator.getSequenceUUID();
		String OutTradeNo = SequenceGenerator.getShowIdBySeqId(depositOrderId,new Date());
		
        //先hardcode微信支付渠道, 后面配置支付渠道, 前端传过来
        withdrawOrder.setChannel(channel);

        //提现需要支付的人民币

        //提现的趣币数量

        withdrawOrder.setWithdrawOrderId(SequenceGenerator.getSequenceUUID());
        withdrawOrder.setWithdrawOrderNum(OutTradeNo);

        //withdrawOrder.setOrderDesc(userId+":"+userName+" 提现:"+withdrawOrder.getWithdrawAmount());
        withdrawOrder.setOrderDesc(userName+" 提现:"
                + BigDecimal.valueOf(withdrawOrder.getWithdrawAmount()).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN)+"元");

        //等待支付状态
        withdrawOrder.setOrderState(SystemConstant.ORDER_PAY_STAT_UNDER_AUDIT);//等待审核状态

        withdrawOrderMapper.insertSelective(withdrawOrder);

        return OutTradeNo;
    }


    /**
     * 找提现订单
     * @param withdrawOrderNum 订单号
     * @return CoinDepositOrder
     */
    public PayWithdrawOrder findWithdrawOrder(String withdrawOrderNum) {

    	PayWithdrawOrderExample example = new PayWithdrawOrderExample();
    	PayWithdrawOrderExample.Criteria criteria = example.createCriteria();
        criteria.andWithdrawOrderNumEqualTo(withdrawOrderNum);

        List<PayWithdrawOrder> list = withdrawOrderMapper.selectByExample(example);
        
        if(CollectionUtils.isEmpty(list)) {
            return null;
        	
        }
        return list.get(0);
    }

    /**
     * 更新订单状态 根据订单id和订单状态更新
     * @param withdrawOrder
     * @return int
     */
	public int updateWithdrawOrder(PayWithdrawOrder withdrawOrder) {
	    //如果状态已经修改，那么则不更新，避免重复修改，（比如正常流程和系统任务同时执行）
		PayWithdrawOrderExample orderExample = new PayWithdrawOrderExample();
        orderExample.or().andWithdrawOrderIdEqualTo(withdrawOrder.getWithdrawOrderId())
                        .andOrderStateNotEqualTo(withdrawOrder.getOrderState());
        return withdrawOrderMapper.updateByExampleSelective(withdrawOrder,orderExample);
	}


    /**
     * 查询用户账单
     * @param userId
     * @param accountType
     * @return List<CoinTranslog>
     */
    public List<CoinTranslog> findMyBill(Long userId, Integer accountType, Integer pageNum, Integer pageSize) {

        if (null == pageSize) {
            pageSize = 20;
        }

        if (null == pageNum) {
            pageNum = 1;
        }

        Integer startNum = PaginationUtil.getStartNum(pageNum, pageSize, 20);


        CoinTranslogExample example = new CoinTranslogExample();

        example.setOrderByClause("create_time desc");

        example.setOffset(startNum);
        example.setLimit(pageSize);

        CoinTranslogExample.Criteria criteria = example.createCriteria();

        if(null!=userId&&userId>0){
            criteria.andUserIdEqualTo(userId);
        }

        if(null!=accountType){
            criteria.andAccountTypeEqualTo(accountType);
        }

        return coinTranslogMapper.selectByExample(example);
    }


    /**
     * 查询转账订单
     * @param outTradeNo
     * @return
     */
    public GettransferinfoResult withdrawOrderQueryByWxApplet(String outTradeNo) {
        Gettransferinfo gettransferinfo = new Gettransferinfo();
        gettransferinfo.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
        gettransferinfo.setPartner_trade_no(outTradeNo);
        gettransferinfo.setMch_id(merchantId);
        gettransferinfo.setAppid(appid);
        //gettransferinfo.setSign_type("MD5");
        LocalHttpClient.initMchKeyStore(merchantId,certFilePath);
        GettransferinfoResult gettransferinfoResult = PayMchAPI.mmpaymkttransfersGettransferinfo(gettransferinfo, partnerKey);
        return gettransferinfoResult;
    }



    /**
     * 定时查询订单，检查是否已经转账成功，如果失败，将用户账户退还，自动修复
     */
    public void withdrawOrderCheck(Object obj) {
        //获取redis分布式锁
        String requestId = UUID.randomUUID().toString();
        boolean isLockGet = redisLock.tryGetDistributedLock(RedisFiledConstant.REDIS_LOCK_TASK_WITHDRAW_ORDER_CHECK, requestId, SystemConstant.REDIS_LOCK_EXPIRE_TIME_WITHDRAW_ORDER_CHECK);
        if (!isLockGet) {
            try {
                logger.info("本机{}的提现订单检查任务已经由其他机器执行过", InetAddress.getLocalHost().toString());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return;
        }

        logger.info("开始执行提现订单检查");
        PayWithdrawOrderExample orderExample = new PayWithdrawOrderExample();
        orderExample.or().andOrderStateEqualTo(SystemConstant.ORDER_PAY_STAT_WAIT);//处于待支付状态
        List<PayWithdrawOrder> payWithdrawOrders = withdrawOrderMapper.selectByExample(orderExample);

        List<String> list = new ArrayList<>();
        if (payWithdrawOrders != null && payWithdrawOrders.size() > 0) {
            for (PayWithdrawOrder order : payWithdrawOrders) {
                String outTradeNo = order.getWithdrawOrderNum();
                Integer channel = order.getChannel();
                try {
                    GettransferinfoResult transferinfoResult = null;
                    switch (channel) {
                        case SystemConstant.PAY_CHANNEL_WXAPPLET:
                            transferinfoResult = withdrawOrderQueryByWxApplet(outTradeNo);
                            break;
                        default:break;
                    }
                    if (transferinfoResult != null) {
                        if (!transferinfoResult.getReturn_code().equals("SUCCESS")){
                            logger.error("获取提现订单号为{}的请求失败，失败原因为{}",outTradeNo,transferinfoResult.getReturn_msg());
                            continue;
                        }
                        if (!transferinfoResult.getResult_code().equals("SUCCESS")) {
                            //微信api err_code 主要有
                            //NOT_FOUND  指定单号数据不存在  查询单号对应的数据不存在，请使用正确的商户订单号查询
                                //那么数据不存在的原因可能是：（1）付款还在处理中；（2）付款处理失败导致付款订单没有落地。在上述情况下，商户首先需要检查该商户订单号是否确实是自己发起的，如果商户确认是自己发起的，则请商户不要直接当做付款失败处理，
                                // 请商户隔几分钟再尝试查询，或者商户可以通过相同的商户订单号再次发起付款。
                                // 如果商户误把还在付款处理中的订单直接当付款失败处理，商户应当自行承担因此产生的所有损失和责任
                                //还有可能是超过了30天
                            //SYSTEMERROR 系统异常，请再调用发起查询
                            String err_code = transferinfoResult.getErr_code();
                            logger.warn("获取提现订单号为{}的订单信息失败，失败原因为{}",outTradeNo,err_code+":"+transferinfoResult.getErr_code_des());
                            continue;
                        }
                        String status = transferinfoResult.getStatus();
                        //调试用
                        if ("201807051406103XJou7".equals(outTradeNo)) {
                            status = "FAILED";
                        }
                        //微信api 目前有以下交易状态  SUCCESS:转账成功  FAILED:转账失败  PROCESSING:处理中
                        if (status.equals("FAILED")) {//如果转账失败，将提现金额退回到用户账户
                            logger.info("提现订单号为{}的订单转账失败，交易状态为{}，失败描述为{}",outTradeNo,transferinfoResult.getStatus(),transferinfoResult.getReason());
                            int updateLine = aferTransferFailedProcess(order,transferinfoResult);
                            if (updateLine!=0) {
                                list.add(outTradeNo);
                            }
                            continue;
                        }
                    }
                } catch (Exception e) {
                    logger.error("检查订单号为"+outTradeNo+"时，发生异常",e);
                }
            }
        }
        if (list.size()>0) {
            logger.info("提现订单检查完毕，该次检查以下订单成功完成退款{}",list);
            System.out.println("提现订单检查完毕，该次检查以下订单成功完成退款"+list);
        }else{
            logger.info("提现订单检查完毕，该次检查没有订单退款");
            System.out.println("提现订单检查完毕，该次检查没有订单退款");
        }
    }

    /**
     *
     * @param order
     * @param transferinfoResult
     * @return
     */
    private int aferTransferFailedProcess(PayWithdrawOrder order, GettransferinfoResult transferinfoResult) {
        Long withdrawAmount = order.getWithdrawAmount();
        //修改订单状态 并存入remark
        order.setOrderState(SystemConstant.ORDER_PAY_STAT_CANCEL);
        order.setRemark(transferinfoResult.getReason());
        int affectLine = updateWithdrawOrder(order);
        if (affectLine==0) {
            logger.warn("【订单处理警告】订单状态已经更新，或不存在该订单，不再继续执行");
            return affectLine;
        }
        //退款并生成流水
        Long userId = order.getUserId();
        User user = userService.selectById(userId);
        UserInfo userInfo = userInfoService.selectByUserId(userId);
        userInfo.setBalance(userInfo.getBalance()+withdrawAmount);
        userInfoService.saveOrUpdate(userInfo);
        //流水
        transLogService.generateTransLogForTransferFailed(withdrawAmount,user,userInfo);
        return affectLine;
    }

    /**
     * 设置定时检查提现订单状态任务
     */
    public void initWithdrawOrderCheck() {
        logger.info("设置定时检查提现订单状态任务");
        ScheduleJob job = new ScheduleJob();
        job.setClazzName(null);
        job.setIsConcurrent(false);
        job.setCronExpression(SystemConstant.WITHDRAW_ORDER_CHECK_TASK_TRIGGER);
        job.setDescription("initWithdrawOrderCheck");
        job.setIsSpringbean(true);
        job.setJobGroup(SystemConstant.TASK_GROUP_WITHDRAW_ORDER_CHECK_TASK);
        job.setJobName("提现订单定时检查任务");
        job.setJobstatus(SystemConstant.TASK_STATUS_READY);
        job.setTargetMethod("withdrawOrderCheck");
        job.setTargetObject("payService");
        job.setParam(null);
        quartzService.addJob(job);
        logger.info("定时检查提现订单状态任务设置完毕");
    }



    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
