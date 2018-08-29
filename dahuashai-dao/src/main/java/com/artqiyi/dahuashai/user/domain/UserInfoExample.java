package com.artqiyi.dahuashai.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUserRandomNoIsNull() {
            addCriterion("user_random_no is null");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoIsNotNull() {
            addCriterion("user_random_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoEqualTo(Integer value) {
            addCriterion("user_random_no =", value, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoNotEqualTo(Integer value) {
            addCriterion("user_random_no <>", value, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoGreaterThan(Integer value) {
            addCriterion("user_random_no >", value, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_random_no >=", value, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoLessThan(Integer value) {
            addCriterion("user_random_no <", value, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoLessThanOrEqualTo(Integer value) {
            addCriterion("user_random_no <=", value, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoIn(List<Integer> values) {
            addCriterion("user_random_no in", values, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoNotIn(List<Integer> values) {
            addCriterion("user_random_no not in", values, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoBetween(Integer value1, Integer value2) {
            addCriterion("user_random_no between", value1, value2, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andUserRandomNoNotBetween(Integer value1, Integer value2) {
            addCriterion("user_random_no not between", value1, value2, "userRandomNo");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlIsNull() {
            addCriterion("head_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlIsNotNull() {
            addCriterion("head_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlEqualTo(String value) {
            addCriterion("head_pic_url =", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlNotEqualTo(String value) {
            addCriterion("head_pic_url <>", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlGreaterThan(String value) {
            addCriterion("head_pic_url >", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_pic_url >=", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlLessThan(String value) {
            addCriterion("head_pic_url <", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlLessThanOrEqualTo(String value) {
            addCriterion("head_pic_url <=", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlLike(String value) {
            addCriterion("head_pic_url like", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlNotLike(String value) {
            addCriterion("head_pic_url not like", value, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlIn(List<String> values) {
            addCriterion("head_pic_url in", values, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlNotIn(List<String> values) {
            addCriterion("head_pic_url not in", values, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlBetween(String value1, String value2) {
            addCriterion("head_pic_url between", value1, value2, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPicUrlNotBetween(String value1, String value2) {
            addCriterion("head_pic_url not between", value1, value2, "headPicUrl");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Short value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Short value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Short value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Short value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Short value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Short value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Short> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Short> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Short value1, Short value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Short value1, Short value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeIsNull() {
            addCriterion("invaite_code is null");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeIsNotNull() {
            addCriterion("invaite_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeEqualTo(String value) {
            addCriterion("invaite_code =", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeNotEqualTo(String value) {
            addCriterion("invaite_code <>", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeGreaterThan(String value) {
            addCriterion("invaite_code >", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invaite_code >=", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeLessThan(String value) {
            addCriterion("invaite_code <", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeLessThanOrEqualTo(String value) {
            addCriterion("invaite_code <=", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeLike(String value) {
            addCriterion("invaite_code like", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeNotLike(String value) {
            addCriterion("invaite_code not like", value, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeIn(List<String> values) {
            addCriterion("invaite_code in", values, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeNotIn(List<String> values) {
            addCriterion("invaite_code not in", values, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeBetween(String value1, String value2) {
            addCriterion("invaite_code between", value1, value2, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andInvaiteCodeNotBetween(String value1, String value2) {
            addCriterion("invaite_code not between", value1, value2, "invaiteCode");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andDiamondIsNull() {
            addCriterion("diamond is null");
            return (Criteria) this;
        }

        public Criteria andDiamondIsNotNull() {
            addCriterion("diamond is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondEqualTo(Integer value) {
            addCriterion("diamond =", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotEqualTo(Integer value) {
            addCriterion("diamond <>", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondGreaterThan(Integer value) {
            addCriterion("diamond >", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondGreaterThanOrEqualTo(Integer value) {
            addCriterion("diamond >=", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondLessThan(Integer value) {
            addCriterion("diamond <", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondLessThanOrEqualTo(Integer value) {
            addCriterion("diamond <=", value, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondIn(List<Integer> values) {
            addCriterion("diamond in", values, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotIn(List<Integer> values) {
            addCriterion("diamond not in", values, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondBetween(Integer value1, Integer value2) {
            addCriterion("diamond between", value1, value2, "diamond");
            return (Criteria) this;
        }

        public Criteria andDiamondNotBetween(Integer value1, Integer value2) {
            addCriterion("diamond not between", value1, value2, "diamond");
            return (Criteria) this;
        }

        public Criteria andCoinIsNull() {
            addCriterion("coin is null");
            return (Criteria) this;
        }

        public Criteria andCoinIsNotNull() {
            addCriterion("coin is not null");
            return (Criteria) this;
        }

        public Criteria andCoinEqualTo(Integer value) {
            addCriterion("coin =", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotEqualTo(Integer value) {
            addCriterion("coin <>", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThan(Integer value) {
            addCriterion("coin >", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin >=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThan(Integer value) {
            addCriterion("coin <", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinLessThanOrEqualTo(Integer value) {
            addCriterion("coin <=", value, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinIn(List<Integer> values) {
            addCriterion("coin in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotIn(List<Integer> values) {
            addCriterion("coin not in", values, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinBetween(Integer value1, Integer value2) {
            addCriterion("coin between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("coin not between", value1, value2, "coin");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(Integer value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(Integer value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(Integer value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(Integer value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(Integer value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<Integer> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<Integer> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(Integer value1, Integer value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(Integer value1, Integer value2) {
            addCriterion("point not between", value1, value2, "point");
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

        public Criteria andBalanceEqualTo(Long value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Long value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Long value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Long value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Long value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Long> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Long> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Long value1, Long value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Long value1, Long value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableIsNull() {
            addCriterion("balance_withdrawable is null");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableIsNotNull() {
            addCriterion("balance_withdrawable is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableEqualTo(Long value) {
            addCriterion("balance_withdrawable =", value, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableNotEqualTo(Long value) {
            addCriterion("balance_withdrawable <>", value, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableGreaterThan(Long value) {
            addCriterion("balance_withdrawable >", value, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableGreaterThanOrEqualTo(Long value) {
            addCriterion("balance_withdrawable >=", value, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableLessThan(Long value) {
            addCriterion("balance_withdrawable <", value, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableLessThanOrEqualTo(Long value) {
            addCriterion("balance_withdrawable <=", value, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableIn(List<Long> values) {
            addCriterion("balance_withdrawable in", values, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableNotIn(List<Long> values) {
            addCriterion("balance_withdrawable not in", values, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableBetween(Long value1, Long value2) {
            addCriterion("balance_withdrawable between", value1, value2, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceWithdrawableNotBetween(Long value1, Long value2) {
            addCriterion("balance_withdrawable not between", value1, value2, "balanceWithdrawable");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedIsNull() {
            addCriterion("balance_freezed is null");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedIsNotNull() {
            addCriterion("balance_freezed is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedEqualTo(Long value) {
            addCriterion("balance_freezed =", value, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedNotEqualTo(Long value) {
            addCriterion("balance_freezed <>", value, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedGreaterThan(Long value) {
            addCriterion("balance_freezed >", value, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedGreaterThanOrEqualTo(Long value) {
            addCriterion("balance_freezed >=", value, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedLessThan(Long value) {
            addCriterion("balance_freezed <", value, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedLessThanOrEqualTo(Long value) {
            addCriterion("balance_freezed <=", value, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedIn(List<Long> values) {
            addCriterion("balance_freezed in", values, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedNotIn(List<Long> values) {
            addCriterion("balance_freezed not in", values, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedBetween(Long value1, Long value2) {
            addCriterion("balance_freezed between", value1, value2, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andBalanceFreezedNotBetween(Long value1, Long value2) {
            addCriterion("balance_freezed not between", value1, value2, "balanceFreezed");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIsNull() {
            addCriterion("alipay_account is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIsNotNull() {
            addCriterion("alipay_account is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountEqualTo(String value) {
            addCriterion("alipay_account =", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotEqualTo(String value) {
            addCriterion("alipay_account <>", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThan(String value) {
            addCriterion("alipay_account >", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_account >=", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThan(String value) {
            addCriterion("alipay_account <", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThanOrEqualTo(String value) {
            addCriterion("alipay_account <=", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLike(String value) {
            addCriterion("alipay_account like", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotLike(String value) {
            addCriterion("alipay_account not like", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIn(List<String> values) {
            addCriterion("alipay_account in", values, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotIn(List<String> values) {
            addCriterion("alipay_account not in", values, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountBetween(String value1, String value2) {
            addCriterion("alipay_account between", value1, value2, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotBetween(String value1, String value2) {
            addCriterion("alipay_account not between", value1, value2, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameIsNull() {
            addCriterion("alipay_realname is null");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameIsNotNull() {
            addCriterion("alipay_realname is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameEqualTo(String value) {
            addCriterion("alipay_realname =", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameNotEqualTo(String value) {
            addCriterion("alipay_realname <>", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameGreaterThan(String value) {
            addCriterion("alipay_realname >", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_realname >=", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameLessThan(String value) {
            addCriterion("alipay_realname <", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameLessThanOrEqualTo(String value) {
            addCriterion("alipay_realname <=", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameLike(String value) {
            addCriterion("alipay_realname like", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameNotLike(String value) {
            addCriterion("alipay_realname not like", value, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameIn(List<String> values) {
            addCriterion("alipay_realname in", values, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameNotIn(List<String> values) {
            addCriterion("alipay_realname not in", values, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameBetween(String value1, String value2) {
            addCriterion("alipay_realname between", value1, value2, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andAlipayRealnameNotBetween(String value1, String value2) {
            addCriterion("alipay_realname not between", value1, value2, "alipayRealname");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedIsNull() {
            addCriterion("phone_validated is null");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedIsNotNull() {
            addCriterion("phone_validated is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedEqualTo(Boolean value) {
            addCriterion("phone_validated =", value, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedNotEqualTo(Boolean value) {
            addCriterion("phone_validated <>", value, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedGreaterThan(Boolean value) {
            addCriterion("phone_validated >", value, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("phone_validated >=", value, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedLessThan(Boolean value) {
            addCriterion("phone_validated <", value, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedLessThanOrEqualTo(Boolean value) {
            addCriterion("phone_validated <=", value, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedIn(List<Boolean> values) {
            addCriterion("phone_validated in", values, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedNotIn(List<Boolean> values) {
            addCriterion("phone_validated not in", values, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedBetween(Boolean value1, Boolean value2) {
            addCriterion("phone_validated between", value1, value2, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andPhoneValidatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("phone_validated not between", value1, value2, "phoneValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedIsNull() {
            addCriterion("realname_validated is null");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedIsNotNull() {
            addCriterion("realname_validated is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedEqualTo(Boolean value) {
            addCriterion("realname_validated =", value, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedNotEqualTo(Boolean value) {
            addCriterion("realname_validated <>", value, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedGreaterThan(Boolean value) {
            addCriterion("realname_validated >", value, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("realname_validated >=", value, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedLessThan(Boolean value) {
            addCriterion("realname_validated <", value, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedLessThanOrEqualTo(Boolean value) {
            addCriterion("realname_validated <=", value, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedIn(List<Boolean> values) {
            addCriterion("realname_validated in", values, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedNotIn(List<Boolean> values) {
            addCriterion("realname_validated not in", values, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedBetween(Boolean value1, Boolean value2) {
            addCriterion("realname_validated between", value1, value2, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andRealnameValidatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("realname_validated not between", value1, value2, "realnameValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedIsNull() {
            addCriterion("alipay_account_validated is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedIsNotNull() {
            addCriterion("alipay_account_validated is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedEqualTo(Boolean value) {
            addCriterion("alipay_account_validated =", value, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedNotEqualTo(Boolean value) {
            addCriterion("alipay_account_validated <>", value, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedGreaterThan(Boolean value) {
            addCriterion("alipay_account_validated >", value, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("alipay_account_validated >=", value, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedLessThan(Boolean value) {
            addCriterion("alipay_account_validated <", value, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedLessThanOrEqualTo(Boolean value) {
            addCriterion("alipay_account_validated <=", value, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedIn(List<Boolean> values) {
            addCriterion("alipay_account_validated in", values, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedNotIn(List<Boolean> values) {
            addCriterion("alipay_account_validated not in", values, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedBetween(Boolean value1, Boolean value2) {
            addCriterion("alipay_account_validated between", value1, value2, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountValidatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("alipay_account_validated not between", value1, value2, "alipayAccountValidated");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
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