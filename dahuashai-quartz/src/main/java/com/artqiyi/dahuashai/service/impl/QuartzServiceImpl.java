package com.artqiyi.dahuashai.service.impl;

import com.artqiyi.dahuashai.common.constant.SystemConstant;
import com.artqiyi.dahuashai.job.domain.ScheduleJob;
import com.artqiyi.dahuashai.job.domain.ScheduleJobExample;
import com.artqiyi.dahuashai.job.domain.ScheduleJobFailLog;
import com.artqiyi.dahuashai.job.mapper.ScheduleJobFailLogMapper;
import com.artqiyi.dahuashai.job.mapper.ScheduleJobMapper;
import com.artqiyi.dahuashai.listener.QuartzJobListener;
import com.artqiyi.dahuashai.service.IQuartzService;
import com.artqiyi.dahuashai.util.SpringContextUtil;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/9
 * Modify On: 2018/5/9 by chencunjun
 */
@Service
public class QuartzServiceImpl implements IQuartzService {
    private static Logger logger = LoggerFactory.getLogger(QuartzJobListener.class);
    @Resource
    private Scheduler scheduler ;
    @Resource
    private QuartzJobListener quartzJobListener;
    @Autowired
    private ScheduleJobMapper scheduleJobMapper;
    @Autowired
    private ScheduleJobFailLogMapper scheduleJobFailLogMapper;

    @Override
    public Scheduler getScheduler() {
        return scheduler;
    }

    /**
     * 开启所有任务
     */
    @Override
    public void startJobs() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加任务
     * @param job
     * @return
     */
    @Override
    public boolean addJob(ScheduleJob job)  {
        boolean flag = false;
        CronTrigger cronTrigger = null;
        try {
            ScheduleJob scheduleJob=scheduleJobMapper.selectByPrimaryKey(job.getId());
            if(null!=scheduleJob && scheduleJob.getJobstatus()!= SystemConstant.TASK_STATUS_VAILD){
                logger.debug(job.getJobName()+"任务已失效......");
                return false;
            }
            cronTrigger = checkTrigger(job);
            // 不存在该任务的触发器
            if (cronTrigger == null) {
                // 新建一个基于Spring的管理Job类
                MethodInvokingJobDetailFactoryBean methodInvJobDetailFB = new MethodInvokingJobDetailFactoryBean();
                methodInvJobDetailFB.setName(job.getJobName());
                methodInvJobDetailFB.setGroup(job.getJobGroup());
                //设置任务类(这里的任务类是交给Spring管理的Bean，如果不是Spring的Bean,需要类的全路径)
                if(job.getIsSpringbean()){
                    methodInvJobDetailFB.setTargetObject( SpringContextUtil.getApplicationContext().getBean(job.getTargetObject()));
                }else{
                    methodInvJobDetailFB.setTargetObject(Class.forName(job.getClazzName()).newInstance());
                }

                //设置任务方法
                methodInvJobDetailFB.setTargetMethod(job.getTargetMethod());
                //设置任务参数
                methodInvJobDetailFB.setArguments(job.getParam());
                /** 并发设置 */
                methodInvJobDetailFB.setConcurrent(job.getIsConcurrent());
                // 将管理Job类提交到计划管理类
                methodInvJobDetailFB.afterPropertiesSet();

                JobDetail jobDetail = methodInvJobDetailFB.getObject();
                jobDetail.getJobDataMap().put(job.getJobName(), job);

                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的cronExpression表达式构建一个新的trigger
                CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
                if(scheduler.isShutdown()) {
                    startJobs();
                }
//                long jobId=scheduleJobMapper.insert(job);//保存任务信息
//                job.setId(jobId);
              //  scheduler.getListenerManager().removeJobListener()
                scheduler.getListenerManager().addJobListener(quartzJobListener);//加入监听器
                scheduler.scheduleJob(jobDetail, trigger);// 注入到管理类

                flag = true;
            }else {
                flag = false;
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return flag;
    }

    //检查是否有相同的触发器
    private CronTrigger checkTrigger(ScheduleJob job) throws SchedulerException {
        // 获得触发器key
        TriggerKey triggerKey = new TriggerKey(job.getJobName(), job.getJobGroup());
        // 获得触发器Cron
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        return cronTrigger;
    }

    /**
     * 更新任务
     * @param job
     * @return
     */
    @Override
    public boolean updatejob(ScheduleJob job) {
        boolean flag = false;
        try{
            // 获得触发器key
            TriggerKey triggerKey = new TriggerKey(job.getJobName(), job.getJobGroup());
            // 获得触发器Cron
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            if(cronTrigger == null) {
                return flag;
            }else {

                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());

                //按新的cronExpression表达式重新构建trigger
                cronTrigger = cronTrigger.getTriggerBuilder()
                        .withIdentity(triggerKey)
                        .withSchedule(scheduleBuilder)
                        .build();
                if(scheduler.isShutdown()) {
                    startJobs();
                }

                //按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, cronTrigger);
                flag = true;
//                ScheduleJob jobPO = wyFeeJobDao.getJobById(job.getId());
//                // Trigger已存在，那么更新相应的定时设置
//                if(jobPO.getJobStatus() == JobStatusEnum.CLOSE.getStatus() || jobPO.getJobStatus() == JobRunningStatusEnum.STOP.getStatus()) {
//                    //暂停任务
//                    pauseJob(job);
//                    flag=true;
//                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 删除任务
     * @param job
     * @return
     */
    @Override
    public boolean deletJob(ScheduleJob job)  {
        boolean flag = false;
        try {
//            CronTrigger checkTrigger = checkTrigger(job);
//            if(checkTrigger == null) {
//                return flag;
//            }else {
//                //删除任务
//                JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
//                scheduler.deleteJob(jobKey);
//                flag = true;
//            }
            //删除任务
            JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
            scheduler.deleteJob(jobKey);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }


    /**
     * 启动任务
     * @param job
     * @return
     */
    @Override
    public boolean startJob(ScheduleJob job)  {
        boolean flag = false;
        try {
            CronTrigger checkTrigger = checkTrigger(job);
            if(checkTrigger == null) {
                return flag;
            }else {
                //开始任务
                JobKey jobKey = JobKey.jobKey(job.getJobName(),job.getJobGroup());
                scheduler.resumeJob(jobKey);
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 暂定任务
     * @param job
     * @return
     */
    @Override
    public boolean pauseJob(ScheduleJob job)  {
        boolean flag = false;
        try {
            CronTrigger checkTrigger = checkTrigger(job);
            if (checkTrigger == null) {
                return flag;
            } else {
                //暂停任务
                JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
                scheduler.pauseJob(jobKey);
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public List<ScheduleJob> selectByExample(ScheduleJobExample scheduleJobExample) {
        return scheduleJobMapper.selectByExample(scheduleJobExample);
    }

    @Override
    public void updateByPrimaryKeySelective(ScheduleJob scheduleJob) {
        scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob);
    }

    /**
     * 添加日志执行失败日志
     * @param scheduleJobFailLog
     */
    @Override
    public void addJobFailLog(ScheduleJobFailLog scheduleJobFailLog) {
        scheduleJobFailLogMapper.insert(scheduleJobFailLog);
    }
}
