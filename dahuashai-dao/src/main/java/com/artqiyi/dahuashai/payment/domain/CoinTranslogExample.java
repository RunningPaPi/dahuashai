package com.artqiyi.dahuashai.payment.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated("coin_translog")
public class CoinTranslogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CoinTranslogExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andCoinTranslogIdIsNull() {
            addCriterion("coin_translog_id is null");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdIsNotNull() {
            addCriterion("coin_translog_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdEqualTo(Integer value) {
            addCriterion("coin_translog_id =", value, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdNotEqualTo(Integer value) {
            addCriterion("coin_translog_id <>", value, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdGreaterThan(Integer value) {
            addCriterion("coin_translog_id >", value, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin_translog_id >=", value, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdLessThan(Integer value) {
            addCriterion("coin_translog_id <", value, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdLessThanOrEqualTo(Integer value) {
            addCriterion("coin_translog_id <=", value, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdIn(List<Integer> values) {
            addCriterion("coin_translog_id in", values, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdNotIn(List<Integer> values) {
            addCriterion("coin_translog_id not in", values, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdBetween(Integer value1, Integer value2) {
            addCriterion("coin_translog_id between", value1, value2, "coinTranslogId");
            return (Criteria) this;
        }

        public Criteria andCoinTranslogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coin_translog_id not between", value1, value2, "coinTranslogId");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNull() {
            addCriterion("trans_type is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("trans_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(String value) {
            addCriterion("trans_type =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(String value) {
            addCriterion("trans_type <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(String value) {
            addCriterion("trans_type >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trans_type >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(String value) {
            addCriterion("trans_type <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(String value) {
            addCriterion("trans_type <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLike(String value) {
            addCriterion("trans_type like", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotLike(String value) {
            addCriterion("trans_type not like", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<String> values) {
            addCriterion("trans_type in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<String> values) {
            addCriterion("trans_type not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(String value1, String value2) {
            addCriterion("trans_type between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(String value1, String value2) {
            addCriterion("trans_type not between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubIsNull() {
            addCriterion("trans_type_sub is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubIsNotNull() {
            addCriterion("trans_type_sub is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubEqualTo(String value) {
            addCriterion("trans_type_sub =", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubNotEqualTo(String value) {
            addCriterion("trans_type_sub <>", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubGreaterThan(String value) {
            addCriterion("trans_type_sub >", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubGreaterThanOrEqualTo(String value) {
            addCriterion("trans_type_sub >=", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubLessThan(String value) {
            addCriterion("trans_type_sub <", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubLessThanOrEqualTo(String value) {
            addCriterion("trans_type_sub <=", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubLike(String value) {
            addCriterion("trans_type_sub like", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubNotLike(String value) {
            addCriterion("trans_type_sub not like", value, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubIn(List<String> values) {
            addCriterion("trans_type_sub in", values, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubNotIn(List<String> values) {
            addCriterion("trans_type_sub not in", values, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubBetween(String value1, String value2) {
            addCriterion("trans_type_sub between", value1, value2, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransTypeSubNotBetween(String value1, String value2) {
            addCriterion("trans_type_sub not between", value1, value2, "transTypeSub");
            return (Criteria) this;
        }

        public Criteria andTransFlagIsNull() {
            addCriterion("trans_flag is null");
            return (Criteria) this;
        }

        public Criteria andTransFlagIsNotNull() {
            addCriterion("trans_flag is not null");
            return (Criteria) this;
        }

        public Criteria andTransFlagEqualTo(Integer value) {
            addCriterion("trans_flag =", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotEqualTo(Integer value) {
            addCriterion("trans_flag <>", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagGreaterThan(Integer value) {
            addCriterion("trans_flag >", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_flag >=", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagLessThan(Integer value) {
            addCriterion("trans_flag <", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagLessThanOrEqualTo(Integer value) {
            addCriterion("trans_flag <=", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagIn(List<Integer> values) {
            addCriterion("trans_flag in", values, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotIn(List<Integer> values) {
            addCriterion("trans_flag not in", values, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagBetween(Integer value1, Integer value2) {
            addCriterion("trans_flag between", value1, value2, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_flag not between", value1, value2, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransAmountIsNull() {
            addCriterion("trans_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransAmountIsNotNull() {
            addCriterion("trans_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransAmountEqualTo(Integer value) {
            addCriterion("trans_amount =", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountNotEqualTo(Integer value) {
            addCriterion("trans_amount <>", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountGreaterThan(Integer value) {
            addCriterion("trans_amount >", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_amount >=", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountLessThan(Integer value) {
            addCriterion("trans_amount <", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountLessThanOrEqualTo(Integer value) {
            addCriterion("trans_amount <=", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountIn(List<Integer> values) {
            addCriterion("trans_amount in", values, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountNotIn(List<Integer> values) {
            addCriterion("trans_amount not in", values, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountBetween(Integer value1, Integer value2) {
            addCriterion("trans_amount between", value1, value2, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_amount not between", value1, value2, "transAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Integer value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Integer value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Integer value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Integer value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Integer> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Integer> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Integer value1, Integer value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorIsNull() {
            addCriterion("award_percent_invitor is null");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorIsNotNull() {
            addCriterion("award_percent_invitor is not null");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorEqualTo(Integer value) {
            addCriterion("award_percent_invitor =", value, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorNotEqualTo(Integer value) {
            addCriterion("award_percent_invitor <>", value, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorGreaterThan(Integer value) {
            addCriterion("award_percent_invitor >", value, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorGreaterThanOrEqualTo(Integer value) {
            addCriterion("award_percent_invitor >=", value, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorLessThan(Integer value) {
            addCriterion("award_percent_invitor <", value, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorLessThanOrEqualTo(Integer value) {
            addCriterion("award_percent_invitor <=", value, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorIn(List<Integer> values) {
            addCriterion("award_percent_invitor in", values, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorNotIn(List<Integer> values) {
            addCriterion("award_percent_invitor not in", values, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorBetween(Integer value1, Integer value2) {
            addCriterion("award_percent_invitor between", value1, value2, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardPercentInvitorNotBetween(Integer value1, Integer value2) {
            addCriterion("award_percent_invitor not between", value1, value2, "awardPercentInvitor");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdIsNull() {
            addCriterion("award_from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdIsNotNull() {
            addCriterion("award_from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdEqualTo(Long value) {
            addCriterion("award_from_user_id =", value, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdNotEqualTo(Long value) {
            addCriterion("award_from_user_id <>", value, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdGreaterThan(Long value) {
            addCriterion("award_from_user_id >", value, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("award_from_user_id >=", value, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdLessThan(Long value) {
            addCriterion("award_from_user_id <", value, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdLessThanOrEqualTo(Long value) {
            addCriterion("award_from_user_id <=", value, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdIn(List<Long> values) {
            addCriterion("award_from_user_id in", values, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdNotIn(List<Long> values) {
            addCriterion("award_from_user_id not in", values, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdBetween(Long value1, Long value2) {
            addCriterion("award_from_user_id between", value1, value2, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andAwardFromUserIdNotBetween(Long value1, Long value2) {
            addCriterion("award_from_user_id not between", value1, value2, "awardFromUserId");
            return (Criteria) this;
        }

        public Criteria andTransTimeIsNull() {
            addCriterion("trans_time is null");
            return (Criteria) this;
        }

        public Criteria andTransTimeIsNotNull() {
            addCriterion("trans_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransTimeEqualTo(Date value) {
            addCriterion("trans_time =", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeNotEqualTo(Date value) {
            addCriterion("trans_time <>", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeGreaterThan(Date value) {
            addCriterion("trans_time >", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trans_time >=", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeLessThan(Date value) {
            addCriterion("trans_time <", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeLessThanOrEqualTo(Date value) {
            addCriterion("trans_time <=", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeIn(List<Date> values) {
            addCriterion("trans_time in", values, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeNotIn(List<Date> values) {
            addCriterion("trans_time not in", values, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeBetween(Date value1, Date value2) {
            addCriterion("trans_time between", value1, value2, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeNotBetween(Date value1, Date value2) {
            addCriterion("trans_time not between", value1, value2, "transTime");
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