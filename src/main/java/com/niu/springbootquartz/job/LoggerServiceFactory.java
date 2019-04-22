/**
 *
 */
package com.niu.springbootquartz.job;

import com.niu.springbootquartz.service.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 根据bean的名称获取spring bean
 */
@Service
public class LoggerServiceFactory implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(LoggerServiceFactory.class);

  private static volatile ApplicationContext context;

  public static LoggerService getSummaryService(String name) {

    try {
      return context.getBean(name, LoggerService.class);
    } catch (Exception ex) {
      logger.error("LoggerServiceFactory#getSummaryService，从上下文ApplicationContext中获取bean失败", ex);
      return null;
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
      throws BeansException {

    context = applicationContext;
  }
}
