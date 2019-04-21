package com.niu.springbootquartz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobConfigInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public JobConfigInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.sumCol = null;
        this.offset = null;
        this.limit = null;
    }

    public String getSumCol() {
        return this.sumCol;
    }

    public void setSumCol(String sumCol) {
        this.sumCol = sumCol;
    }

    public JobConfigInfoExample sumId() {
        this.sumCol="id";
        return this;
    }

    public JobConfigInfoExample sumBeanName() {
        this.sumCol="bean_name";
        return this;
    }

    public JobConfigInfoExample sumJobName() {
        this.sumCol="job_name";
        return this;
    }

    public JobConfigInfoExample sumJobGroup() {
        this.sumCol="job_group";
        return this;
    }

    public JobConfigInfoExample sumCron() {
        this.sumCol="cron";
        return this;
    }

    public JobConfigInfoExample sumDescription() {
        this.sumCol="description";
        return this;
    }

    public JobConfigInfoExample sumCreateTime() {
        this.sumCol="create_time";
        return this;
    }

    public JobConfigInfoExample sumUpdateTime() {
        this.sumCol="update_time";
        return this;
    }

    public JobConfigInfoExample sumUsed() {
        this.sumCol="used";
        return this;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public JobConfigInfoExample page(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBeanNameIsNull() {
            addCriterion("bean_name is null");
            return (Criteria) this;
        }

        public Criteria andBeanNameIsNotNull() {
            addCriterion("bean_name is not null");
            return (Criteria) this;
        }

        public Criteria andBeanNameEqualTo(String value) {
            addCriterion("bean_name =", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameNotEqualTo(String value) {
            addCriterion("bean_name <>", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameGreaterThan(String value) {
            addCriterion("bean_name >", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameGreaterThanOrEqualTo(String value) {
            addCriterion("bean_name >=", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameLessThan(String value) {
            addCriterion("bean_name <", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameLessThanOrEqualTo(String value) {
            addCriterion("bean_name <=", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameLike(String value) {
            addCriterion("bean_name like", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameNotLike(String value) {
            addCriterion("bean_name not like", value, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameIn(List<String> values) {
            addCriterion("bean_name in", values, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameNotIn(List<String> values) {
            addCriterion("bean_name not in", values, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameBetween(String value1, String value2) {
            addCriterion("bean_name between", value1, value2, "beanName");
            return (Criteria) this;
        }

        public Criteria andBeanNameNotBetween(String value1, String value2) {
            addCriterion("bean_name not between", value1, value2, "beanName");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("job_group is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("job_group is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(String value) {
            addCriterion("job_group =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(String value) {
            addCriterion("job_group <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(String value) {
            addCriterion("job_group >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("job_group >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(String value) {
            addCriterion("job_group <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(String value) {
            addCriterion("job_group <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLike(String value) {
            addCriterion("job_group like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotLike(String value) {
            addCriterion("job_group not like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<String> values) {
            addCriterion("job_group in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<String> values) {
            addCriterion("job_group not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(String value1, String value2) {
            addCriterion("job_group between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(String value1, String value2) {
            addCriterion("job_group not between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andCronIsNull() {
            addCriterion("cron is null");
            return (Criteria) this;
        }

        public Criteria andCronIsNotNull() {
            addCriterion("cron is not null");
            return (Criteria) this;
        }

        public Criteria andCronEqualTo(String value) {
            addCriterion("cron =", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotEqualTo(String value) {
            addCriterion("cron <>", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThan(String value) {
            addCriterion("cron >", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThanOrEqualTo(String value) {
            addCriterion("cron >=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThan(String value) {
            addCriterion("cron <", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThanOrEqualTo(String value) {
            addCriterion("cron <=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLike(String value) {
            addCriterion("cron like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotLike(String value) {
            addCriterion("cron not like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronIn(List<String> values) {
            addCriterion("cron in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotIn(List<String> values) {
            addCriterion("cron not in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronBetween(String value1, String value2) {
            addCriterion("cron between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotBetween(String value1, String value2) {
            addCriterion("cron not between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Integer value) {
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Integer value) {
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Integer value) {
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Integer value) {
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Integer value) {
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<Integer> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<Integer> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Integer value1, Integer value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("used not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria addConditionSql(String conditionSql) {
            addCriterion(conditionSql);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}