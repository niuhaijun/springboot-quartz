package com.niu.springbootquartz.model;

import java.io.Serializable;
import java.util.Date;

public class JobConfigInfo implements Serializable {
    private Long id;

    private String beanName;

    private String jobName;

    private String jobGroup;

    private String cron;

    private String description;

    private Date createTime;

    private Date updateTime;

    private Integer used;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public JobConfigInfo(Long id, String beanName, String jobName, String jobGroup, String cron, String description, Date createTime, Date updateTime, Integer used) {
        this.id = id;
        this.beanName = beanName;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.cron = cron;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.used = used;
    }

    public JobConfigInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", beanName=").append(beanName);
        sb.append(", jobName=").append(jobName);
        sb.append(", jobGroup=").append(jobGroup);
        sb.append(", cron=").append(cron);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", used=").append(used);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}