package com.niu.springbootquartz.controller.param;

import java.io.Serializable;
import lombok.Data;

@Data
public class ScheduleJob implements Serializable {

  private static final long serialVersionUID = -8666047057613317299L;

  private String jobId;

  private String jobName;

  private String jobGroup;

  private String jobStatus;

  private String cronExpression;

  private String desc;

  private String interfaceName;
}
