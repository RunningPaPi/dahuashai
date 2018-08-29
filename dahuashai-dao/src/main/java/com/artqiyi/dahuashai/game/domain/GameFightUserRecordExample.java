package com.artqiyi.dahuashai.game.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameFightUserRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameFightUserRecordExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andHeadUrlIsNull() {
            addCriterion("head_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("head_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("head_url =", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("head_url <>", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("head_url >", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_url >=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("head_url <", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("head_url <=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("head_url like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("head_url not like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIn(List<String> values) {
            addCriterion("head_url in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotIn(List<String> values) {
            addCriterion("head_url not in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("head_url between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("head_url not between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andPlayTimesIsNull() {
            addCriterion("play_times is null");
            return (Criteria) this;
        }

        public Criteria andPlayTimesIsNotNull() {
            addCriterion("play_times is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTimesEqualTo(Integer value) {
            addCriterion("play_times =", value, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesNotEqualTo(Integer value) {
            addCriterion("play_times <>", value, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesGreaterThan(Integer value) {
            addCriterion("play_times >", value, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_times >=", value, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesLessThan(Integer value) {
            addCriterion("play_times <", value, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesLessThanOrEqualTo(Integer value) {
            addCriterion("play_times <=", value, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesIn(List<Integer> values) {
            addCriterion("play_times in", values, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesNotIn(List<Integer> values) {
            addCriterion("play_times not in", values, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesBetween(Integer value1, Integer value2) {
            addCriterion("play_times between", value1, value2, "playTimes");
            return (Criteria) this;
        }

        public Criteria andPlayTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("play_times not between", value1, value2, "playTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesIsNull() {
            addCriterion("win_times is null");
            return (Criteria) this;
        }

        public Criteria andWinTimesIsNotNull() {
            addCriterion("win_times is not null");
            return (Criteria) this;
        }

        public Criteria andWinTimesEqualTo(Integer value) {
            addCriterion("win_times =", value, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesNotEqualTo(Integer value) {
            addCriterion("win_times <>", value, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesGreaterThan(Integer value) {
            addCriterion("win_times >", value, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("win_times >=", value, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesLessThan(Integer value) {
            addCriterion("win_times <", value, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesLessThanOrEqualTo(Integer value) {
            addCriterion("win_times <=", value, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesIn(List<Integer> values) {
            addCriterion("win_times in", values, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesNotIn(List<Integer> values) {
            addCriterion("win_times not in", values, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesBetween(Integer value1, Integer value2) {
            addCriterion("win_times between", value1, value2, "winTimes");
            return (Criteria) this;
        }

        public Criteria andWinTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("win_times not between", value1, value2, "winTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesIsNull() {
            addCriterion("invite_times is null");
            return (Criteria) this;
        }

        public Criteria andInviteTimesIsNotNull() {
            addCriterion("invite_times is not null");
            return (Criteria) this;
        }

        public Criteria andInviteTimesEqualTo(Integer value) {
            addCriterion("invite_times =", value, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesNotEqualTo(Integer value) {
            addCriterion("invite_times <>", value, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesGreaterThan(Integer value) {
            addCriterion("invite_times >", value, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_times >=", value, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesLessThan(Integer value) {
            addCriterion("invite_times <", value, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("invite_times <=", value, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesIn(List<Integer> values) {
            addCriterion("invite_times in", values, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesNotIn(List<Integer> values) {
            addCriterion("invite_times not in", values, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesBetween(Integer value1, Integer value2) {
            addCriterion("invite_times between", value1, value2, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andInviteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_times not between", value1, value2, "inviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesIsNull() {
            addCriterion("success_invite_times is null");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesIsNotNull() {
            addCriterion("success_invite_times is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesEqualTo(Integer value) {
            addCriterion("success_invite_times =", value, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesNotEqualTo(Integer value) {
            addCriterion("success_invite_times <>", value, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesGreaterThan(Integer value) {
            addCriterion("success_invite_times >", value, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("success_invite_times >=", value, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesLessThan(Integer value) {
            addCriterion("success_invite_times <", value, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("success_invite_times <=", value, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesIn(List<Integer> values) {
            addCriterion("success_invite_times in", values, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesNotIn(List<Integer> values) {
            addCriterion("success_invite_times not in", values, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesBetween(Integer value1, Integer value2) {
            addCriterion("success_invite_times between", value1, value2, "successInviteTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessInviteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("success_invite_times not between", value1, value2, "successInviteTimes");
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