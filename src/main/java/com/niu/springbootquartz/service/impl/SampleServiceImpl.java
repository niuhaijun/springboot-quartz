package com.niu.springbootquartz.service.impl;

import com.niu.springbootquartz.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: niuhaijun
 * @Date: 2019-03-05 14:02
 * @Version 1.0
 */
@Service
public class SampleServiceImpl implements SampleService {

  private static final Logger LOG = LoggerFactory.getLogger(SampleServiceImpl.class);

  @Override
  public void hello(String content) {

    try {
      Thread.sleep(5 * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    LOG.info(content);
  }
}
