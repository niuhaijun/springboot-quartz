package com.niu.springbootquartz.mapper;

import com.niu.springbootquartz.model.JobConfigInfo;
import com.niu.springbootquartz.model.JobConfigInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface JobConfigInfoMapper {
    int countByExample(JobConfigInfoExample example);

    int deleteByExample(JobConfigInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JobConfigInfo record);

    int insertSelective(JobConfigInfo record);

    List<JobConfigInfo> selectByExampleWithRowbounds(JobConfigInfoExample example, RowBounds rowBounds);

    List<JobConfigInfo> selectByExample(JobConfigInfoExample example);

    JobConfigInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JobConfigInfo record, @Param("example") JobConfigInfoExample example);

    int updateByExample(@Param("record") JobConfigInfo record, @Param("example") JobConfigInfoExample example);

    int updateByPrimaryKeySelective(JobConfigInfo record);

    int updateByPrimaryKey(JobConfigInfo record);

    Long sumByExample(JobConfigInfoExample example);

    void batchInsert(@Param("items") List<JobConfigInfo> items);
}