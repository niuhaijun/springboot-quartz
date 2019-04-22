package com.niu.springbootquartz.config;

import java.io.IOException;
import java.util.Properties;
import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulerConfig {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  public JobFactory jobFactory() {

    AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
    jobFactory.setApplicationContext(applicationContext);
    return jobFactory;
  }

  @Bean
  public SchedulerFactoryBean schedulerFactoryBean() throws Exception {

    SchedulerFactoryBean factory = new SchedulerFactoryBean();
    factory.setJobFactory(jobFactory());
    factory.setQuartzProperties(quartzProperties());
    factory.afterPropertiesSet();
    return factory;
  }

  @Bean
  public Scheduler scheduler() throws Exception {

    Scheduler scheduler = schedulerFactoryBean().getScheduler();
    scheduler.setJobFactory(jobFactory());

    /**
     * 清空所有的信息（任务，触发器）
     */
    scheduler.clear();
    return scheduler;
  }

  @Bean
  public Properties quartzProperties() throws IOException {

    PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
    /**
     * 加载外置属性
     */
    propertiesFactoryBean.setLocations(new ClassPathResource("/quartz.properties"));
    propertiesFactoryBean.afterPropertiesSet();
    return propertiesFactoryBean.getObject();
  }

}
