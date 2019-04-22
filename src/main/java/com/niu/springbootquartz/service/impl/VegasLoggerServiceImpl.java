package com.niu.springbootquartz.service.impl;

import com.niu.springbootquartz.service.LoggerService;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("vegas")
public class VegasLoggerServiceImpl implements LoggerService {

  private static final Logger logger = LoggerFactory.getLogger(VegasLoggerServiceImpl.class);

  @Override
  public boolean printLogger() {

    logger.info("VegasLoggerServiceImpl#printLogger 开始时间: " + LocalDateTime.now());
    try {
      Thread.sleep(46 * 1000L);
    } catch (InterruptedException e) {
      logger.info("VegasLoggerServiceImpl#printLogger 运行期间发生了中断异常", e);
    }
    logger.info("VegasLoggerServiceImpl#printLogger 结束时间: " + LocalDateTime.now());

    return true;
  }

}
