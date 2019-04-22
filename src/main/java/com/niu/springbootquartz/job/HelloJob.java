package com.niu.springbootquartz.job;

import com.niu.springbootquartz.config.AutowiringSpringBeanJobFactory;
import com.niu.springbootquartz.service.SampleService;
import java.time.LocalDateTime;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * HelloJob不是spring bean，@Autowired注解不会生效，
 * 如果想在QuartzJobBean中注入spring bean。 {@link AutowiringSpringBeanJobFactory}
 */
@DisallowConcurrentExecution
public class HelloJob extends QuartzJobBean {

  private static final Logger logger = LoggerFactory.getLogger(HelloJob.class);

  @Autowired
  private SampleService sampleService;

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

    String UUID = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    logger.info("Hello Job开始时间: " + LocalDateTime.now() + "-> " + UUID);
    sampleService.hello(UUID);
    logger.info("Hello Job结束时间: " + LocalDateTime.now() + "-> " + UUID);
  }
}  
