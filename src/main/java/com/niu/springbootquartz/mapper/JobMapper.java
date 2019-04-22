package com.niu.springbootquartz.mapper;

import com.niu.springbootquartz.controller.param.JobInfoVO;
import java.util.List;

public interface JobMapper {

  List<JobInfoVO> getJobAndTriggerDetails();
}
