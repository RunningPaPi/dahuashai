package com.artqiyi.dahuashai.game.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameBreakRecoverCostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameBreakRecoverCostExample() {
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

        public Criteria andGameModelIdIsNull() {
            addCriterion("game_model_id is null");
            return (Criteria) this;
        }

        public Criteria andGameModelIdIsNotNull() {
            addCriterion("game_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameModelIdEqualTo(Long value) {
            addCriterion("game_model_id =", value, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdNotEqualTo(Long value) {
            addCriterion("game_model_id <>", value, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdGreaterThan(Long value) {
            addCriterion("game_model_id >", value, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("game_model_id >=", value, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdLessThan(Long value) {
            addCriterion("game_model_id <", value, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdLessThanOrEqualTo(Long value) {
            addCriterion("game_model_id <=", value, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdIn(List<Long> values) {
            addCriterion("game_model_id in", values, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdNotIn(List<Long> values) {
            addCriterion("game_model_id not in", values, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdBetween(Long value1, Long value2) {
            addCriterion("game_model_id between", value1, value2, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelIdNotBetween(Long value1, Long value2) {
            addCriterion("game_model_id not between", value1, value2, "gameModelId");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyIsNull() {
            addCriterion("game_model_key is null");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyIsNotNull() {
            addCriterion("game_model_key is not null");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyEqualTo(String value) {
            addCriterion("game_model_key =", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyNotEqualTo(String value) {
            addCriterion("game_model_key <>", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyGreaterThan(String value) {
            addCriterion("game_model_key >", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyGreaterThanOrEqualTo(String value) {
            addCriterion("game_model_key >=", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyLessThan(String value) {
            addCriterion("game_model_key <", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyLessThanOrEqualTo(String value) {
            addCriterion("game_model_key <=", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyLike(String value) {
            addCriterion("game_model_key like", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyNotLike(String value) {
            addCriterion("game_model_key not like", value, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyIn(List<String> values) {
            addCriterion("game_model_key in", values, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyNotIn(List<String> values) {
            addCriterion("game_model_key not in", values, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyBetween(String value1, String value2) {
            addCriterion("game_model_key between", value1, value2, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameModelKeyNotBetween(String value1, String value2) {
            addCriterion("game_model_key not between", value1, value2, "gameModelKey");
            return (Criteria) this;
        }

        public Criteria andGameRoundIsNull() {
            addCriterion("game_round is null");
            return (Criteria) this;
        }

        public Criteria andGameRoundIsNotNull() {
            addCriterion("game_round is not null");
            return (Criteria) this;
        }

        public Criteria andGameRoundEqualTo(Integer value) {
            addCriterion("game_round =", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundNotEqualTo(Integer value) {
            addCriterion("game_round <>", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundGreaterThan(Integer value) {
            addCriterion("game_round >", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_round >=", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundLessThan(Integer value) {
            addCriterion("game_round <", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundLessThanOrEqualTo(Integer value) {
            addCriterion("game_round <=", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundIn(List<Integer> values) {
            addCriterion("game_round in", values, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundNotIn(List<Integer> values) {
            addCriterion("game_round not in", values, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundBetween(Integer value1, Integer value2) {
            addCriterion("game_round between", value1, value2, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("game_round not between", value1, value2, "gameRound");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNull() {
            addCriterion("cost_type is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNotNull() {
            addCriterion("cost_type is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeEqualTo(Short value) {
            addCriterion("cost_type =", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotEqualTo(Short value) {
            addCriterion("cost_type <>", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThan(Short value) {
            addCriterion("cost_type >", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("cost_type >=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThan(Short value) {
            addCriterion("cost_type <", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThanOrEqualTo(Short value) {
            addCriterion("cost_type <=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIn(List<Short> values) {
            addCriterion("cost_type in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotIn(List<Short> values) {
            addCriterion("cost_type not in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeBetween(Short value1, Short value2) {
            addCriterion("cost_type between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotBetween(Short value1, Short value2) {
            addCriterion("cost_type not between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostNumIsNull() {
            addCriterion("cost_num is null");
            return (Criteria) this;
        }

        public Criteria andCostNumIsNotNull() {
            addCriterion("cost_num is not null");
            return (Criteria) this;
        }

        public Criteria andCostNumEqualTo(Integer value) {
            addCriterion("cost_num =", value, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumNotEqualTo(Integer value) {
            addCriterion("cost_num <>", value, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumGreaterThan(Integer value) {
            addCriterion("cost_num >", value, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost_num >=", value, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumLessThan(Integer value) {
            addCriterion("cost_num <", value, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumLessThanOrEqualTo(Integer value) {
            addCriterion("cost_num <=", value, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumIn(List<Integer> values) {
            addCriterion("cost_num in", values, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumNotIn(List<Integer> values) {
            addCriterion("cost_num not in", values, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumBetween(Integer value1, Integer value2) {
            addCriterion("cost_num between", value1, value2, "costNum");
            return (Criteria) this;
        }

        public Criteria andCostNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cost_num not between", value1, value2, "costNum");
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

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("create_id not between", value1, value2, "createId");
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