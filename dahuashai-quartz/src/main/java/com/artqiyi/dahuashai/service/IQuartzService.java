package com.artqiyi.dahuashai.service;

import org.quartz.Scheduler;

import com.artqiyi.dahuashai.job.domain.ScheduleJob;
import com.artqiyi.dahuashai.job.domain.ScheduleJobExample;
import com.artqiyi.dahuashai.job.domain.ScheduleJobFailLog;

import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/9
 * Modify On: 2018/5/9 by chencunjun
 */
public interface IQuartzService {
    Scheduler getScheduler();
    void startJobs();
    boolean addJob(ScheduleJob job);
    boolean updatejob(ScheduleJob job);
    boolean deletJob(ScheduleJob job);
    boolean startJob(ScheduleJob job);
    boolean pauseJob(ScheduleJob job);
    List<ScheduleJob> selectByExample(ScheduleJobExample scheduleJobExample);
    void updateByPrimaryKeySelective(ScheduleJob scheduleJob);
    void addJobFailLog(ScheduleJobFailLog scheduleJobFailLog);

}
