package com.niu.springbootquartz.service;

import com.github.pagehelper.PageInfo;
import com.niu.springbootquartz.controller.param.JobInfoVO;
import java.util.List;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;

/**
 * @Author: niuhaijun
 * @Date: 2019-03-05 13:59
 * @Version 1.0
 */
public interface ScheduleJobService {

  /**
   * 获取所有job
   */
  List<JobInfoVO> getAllJobList() throws SchedulerException;

  /**
   * 获取所有正在运行的job
   */
  List<JobInfoVO> getRunningJobList() throws SchedulerException;

  /**
   * 添加任务
   */
  void addJob(JobInfoVO scheduleJob) throws Exception;

  /**
   * 更新cron表达式
   */
  void updateJobCronExpression(JobInfoVO scheduleJob) throws SchedulerException;

  /**
   * 暂停job
   */
  void pauseJob(JobInfoVO scheduleJob) throws SchedulerException;

  /**
   * 重运行
   */
  void resumeJob(JobInfoVO scheduleJob) throws SchedulerException;

  /**
   * 删除job
   */
  void deleteJob(JobInfoVO scheduleJob) throws SchedulerException;

  /**
   * 立即运行job
   */
  void runJobOnce(JobInfoVO scheduleJob) throws SchedulerException;

  /**
   * 获取调度信息
   */
  SchedulerMetaData getMetaData() throws SchedulerException;

  /**
   * 分页查询job和触发器信息
   */
  PageInfo<JobInfoVO> getJobAndTriggerDetails(int pageNum, int pageSize);
}
