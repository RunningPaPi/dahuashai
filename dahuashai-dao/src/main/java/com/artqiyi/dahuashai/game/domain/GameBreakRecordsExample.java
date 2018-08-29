package com.artqiyi.dahuashai.game.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameBreakRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameBreakRecordsExample() {
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

        public Criteria andGameNoIsNull() {
            addCriterion("game_no is null");
            return (Criteria) this;
        }

        public Criteria andGameNoIsNotNull() {
            addCriterion("game_no is not null");
            return (Criteria) this;
        }

        public Criteria andGameNoEqualTo(String value) {
            addCriterion("game_no =", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoNotEqualTo(String value) {
            addCriterion("game_no <>", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoGreaterThan(String value) {
            addCriterion("game_no >", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoGreaterThanOrEqualTo(String value) {
            addCriterion("game_no >=", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoLessThan(String value) {
            addCriterion("game_no <", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoLessThanOrEqualTo(String value) {
            addCriterion("game_no <=", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoLike(String value) {
            addCriterion("game_no like", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoNotLike(String value) {
            addCriterion("game_no not like", value, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoIn(List<String> values) {
            addCriterion("game_no in", values, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoNotIn(List<String> values) {
            addCriterion("game_no not in", values, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoBetween(String value1, String value2) {
            addCriterion("game_no between", value1, value2, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameNoNotBetween(String value1, String value2) {
            addCriterion("game_no not between", value1, value2, "gameNo");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameIsNull() {
            addCriterion("game_filed_name is null");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameIsNotNull() {
            addCriterion("game_filed_name is not null");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameEqualTo(String value) {
            addCriterion("game_filed_name =", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameNotEqualTo(String value) {
            addCriterion("game_filed_name <>", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameGreaterThan(String value) {
            addCriterion("game_filed_name >", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameGreaterThanOrEqualTo(String value) {
            addCriterion("game_filed_name >=", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameLessThan(String value) {
            addCriterion("game_filed_name <", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameLessThanOrEqualTo(String value) {
            addCriterion("game_filed_name <=", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameLike(String value) {
            addCriterion("game_filed_name like", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameNotLike(String value) {
            addCriterion("game_filed_name not like", value, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameIn(List<String> values) {
            addCriterion("game_filed_name in", values, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameNotIn(List<String> values) {
            addCriterion("game_filed_name not in", values, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameBetween(String value1, String value2) {
            addCriterion("game_filed_name between", value1, value2, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andGameFiledNameNotBetween(String value1, String value2) {
            addCriterion("game_filed_name not between", value1, value2, "gameFiledName");
            return (Criteria) this;
        }

        public Criteria andTotalRoundIsNull() {
            addCriterion("total_round is null");
            return (Criteria) this;
        }

        public Criteria andTotalRoundIsNotNull() {
            addCriterion("total_round is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRoundEqualTo(Integer value) {
            addCriterion("total_round =", value, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundNotEqualTo(Integer value) {
            addCriterion("total_round <>", value, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundGreaterThan(Integer value) {
            addCriterion("total_round >", value, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_round >=", value, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundLessThan(Integer value) {
            addCriterion("total_round <", value, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundLessThanOrEqualTo(Integer value) {
            addCriterion("total_round <=", value, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundIn(List<Integer> values) {
            addCriterion("total_round in", values, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundNotIn(List<Integer> values) {
            addCriterion("total_round not in", values, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundBetween(Integer value1, Integer value2) {
            addCriterion("total_round between", value1, value2, "totalRound");
            return (Criteria) this;
        }

        public Criteria andTotalRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("total_round not between", value1, value2, "totalRound");
            return (Criteria) this;
        }

        public Criteria andContestNumIsNull() {
            addCriterion("contest_num is null");
            return (Criteria) this;
        }

        public Criteria andContestNumIsNotNull() {
            addCriterion("contest_num is not null");
            return (Criteria) this;
        }

        public Criteria andContestNumEqualTo(Integer value) {
            addCriterion("contest_num =", value, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumNotEqualTo(Integer value) {
            addCriterion("contest_num <>", value, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumGreaterThan(Integer value) {
            addCriterion("contest_num >", value, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("contest_num >=", value, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumLessThan(Integer value) {
            addCriterion("contest_num <", value, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumLessThanOrEqualTo(Integer value) {
            addCriterion("contest_num <=", value, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumIn(List<Integer> values) {
            addCriterion("contest_num in", values, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumNotIn(List<Integer> values) {
            addCriterion("contest_num not in", values, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumBetween(Integer value1, Integer value2) {
            addCriterion("contest_num between", value1, value2, "contestNum");
            return (Criteria) this;
        }

        public Criteria andContestNumNotBetween(Integer value1, Integer value2) {
            addCriterion("contest_num not between", value1, value2, "contestNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumIsNull() {
            addCriterion("pass_through_num is null");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumIsNotNull() {
            addCriterion("pass_through_num is not null");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumEqualTo(Integer value) {
            addCriterion("pass_through_num =", value, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumNotEqualTo(Integer value) {
            addCriterion("pass_through_num <>", value, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumGreaterThan(Integer value) {
            addCriterion("pass_through_num >", value, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pass_through_num >=", value, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumLessThan(Integer value) {
            addCriterion("pass_through_num <", value, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumLessThanOrEqualTo(Integer value) {
            addCriterion("pass_through_num <=", value, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumIn(List<Integer> values) {
            addCriterion("pass_through_num in", values, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumNotIn(List<Integer> values) {
            addCriterion("pass_through_num not in", values, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumBetween(Integer value1, Integer value2) {
            addCriterion("pass_through_num between", value1, value2, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPassThroughNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pass_through_num not between", value1, value2, "passThroughNum");
            return (Criteria) this;
        }

        public Criteria andPerAwardIsNull() {
            addCriterion("per_award is null");
            return (Criteria) this;
        }

        public Criteria andPerAwardIsNotNull() {
            addCriterion("per_award is not null");
            return (Criteria) this;
        }

        public Criteria andPerAwardEqualTo(Integer value) {
            addCriterion("per_award =", value, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardNotEqualTo(Integer value) {
            addCriterion("per_award <>", value, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardGreaterThan(Integer value) {
            addCriterion("per_award >", value, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardGreaterThanOrEqualTo(Integer value) {
            addCriterion("per_award >=", value, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardLessThan(Integer value) {
            addCriterion("per_award <", value, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardLessThanOrEqualTo(Integer value) {
            addCriterion("per_award <=", value, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardIn(List<Integer> values) {
            addCriterion("per_award in", values, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardNotIn(List<Integer> values) {
            addCriterion("per_award not in", values, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardBetween(Integer value1, Integer value2) {
            addCriterion("per_award between", value1, value2, "perAward");
            return (Criteria) this;
        }

        public Criteria andPerAwardNotBetween(Integer value1, Integer value2) {
            addCriterion("per_award not between", value1, value2, "perAward");
            return (Criteria) this;
        }

        public Criteria andGameStatusIsNull() {
            addCriterion("game_status is null");
            return (Criteria) this;
        }

        public Criteria andGameStatusIsNotNull() {
            addCriterion("game_status is not null");
            return (Criteria) this;
        }

        public Criteria andGameStatusEqualTo(Short value) {
            addCriterion("game_status =", value, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusNotEqualTo(Short value) {
            addCriterion("game_status <>", value, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusGreaterThan(Short value) {
            addCriterion("game_status >", value, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("game_status >=", value, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusLessThan(Short value) {
            addCriterion("game_status <", value, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusLessThanOrEqualTo(Short value) {
            addCriterion("game_status <=", value, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusIn(List<Short> values) {
            addCriterion("game_status in", values, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusNotIn(List<Short> values) {
            addCriterion("game_status not in", values, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusBetween(Short value1, Short value2) {
            addCriterion("game_status between", value1, value2, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andGameStatusNotBetween(Short value1, Short value2) {
            addCriterion("game_status not between", value1, value2, "gameStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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