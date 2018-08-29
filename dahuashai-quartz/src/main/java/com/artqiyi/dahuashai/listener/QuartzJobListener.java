package com.artqiyi.dahuashai.listener;

import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.job.domain.ScheduleJob;
import com.artqiyi.dahuashai.job.domain.ScheduleJobFailLog;
import com.artqiyi.dahuashai.job.mapper.ScheduleJobFailLogMapper;
import com.artqiyi.dahuashai.job.mapper.ScheduleJobMapper;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/9
 * Modify On: 2018/5/9 by chencunjun
 */

/**
 * 任务监听器
 */
@Service
public class QuartzJobListener implements JobListener {

    private static Logger logger = LoggerFactory.getLogger(QuartzJobListener.class);

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;
    @Autowired
    private ScheduleJobFailLogMapper scheduleJobFailLogMapper;

    public static final String LISTENER_NAME = "JobListener";


    //这里必须有个不为null的name
    @Override
    public String getName() {
        return LISTENER_NAME;
    }

    /**
     * 任务执行之前
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        JobKey key = context.getJobDetail().getKey();
//        ScheduleJob scheduleJob=(ScheduleJob)context.getJobDetail().getJobDataMap().get(key .getName());
//        scheduleJob.setJobstatus(SystemConstant.TASK_STATUS_RUN);
//        scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob);
        logger.debug("任务分组："+key.getGroup()+" 任务名称："+key.getName()+"开始执行.......");
    }

    /**
     * 但是如果当TriggerListener中的vetoJobExecution方法返回true时,那么执行这个方法.
     * 需要注意的是 如果方法(2)执行 那么(1),(3)这个俩个方法不会执行,因为任务被终止了嘛.
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }
    /**
     * 任务执行完成后执行,jobException如果它不为空则说明任务在执行过程中出现了异常
     */
    @SuppressWarnings("null")
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException exception) {
        JobKey key = context.getJobDetail().getKey();
        ScheduleJob scheduleJob=(ScheduleJob)context.getJobDetail().getJobDataMap().get(key .getName());
        if(exception==null) {
            logger.info("任务分组："+key.getGroup()+" 任务名称："+key.getName()+"执行成功!");
            scheduleJob.setJobstatus(SystemConstant.TASK_STATUS_SUCCESS);
        }else {
            logger.info("任务分组："+key.getGroup()+" 任务名称："+key.getName()+"执行失败!失败原因："+exception.getMessage());
            scheduleJob.setJobstatus(SystemConstant.TASK_STATUS_FAIL);
            ScheduleJobFailLog scheduleJobFailLog=new ScheduleJobFailLog();
            scheduleJobFailLog.setJobId(scheduleJob.getId());
            scheduleJobFailLog.setJobName(scheduleJob.getJobName());
            scheduleJobFailLog.setJobGroup(scheduleJob.getJobGroup());
            scheduleJobFailLog.setReason(exception.getMessage());
            scheduleJobFailLog.setCreateTime(new Date());
            scheduleJobFailLogMapper.insert(scheduleJobFailLog);
        }
        scheduleJobMapper.insert(scheduleJob);
    }
}
