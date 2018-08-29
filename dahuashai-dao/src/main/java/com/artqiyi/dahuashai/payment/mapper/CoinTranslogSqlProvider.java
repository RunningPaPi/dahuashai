package com.artqiyi.dahuashai.payment.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;

import com.artqiyi.dahuashai.payment.domain.CoinTranslog;
import com.artqiyi.dahuashai.payment.domain.CoinTranslogExample;
import com.artqiyi.dahuashai.payment.domain.CoinTranslogExample.Criteria;
import com.artqiyi.dahuashai.payment.domain.CoinTranslogExample.Criterion;

public class CoinTranslogSqlProvider {

    public String countByExample(CoinTranslogExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("coin_translog");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CoinTranslogExample example) {
        BEGIN();
        DELETE_FROM("coin_translog");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CoinTranslog record) {
        BEGIN();
        INSERT_INTO("coin_translog");
        
        if (record.getCoinTranslogId() != null) {
            VALUES("coin_translog_id", "#{coinTranslogId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            VALUES("account_type", "#{accountType,jdbcType=INTEGER}");
        }
        
        if (record.getTransType() != null) {
            VALUES("trans_type", "#{transType,jdbcType=VARCHAR}");
        }
        
        if (record.getTransTypeSub() != null) {
            VALUES("trans_type_sub", "#{transTypeSub,jdbcType=VARCHAR}");
        }
        
        if (record.getTransFlag() != null) {
            VALUES("trans_flag", "#{transFlag,jdbcType=INTEGER}");
        }
        
        if (record.getTransAmount() != null) {
            VALUES("trans_amount", "#{transAmount,jdbcType=INTEGER}");
        }
        
        if (record.getBalance() != null) {
            VALUES("balance", "#{balance,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getAwardPercentInvitor() != null) {
            VALUES("award_percent_invitor", "#{awardPercentInvitor,jdbcType=INTEGER}");
        }
        
        if (record.getAwardFromUserId() != null) {
            VALUES("award_from_user_id", "#{awardFromUserId,jdbcType=BIGINT}");
        }
        
        if (record.getTransTime() != null) {
            VALUES("trans_time", "#{transTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(CoinTranslogExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("coin_translog_id");
        } else {
            SELECT("coin_translog_id");
        }
        SELECT("user_id");
        SELECT("user_name");
        SELECT("account_type");
        SELECT("trans_type");
        SELECT("trans_type_sub");
        SELECT("trans_flag");
        SELECT("trans_amount");
        SELECT("balance");
        SELECT("remark");
        SELECT("award_percent_invitor");
        SELECT("award_from_user_id");
        SELECT("trans_time");
        SELECT("update_time");
        SELECT("create_time");
        FROM("coin_translog");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String sqlString = SQL();
        if (example != null && example.getLimit() != null) {
            sqlString += " limit " + example.getLimit();
        }
        if (example != null && example.getOffset() != null) {
            sqlString += " offset " + example.getOffset();
        }
        return sqlString;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CoinTranslog record = (CoinTranslog) parameter.get("record");
        CoinTranslogExample example = (CoinTranslogExample) parameter.get("example");
        
        BEGIN();
        UPDATE("coin_translog");
        
        if (record.getCoinTranslogId() != null) {
            SET("coin_translog_id = #{record.coinTranslogId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            SET("account_type = #{record.accountType,jdbcType=INTEGER}");
        }
        
        if (record.getTransType() != null) {
            SET("trans_type = #{record.transType,jdbcType=VARCHAR}");
        }
        
        if (record.getTransTypeSub() != null) {
            SET("trans_type_sub = #{record.transTypeSub,jdbcType=VARCHAR}");
        }
        
        if (record.getTransFlag() != null) {
            SET("trans_flag = #{record.transFlag,jdbcType=INTEGER}");
        }
        
        if (record.getTransAmount() != null) {
            SET("trans_amount = #{record.transAmount,jdbcType=INTEGER}");
        }
        
        if (record.getBalance() != null) {
            SET("balance = #{record.balance,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getAwardPercentInvitor() != null) {
            SET("award_percent_invitor = #{record.awardPercentInvitor,jdbcType=INTEGER}");
        }
        
        if (record.getAwardFromUserId() != null) {
            SET("award_from_user_id = #{record.awardFromUserId,jdbcType=BIGINT}");
        }
        
        if (record.getTransTime() != null) {
            SET("trans_time = #{record.transTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("coin_translog");
        
        SET("coin_translog_id = #{record.coinTranslogId,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=BIGINT}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("account_type = #{record.accountType,jdbcType=INTEGER}");
        SET("trans_type = #{record.transType,jdbcType=VARCHAR}");
        SET("trans_type_sub = #{record.transTypeSub,jdbcType=VARCHAR}");
        SET("trans_flag = #{record.transFlag,jdbcType=INTEGER}");
        SET("trans_amount = #{record.transAmount,jdbcType=INTEGER}");
        SET("balance = #{record.balance,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("award_percent_invitor = #{record.awardPercentInvitor,jdbcType=INTEGER}");
        SET("award_from_user_id = #{record.awardFromUserId,jdbcType=BIGINT}");
        SET("trans_time = #{record.transTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        CoinTranslogExample example = (CoinTranslogExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CoinTranslog record) {
        BEGIN();
        UPDATE("coin_translog");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            SET("account_type = #{accountType,jdbcType=INTEGER}");
        }
        
        if (record.getTransType() != null) {
            SET("trans_type = #{transType,jdbcType=VARCHAR}");
        }
        
        if (record.getTransTypeSub() != null) {
            SET("trans_type_sub = #{transTypeSub,jdbcType=VARCHAR}");
        }
        
        if (record.getTransFlag() != null) {
            SET("trans_flag = #{transFlag,jdbcType=INTEGER}");
        }
        
        if (record.getTransAmount() != null) {
            SET("trans_amount = #{transAmount,jdbcType=INTEGER}");
        }
        
        if (record.getBalance() != null) {
            SET("balance = #{balance,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getAwardPercentInvitor() != null) {
            SET("award_percent_invitor = #{awardPercentInvitor,jdbcType=INTEGER}");
        }
        
        if (record.getAwardFromUserId() != null) {
            SET("award_from_user_id = #{awardFromUserId,jdbcType=BIGINT}");
        }
        
        if (record.getTransTime() != null) {
            SET("trans_time = #{transTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("coin_translog_id = #{coinTranslogId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(CoinTranslogExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}
