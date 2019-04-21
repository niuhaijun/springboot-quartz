package com.niu.springbootquartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niu.springbootquartz.mapper")
public class SpringbootQuartzApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringbootQuartzApplication.class, args);
  }

}
