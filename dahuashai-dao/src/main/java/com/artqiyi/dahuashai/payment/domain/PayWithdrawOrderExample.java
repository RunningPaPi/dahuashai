package com.artqiyi.dahuashai.payment.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated("pay_withdraw_order")
public class PayWithdrawOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PayWithdrawOrderExample() {
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

        public Criteria andWithdrawOrderIdIsNull() {
            addCriterion("withdraw_order_id is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdIsNotNull() {
            addCriterion("withdraw_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdEqualTo(String value) {
            addCriterion("withdraw_order_id =", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdNotEqualTo(String value) {
            addCriterion("withdraw_order_id <>", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdGreaterThan(String value) {
            addCriterion("withdraw_order_id >", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_order_id >=", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdLessThan(String value) {
            addCriterion("withdraw_order_id <", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdLessThanOrEqualTo(String value) {
            addCriterion("withdraw_order_id <=", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdLike(String value) {
            addCriterion("withdraw_order_id like", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdNotLike(String value) {
            addCriterion("withdraw_order_id not like", value, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdIn(List<String> values) {
            addCriterion("withdraw_order_id in", values, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdNotIn(List<String> values) {
            addCriterion("withdraw_order_id not in", values, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdBetween(String value1, String value2) {
            addCriterion("withdraw_order_id between", value1, value2, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderIdNotBetween(String value1, String value2) {
            addCriterion("withdraw_order_id not between", value1, value2, "withdrawOrderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumIsNull() {
            addCriterion("withdraw_order_num is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumIsNotNull() {
            addCriterion("withdraw_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumEqualTo(String value) {
            addCriterion("withdraw_order_num =", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumNotEqualTo(String value) {
            addCriterion("withdraw_order_num <>", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumGreaterThan(String value) {
            addCriterion("withdraw_order_num >", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_order_num >=", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumLessThan(String value) {
            addCriterion("withdraw_order_num <", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumLessThanOrEqualTo(String value) {
            addCriterion("withdraw_order_num <=", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumLike(String value) {
            addCriterion("withdraw_order_num like", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumNotLike(String value) {
            addCriterion("withdraw_order_num not like", value, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumIn(List<String> values) {
            addCriterion("withdraw_order_num in", values, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumNotIn(List<String> values) {
            addCriterion("withdraw_order_num not in", values, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumBetween(String value1, String value2) {
            addCriterion("withdraw_order_num between", value1, value2, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNumNotBetween(String value1, String value2) {
            addCriterion("withdraw_order_num not between", value1, value2, "withdrawOrderNum");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
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

        public Criteria andWithdrawCoinAmountIsNull() {
            addCriterion("withdraw_coin_amount is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountIsNotNull() {
            addCriterion("withdraw_coin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountEqualTo(Long value) {
            addCriterion("withdraw_coin_amount =", value, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountNotEqualTo(Long value) {
            addCriterion("withdraw_coin_amount <>", value, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountGreaterThan(Long value) {
            addCriterion("withdraw_coin_amount >", value, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("withdraw_coin_amount >=", value, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountLessThan(Long value) {
            addCriterion("withdraw_coin_amount <", value, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountLessThanOrEqualTo(Long value) {
            addCriterion("withdraw_coin_amount <=", value, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountIn(List<Long> values) {
            addCriterion("withdraw_coin_amount in", values, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountNotIn(List<Long> values) {
            addCriterion("withdraw_coin_amount not in", values, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountBetween(Long value1, Long value2) {
            addCriterion("withdraw_coin_amount between", value1, value2, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawCoinAmountNotBetween(Long value1, Long value2) {
            addCriterion("withdraw_coin_amount not between", value1, value2, "withdrawCoinAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNull() {
            addCriterion("withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNotNull() {
            addCriterion("withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountEqualTo(Long value) {
            addCriterion("withdraw_amount =", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotEqualTo(Long value) {
            addCriterion("withdraw_amount <>", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThan(Long value) {
            addCriterion("withdraw_amount >", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("withdraw_amount >=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThan(Long value) {
            addCriterion("withdraw_amount <", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThanOrEqualTo(Long value) {
            addCriterion("withdraw_amount <=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIn(List<Long> values) {
            addCriterion("withdraw_amount in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotIn(List<Long> values) {
            addCriterion("withdraw_amount not in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountBetween(Long value1, Long value2) {
            addCriterion("withdraw_amount between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotBetween(Long value1, Long value2) {
            addCriterion("withdraw_amount not between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(Long value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(Long value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(Long value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(Long value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<Long> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<Long> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(Long value1, Long value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumIsNull() {
            addCriterion("channel_acquiring_num is null");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumIsNotNull() {
            addCriterion("channel_acquiring_num is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumEqualTo(String value) {
            addCriterion("channel_acquiring_num =", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumNotEqualTo(String value) {
            addCriterion("channel_acquiring_num <>", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumGreaterThan(String value) {
            addCriterion("channel_acquiring_num >", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumGreaterThanOrEqualTo(String value) {
            addCriterion("channel_acquiring_num >=", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumLessThan(String value) {
            addCriterion("channel_acquiring_num <", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumLessThanOrEqualTo(String value) {
            addCriterion("channel_acquiring_num <=", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumLike(String value) {
            addCriterion("channel_acquiring_num like", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumNotLike(String value) {
            addCriterion("channel_acquiring_num not like", value, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumIn(List<String> values) {
            addCriterion("channel_acquiring_num in", values, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumNotIn(List<String> values) {
            addCriterion("channel_acquiring_num not in", values, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumBetween(String value1, String value2) {
            addCriterion("channel_acquiring_num between", value1, value2, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelAcquiringNumNotBetween(String value1, String value2) {
            addCriterion("channel_acquiring_num not between", value1, value2, "channelAcquiringNum");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeIsNull() {
            addCriterion("channel_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeIsNotNull() {
            addCriterion("channel_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeEqualTo(Date value) {
            addCriterion("channel_pay_time =", value, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeNotEqualTo(Date value) {
            addCriterion("channel_pay_time <>", value, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeGreaterThan(Date value) {
            addCriterion("channel_pay_time >", value, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("channel_pay_time >=", value, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeLessThan(Date value) {
            addCriterion("channel_pay_time <", value, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("channel_pay_time <=", value, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeIn(List<Date> values) {
            addCriterion("channel_pay_time in", values, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeNotIn(List<Date> values) {
            addCriterion("channel_pay_time not in", values, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeBetween(Date value1, Date value2) {
            addCriterion("channel_pay_time between", value1, value2, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("channel_pay_time not between", value1, value2, "channelPayTime");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeIsNull() {
            addCriterion("channel_pay_errorcode is null");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeIsNotNull() {
            addCriterion("channel_pay_errorcode is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeEqualTo(String value) {
            addCriterion("channel_pay_errorcode =", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeNotEqualTo(String value) {
            addCriterion("channel_pay_errorcode <>", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeGreaterThan(String value) {
            addCriterion("channel_pay_errorcode >", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_pay_errorcode >=", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeLessThan(String value) {
            addCriterion("channel_pay_errorcode <", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeLessThanOrEqualTo(String value) {
            addCriterion("channel_pay_errorcode <=", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeLike(String value) {
            addCriterion("channel_pay_errorcode like", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeNotLike(String value) {
            addCriterion("channel_pay_errorcode not like", value, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeIn(List<String> values) {
            addCriterion("channel_pay_errorcode in", values, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeNotIn(List<String> values) {
            addCriterion("channel_pay_errorcode not in", values, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeBetween(String value1, String value2) {
            addCriterion("channel_pay_errorcode between", value1, value2, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelPayErrorcodeNotBetween(String value1, String value2) {
            addCriterion("channel_pay_errorcode not between", value1, value2, "channelPayErrorcode");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(Integer value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(Integer value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(Integer value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(Integer value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(Integer value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<Integer> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<Integer> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(Integer value1, Integer value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountIsNull() {
            addCriterion("channel_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountIsNotNull() {
            addCriterion("channel_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountEqualTo(Integer value) {
            addCriterion("channel_pay_amount =", value, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountNotEqualTo(Integer value) {
            addCriterion("channel_pay_amount <>", value, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountGreaterThan(Integer value) {
            addCriterion("channel_pay_amount >", value, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_pay_amount >=", value, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountLessThan(Integer value) {
            addCriterion("channel_pay_amount <", value, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("channel_pay_amount <=", value, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountIn(List<Integer> values) {
            addCriterion("channel_pay_amount in", values, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountNotIn(List<Integer> values) {
            addCriterion("channel_pay_amount not in", values, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("channel_pay_amount between", value1, value2, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andChannelPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_pay_amount not between", value1, value2, "channelPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubIsNull() {
            addCriterion("order_state_sub is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubIsNotNull() {
            addCriterion("order_state_sub is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubEqualTo(Integer value) {
            addCriterion("order_state_sub =", value, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubNotEqualTo(Integer value) {
            addCriterion("order_state_sub <>", value, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubGreaterThan(Integer value) {
            addCriterion("order_state_sub >", value, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state_sub >=", value, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubLessThan(Integer value) {
            addCriterion("order_state_sub <", value, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubLessThanOrEqualTo(Integer value) {
            addCriterion("order_state_sub <=", value, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubIn(List<Integer> values) {
            addCriterion("order_state_sub in", values, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubNotIn(List<Integer> values) {
            addCriterion("order_state_sub not in", values, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubBetween(Integer value1, Integer value2) {
            addCriterion("order_state_sub between", value1, value2, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderStateSubNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state_sub not between", value1, value2, "orderStateSub");
            return (Criteria) this;
        }

        public Criteria andOrderFlagIsNull() {
            addCriterion("order_flag is null");
            return (Criteria) this;
        }

        public Criteria andOrderFlagIsNotNull() {
            addCriterion("order_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFlagEqualTo(Integer value) {
            addCriterion("order_flag =", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagNotEqualTo(Integer value) {
            addCriterion("order_flag <>", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagGreaterThan(Integer value) {
            addCriterion("order_flag >", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_flag >=", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagLessThan(Integer value) {
            addCriterion("order_flag <", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagLessThanOrEqualTo(Integer value) {
            addCriterion("order_flag <=", value, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagIn(List<Integer> values) {
            addCriterion("order_flag in", values, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagNotIn(List<Integer> values) {
            addCriterion("order_flag not in", values, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagBetween(Integer value1, Integer value2) {
            addCriterion("order_flag between", value1, value2, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("order_flag not between", value1, value2, "orderFlag");
            return (Criteria) this;
        }

        public Criteria andOrderDescIsNull() {
            addCriterion("order_desc is null");
            return (Criteria) this;
        }

        public Criteria andOrderDescIsNotNull() {
            addCriterion("order_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDescEqualTo(String value) {
            addCriterion("order_desc =", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotEqualTo(String value) {
            addCriterion("order_desc <>", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescGreaterThan(String value) {
            addCriterion("order_desc >", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescGreaterThanOrEqualTo(String value) {
            addCriterion("order_desc >=", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLessThan(String value) {
            addCriterion("order_desc <", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLessThanOrEqualTo(String value) {
            addCriterion("order_desc <=", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLike(String value) {
            addCriterion("order_desc like", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotLike(String value) {
            addCriterion("order_desc not like", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescIn(List<String> values) {
            addCriterion("order_desc in", values, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotIn(List<String> values) {
            addCriterion("order_desc not in", values, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescBetween(String value1, String value2) {
            addCriterion("order_desc between", value1, value2, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotBetween(String value1, String value2) {
            addCriterion("order_desc not between", value1, value2, "orderDesc");
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

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
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

        public Criteria andValidTimeIsNull() {
            addCriterion("valid_time is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("valid_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(Date value) {
            addCriterion("valid_time =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(Date value) {
            addCriterion("valid_time <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(Date value) {
            addCriterion("valid_time >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_time >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(Date value) {
            addCriterion("valid_time <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_time <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<Date> values) {
            addCriterion("valid_time in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<Date> values) {
            addCriterion("valid_time not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(Date value1, Date value2) {
            addCriterion("valid_time between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_time not between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
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