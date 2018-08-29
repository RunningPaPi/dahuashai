package com.artqiyi.dahuashai.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemDistributionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemDistributionExample() {
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

        public Criteria andDistrIdIsNull() {
            addCriterion("distr_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrIdIsNotNull() {
            addCriterion("distr_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrIdEqualTo(Integer value) {
            addCriterion("distr_id =", value, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdNotEqualTo(Integer value) {
            addCriterion("distr_id <>", value, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdGreaterThan(Integer value) {
            addCriterion("distr_id >", value, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("distr_id >=", value, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdLessThan(Integer value) {
            addCriterion("distr_id <", value, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdLessThanOrEqualTo(Integer value) {
            addCriterion("distr_id <=", value, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdIn(List<Integer> values) {
            addCriterion("distr_id in", values, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdNotIn(List<Integer> values) {
            addCriterion("distr_id not in", values, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdBetween(Integer value1, Integer value2) {
            addCriterion("distr_id between", value1, value2, "distrId");
            return (Criteria) this;
        }

        public Criteria andDistrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("distr_id not between", value1, value2, "distrId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Short value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Short value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Short value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Short value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Short value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Short> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Short> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Short value1, Short value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Short value1, Short value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdIsNull() {
            addCriterion("app_store_id is null");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdIsNotNull() {
            addCriterion("app_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdEqualTo(Short value) {
            addCriterion("app_store_id =", value, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdNotEqualTo(Short value) {
            addCriterion("app_store_id <>", value, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdGreaterThan(Short value) {
            addCriterion("app_store_id >", value, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdGreaterThanOrEqualTo(Short value) {
            addCriterion("app_store_id >=", value, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdLessThan(Short value) {
            addCriterion("app_store_id <", value, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdLessThanOrEqualTo(Short value) {
            addCriterion("app_store_id <=", value, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdIn(List<Short> values) {
            addCriterion("app_store_id in", values, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdNotIn(List<Short> values) {
            addCriterion("app_store_id not in", values, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdBetween(Short value1, Short value2) {
            addCriterion("app_store_id between", value1, value2, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andAppStoreIdNotBetween(Short value1, Short value2) {
            addCriterion("app_store_id not between", value1, value2, "appStoreId");
            return (Criteria) this;
        }

        public Criteria andDistrStateIsNull() {
            addCriterion("distr_state is null");
            return (Criteria) this;
        }

        public Criteria andDistrStateIsNotNull() {
            addCriterion("distr_state is not null");
            return (Criteria) this;
        }

        public Criteria andDistrStateEqualTo(Short value) {
            addCriterion("distr_state =", value, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateNotEqualTo(Short value) {
            addCriterion("distr_state <>", value, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateGreaterThan(Short value) {
            addCriterion("distr_state >", value, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateGreaterThanOrEqualTo(Short value) {
            addCriterion("distr_state >=", value, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateLessThan(Short value) {
            addCriterion("distr_state <", value, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateLessThanOrEqualTo(Short value) {
            addCriterion("distr_state <=", value, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateIn(List<Short> values) {
            addCriterion("distr_state in", values, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateNotIn(List<Short> values) {
            addCriterion("distr_state not in", values, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateBetween(Short value1, Short value2) {
            addCriterion("distr_state between", value1, value2, "distrState");
            return (Criteria) this;
        }

        public Criteria andDistrStateNotBetween(Short value1, Short value2) {
            addCriterion("distr_state not between", value1, value2, "distrState");
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