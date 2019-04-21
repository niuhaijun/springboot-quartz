package com.niu.springbootquartz.config;

import java.util.Properties;
import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulerConfig implements ApplicationContextAware {

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
    return scheduler;
  }

  @Bean
  public Properties quartzProperties() {

    YamlPropertiesFactoryBean propertiesFactoryBean = new YamlPropertiesFactoryBean();
    propertiesFactoryBean.setResources(new ClassPathResource("/quartz.yml"));
    propertiesFactoryBean.afterPropertiesSet();
    return propertiesFactoryBean.getObject();
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    this.applicationContext = applicationContext;
  }
}
