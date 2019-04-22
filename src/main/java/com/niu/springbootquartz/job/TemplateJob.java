package com.niu.springbootquartz.job;


import com.niu.springbootquartz.service.LoggerService;
import java.time.LocalDate;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 模板job，根据不同的bean名称，运行不同的方法
 */
@DisallowConcurrentExecution
@Component
public class TemplateJob extends QuartzJobBean {

  private static final Logger logger = LoggerFactory.getLogger(TemplateJob.class);

  @Override
  protected void executeInternal(JobExecutionContext context) {

    String date = LocalDate.now().toString();
    try {
      JobDataMap jobDataMap = context.getMergedJobDataMap();
      String name = jobDataMap.getString("name");
//      logger.info("TemplateJob->executeInternal->开始执行定时任务【name:{}】【date:{}】",
//          name, date);
      LoggerService loggerService = LoggerServiceFactory.getSummaryService(name);
      boolean flag = loggerService.printLogger();
//      logger.info("TemplateJob->executeInternal->执行完成定时任务【name:{}】【date:{}】[flag:{}】",
//          name, date, flag);
    } catch (Exception ex) {
      logger.error("TemplateJob->executeInternal->Error", ex);
    }
  }
}
