package com.niu.springbootquartz.job;

import com.niu.springbootquartz.mapper.JobConfigInfoMapper;
import com.niu.springbootquartz.model.JobConfigInfo;
import com.niu.springbootquartz.model.JobConfigInfoExample;
import java.util.List;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 根据数据库中的配置，在应用启动时，构建定时任务
 */
@Component
public class MyJobFactory implements InitializingBean {

  private static final Logger logger = LoggerFactory.getLogger(MyJobFactory.class);

  @Autowired
  private JobConfigInfoMapper jobConfigInfoMapper;

  @Autowired
  private Scheduler scheduler;

  @Override
  public void afterPropertiesSet() {

    logger.info("MyJobFactory->afterPropertiesSet->初始化数据库任务列表->开始");

    JobConfigInfoExample example = new JobConfigInfoExample();
    example.createCriteria().andUsedEqualTo(1);
    List<JobConfigInfo> records = jobConfigInfoMapper.selectByExample(example);
    for (JobConfigInfo record : records) {
      try {
        logger.info("MyJobFactory->afterPropertiesSet->动态构造任务开始【name:{}】【description:{}】",
            record.getJobName(), record.getDescription());
        JobDetail jobDetail = buildJobDetail(record);
        Trigger trigger = buildJobTrigger(record);
        scheduler.scheduleJob(jobDetail, trigger);
        logger.info("MyJobFactory->afterPropertiesSet->动态构造任务完成【name:{}】【description:{}】",
            record.getJobName(), record.getDescription());
      } catch (Exception ex) {
        logger.error("MyJobFactory->afterPropertiesSet->Error", ex);
      }
    }

    logger.info("MyJobFactory->afterPropertiesSet->初始化数据库任务列表->完成");
  }

  private JobDetail buildJobDetail(JobConfigInfo record) {

    JobDataMap jobDataMap = new JobDataMap();
    jobDataMap.put("name", record.getBeanName());
    return JobBuilder.newJob(TemplateJob.class)
        .withIdentity(record.getJobName(), record.getJobGroup() + "-jobs")
        .withDescription(record.getDescription())
        .usingJobData(jobDataMap)
        .storeDurably()
        .build();
  }

  private Trigger buildJobTrigger(JobConfigInfo record) {

    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(record.getCron())
        .withMisfireHandlingInstructionDoNothing();

    return TriggerBuilder.newTrigger()
        .withIdentity(record.getJobName(), record.getJobGroup() + "-triggers")
        .withDescription(record.getDescription())
        .startNow()
        .withSchedule(scheduleBuilder)
        .build();
  }
}
