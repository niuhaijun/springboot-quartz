package com.niu.springbootquartz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.niu.springbootquartz.common.ClassUtils;
import com.niu.springbootquartz.controller.param.JobInfoVO;
import com.niu.springbootquartz.mapper.JobMapper;
import com.niu.springbootquartz.service.ScheduleJobService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

  @Autowired
  private Scheduler scheduler;

  @Autowired
  private JobMapper jobMapper;

  @Override
  public List<JobInfoVO> getAllJobList() throws SchedulerException {

    List<JobInfoVO> jobList = new ArrayList<>();
    GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
    Set<JobKey> jobKeySet = scheduler.getJobKeys(matcher);
    for (JobKey jobKey : jobKeySet) {
      List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
      for (Trigger trigger : triggers) {
        JobInfoVO jobInfoVO = new JobInfoVO();
        this.wrapScheduleJob(jobInfoVO, scheduler, jobKey, trigger);
        jobList.add(jobInfoVO);
      }
    }

    return jobList;
  }

  @Override
  public List<JobInfoVO> getRunningJobList() throws SchedulerException {

    List<JobExecutionContext> executingJobList = scheduler.getCurrentlyExecutingJobs();
    List<JobInfoVO> jobList = new ArrayList<>(executingJobList.size());
    for (JobExecutionContext executingJob : executingJobList) {
      JobInfoVO jobInfoVO = new JobInfoVO();
      JobDetail jobDetail = executingJob.getJobDetail();
      JobKey jobKey = jobDetail.getKey();
      Trigger trigger = executingJob.getTrigger();
      this.wrapScheduleJob(jobInfoVO, scheduler, jobKey, trigger);
      jobList.add(jobInfoVO);
    }
    return jobList;
  }

  @Override
  public void addJob(JobInfoVO jobInfoVO) throws Exception {

    checkNotNull(jobInfoVO);
    Preconditions.checkNotNull(StringUtils.isEmpty(jobInfoVO.getCronExpression()),
        "CronExpression is null");

    TriggerKey triggerKey = TriggerKey
        .triggerKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup());
    CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
    if (trigger != null) {
      throw new Exception("job already exists!");
    }

    JobDataMap jobDataMap = new JobDataMap();
    jobDataMap.put("scheduleJob", jobInfoVO);
    JobDetail jobDetail = JobBuilder.newJob(ClassUtils.getJobClass(jobInfoVO.getJobClass()))
        .withIdentity(jobInfoVO.getJobName(), jobInfoVO.getJobGroup())
        .withDescription(jobInfoVO.getJobDescription())
        .usingJobData(jobDataMap)
        .storeDurably()
        .build();

    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
        .cronSchedule(jobInfoVO.getCronExpression());
    trigger = TriggerBuilder.newTrigger()
        .withIdentity(jobInfoVO.getJobName(), jobInfoVO.getJobGroup())
        .withDescription(jobInfoVO.getJobDescription())
        .startNow()
        .withSchedule(cronScheduleBuilder)
        .build();

    scheduler.scheduleJob(jobDetail, trigger);
  }

  @Override
  public void updateJobCronExpression(JobInfoVO jobInfoVO) throws SchedulerException {

    checkNotNull(jobInfoVO);
    Preconditions.checkNotNull(StringUtils.isEmpty(jobInfoVO.getCronExpression()),
        "CronExpression is null");

    TriggerKey triggerKey = TriggerKey
        .triggerKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup());
    CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
        .cronSchedule(jobInfoVO.getCronExpression());
    cronTrigger = cronTrigger.getTriggerBuilder()
        .withIdentity(triggerKey)
        .withSchedule(cronScheduleBuilder)
        .build();
    scheduler.rescheduleJob(triggerKey, cronTrigger);
  }

  @Override
  public void pauseJob(JobInfoVO jobInfoVO) throws SchedulerException {

    checkNotNull(jobInfoVO);
    JobKey jobKey = JobKey.jobKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup());
    scheduler.pauseJob(jobKey);
  }

  @Override
  public void resumeJob(JobInfoVO jobInfoVO) throws SchedulerException {

    checkNotNull(jobInfoVO);
    JobKey jobKey = JobKey.jobKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup());
    scheduler.resumeJob(jobKey);
  }

  @Override
  public void deleteJob(JobInfoVO jobInfoVO) throws SchedulerException {

    checkNotNull(jobInfoVO);
    JobKey jobKey = JobKey.jobKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup());
    scheduler
        .pauseTrigger(TriggerKey.triggerKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup()));
    scheduler
        .unscheduleJob(TriggerKey.triggerKey(jobInfoVO.getJobName(), jobInfoVO.getJobGroup()));
    scheduler.deleteJob(jobKey);
  }

  @Override
  public void runJobOnce(JobInfoVO JobInfoVO) throws SchedulerException {

    checkNotNull(JobInfoVO);
    JobKey jobKey = JobKey.jobKey(JobInfoVO.getJobName(), JobInfoVO.getJobGroup());
    scheduler.triggerJob(jobKey);
  }

  @Override
  public SchedulerMetaData getMetaData() throws SchedulerException {

    return scheduler.getMetaData();
  }

  @Override
  public PageInfo<JobInfoVO> getJobAndTriggerDetails(int pageNum, int pageSize) {

    PageHelper.startPage(pageNum, pageSize);
    List<JobInfoVO> list = jobMapper.getJobAndTriggerDetails();
    PageInfo<JobInfoVO> page = new PageInfo<>(list);
    return page;
  }

  private void checkNotNull(JobInfoVO jobInfoVO) {

    Preconditions.checkNotNull(jobInfoVO, "job is null");
    Preconditions.checkNotNull(StringUtils.isEmpty(jobInfoVO.getJobName()), "jobName is null");
    Preconditions.checkNotNull(StringUtils.isEmpty(jobInfoVO.getJobGroup()), "jobGroup is null");
  }

  private void wrapScheduleJob(JobInfoVO jobInfoVO, Scheduler scheduler,
      JobKey jobKey, Trigger trigger) throws SchedulerException {

    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
    jobInfoVO.setJobName(jobKey.getName());
    jobInfoVO.setJobGroup(jobKey.getGroup());
    jobInfoVO.setJobClass(jobDetail.getJobClass().getName());
    jobInfoVO.setJobDescription(jobDetail.getDescription());
    JobInfoVO job = null;
    if (jobDetail.getJobDataMap().get("scheduleJob") instanceof JobInfoVO) {
      job = (JobInfoVO) jobDetail.getJobDataMap().get("scheduleJob");
    }
    if (job != null) {
      jobInfoVO.setJobId(job.getJobId());
      jobInfoVO.setJobDescription(job.getJobDescription());
    }

    Date startDate = trigger.getStartTime();
    Long startTime = (startDate != null) ? startDate.getTime() : null;
    jobInfoVO.setStartTime(startTime);

    Date endDate = trigger.getEndTime();
    Long endTime = (endDate != null) ? endDate.getTime() : null;
    jobInfoVO.setEndTime(endTime);

    jobInfoVO.setTriggerName(trigger.getKey().getName());
    jobInfoVO.setTriggerGroup(trigger.getKey().getGroup());
    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
    jobInfoVO.setTriggerState(triggerState.name());
    if (trigger instanceof CronTrigger) {
      CronTrigger cronTrigger = (CronTrigger) trigger;
      String cronExpression = cronTrigger.getCronExpression();
      jobInfoVO.setTimeZoneId(cronTrigger.getTimeZone().getID());
      jobInfoVO.setCronExpression(cronExpression);
    }
  }
}
