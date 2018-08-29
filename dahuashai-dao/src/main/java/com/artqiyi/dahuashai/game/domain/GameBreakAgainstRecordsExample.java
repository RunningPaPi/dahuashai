package com.artqiyi.dahuashai.game.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameBreakAgainstRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameBreakAgainstRecordsExample() {
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

        public Criteria andGameRoundIsNull() {
            addCriterion("game_round is null");
            return (Criteria) this;
        }

        public Criteria andGameRoundIsNotNull() {
            addCriterion("game_round is not null");
            return (Criteria) this;
        }

        public Criteria andGameRoundEqualTo(Short value) {
            addCriterion("game_round =", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundNotEqualTo(Short value) {
            addCriterion("game_round <>", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundGreaterThan(Short value) {
            addCriterion("game_round >", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundGreaterThanOrEqualTo(Short value) {
            addCriterion("game_round >=", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundLessThan(Short value) {
            addCriterion("game_round <", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundLessThanOrEqualTo(Short value) {
            addCriterion("game_round <=", value, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundIn(List<Short> values) {
            addCriterion("game_round in", values, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundNotIn(List<Short> values) {
            addCriterion("game_round not in", values, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundBetween(Short value1, Short value2) {
            addCriterion("game_round between", value1, value2, "gameRound");
            return (Criteria) this;
        }

        public Criteria andGameRoundNotBetween(Short value1, Short value2) {
            addCriterion("game_round not between", value1, value2, "gameRound");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
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

        public Criteria andIsWinIsNull() {
            addCriterion("is_win is null");
            return (Criteria) this;
        }

        public Criteria andIsWinIsNotNull() {
            addCriterion("is_win is not null");
            return (Criteria) this;
        }

        public Criteria andIsWinEqualTo(Boolean value) {
            addCriterion("is_win =", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotEqualTo(Boolean value) {
            addCriterion("is_win <>", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinGreaterThan(Boolean value) {
            addCriterion("is_win >", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_win >=", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinLessThan(Boolean value) {
            addCriterion("is_win <", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinLessThanOrEqualTo(Boolean value) {
            addCriterion("is_win <=", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinIn(List<Boolean> values) {
            addCriterion("is_win in", values, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotIn(List<Boolean> values) {
            addCriterion("is_win not in", values, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinBetween(Boolean value1, Boolean value2) {
            addCriterion("is_win between", value1, value2, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_win not between", value1, value2, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsGameEndIsNull() {
            addCriterion("is_game_end is null");
            return (Criteria) this;
        }

        public Criteria andIsGameEndIsNotNull() {
            addCriterion("is_game_end is not null");
            return (Criteria) this;
        }

        public Criteria andIsGameEndEqualTo(Boolean value) {
            addCriterion("is_game_end =", value, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndNotEqualTo(Boolean value) {
            addCriterion("is_game_end <>", value, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndGreaterThan(Boolean value) {
            addCriterion("is_game_end >", value, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_game_end >=", value, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndLessThan(Boolean value) {
            addCriterion("is_game_end <", value, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndLessThanOrEqualTo(Boolean value) {
            addCriterion("is_game_end <=", value, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndIn(List<Boolean> values) {
            addCriterion("is_game_end in", values, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndNotIn(List<Boolean> values) {
            addCriterion("is_game_end not in", values, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndBetween(Boolean value1, Boolean value2) {
            addCriterion("is_game_end between", value1, value2, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andIsGameEndNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_game_end not between", value1, value2, "isGameEnd");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdIsNull() {
            addCriterion("against_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdIsNotNull() {
            addCriterion("against_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdEqualTo(Long value) {
            addCriterion("against_user_id =", value, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdNotEqualTo(Long value) {
            addCriterion("against_user_id <>", value, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdGreaterThan(Long value) {
            addCriterion("against_user_id >", value, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("against_user_id >=", value, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdLessThan(Long value) {
            addCriterion("against_user_id <", value, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdLessThanOrEqualTo(Long value) {
            addCriterion("against_user_id <=", value, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdIn(List<Long> values) {
            addCriterion("against_user_id in", values, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdNotIn(List<Long> values) {
            addCriterion("against_user_id not in", values, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdBetween(Long value1, Long value2) {
            addCriterion("against_user_id between", value1, value2, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstUserIdNotBetween(Long value1, Long value2) {
            addCriterion("against_user_id not between", value1, value2, "againstUserId");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameIsNull() {
            addCriterion("against_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameIsNotNull() {
            addCriterion("against_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameEqualTo(String value) {
            addCriterion("against_nick_name =", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameNotEqualTo(String value) {
            addCriterion("against_nick_name <>", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameGreaterThan(String value) {
            addCriterion("against_nick_name >", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("against_nick_name >=", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameLessThan(String value) {
            addCriterion("against_nick_name <", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameLessThanOrEqualTo(String value) {
            addCriterion("against_nick_name <=", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameLike(String value) {
            addCriterion("against_nick_name like", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameNotLike(String value) {
            addCriterion("against_nick_name not like", value, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameIn(List<String> values) {
            addCriterion("against_nick_name in", values, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameNotIn(List<String> values) {
            addCriterion("against_nick_name not in", values, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameBetween(String value1, String value2) {
            addCriterion("against_nick_name between", value1, value2, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstNickNameNotBetween(String value1, String value2) {
            addCriterion("against_nick_name not between", value1, value2, "againstNickName");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlIsNull() {
            addCriterion("against_head_url is null");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlIsNotNull() {
            addCriterion("against_head_url is not null");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlEqualTo(String value) {
            addCriterion("against_head_url =", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlNotEqualTo(String value) {
            addCriterion("against_head_url <>", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlGreaterThan(String value) {
            addCriterion("against_head_url >", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("against_head_url >=", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlLessThan(String value) {
            addCriterion("against_head_url <", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("against_head_url <=", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlLike(String value) {
            addCriterion("against_head_url like", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlNotLike(String value) {
            addCriterion("against_head_url not like", value, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlIn(List<String> values) {
            addCriterion("against_head_url in", values, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlNotIn(List<String> values) {
            addCriterion("against_head_url not in", values, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlBetween(String value1, String value2) {
            addCriterion("against_head_url between", value1, value2, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstHeadUrlNotBetween(String value1, String value2) {
            addCriterion("against_head_url not between", value1, value2, "againstHeadUrl");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreIsNull() {
            addCriterion("against_score is null");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreIsNotNull() {
            addCriterion("against_score is not null");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreEqualTo(Integer value) {
            addCriterion("against_score =", value, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreNotEqualTo(Integer value) {
            addCriterion("against_score <>", value, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreGreaterThan(Integer value) {
            addCriterion("against_score >", value, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("against_score >=", value, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreLessThan(Integer value) {
            addCriterion("against_score <", value, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreLessThanOrEqualTo(Integer value) {
            addCriterion("against_score <=", value, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreIn(List<Integer> values) {
            addCriterion("against_score in", values, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreNotIn(List<Integer> values) {
            addCriterion("against_score not in", values, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreBetween(Integer value1, Integer value2) {
            addCriterion("against_score between", value1, value2, "againstScore");
            return (Criteria) this;
        }

        public Criteria andAgainstScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("against_score not between", value1, value2, "againstScore");
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