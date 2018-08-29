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

import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrder;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrderExample;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrderExample.Criteria;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrderExample.Criterion;

public class PayWithdrawOrderSqlProvider {

    public String countByExample(PayWithdrawOrderExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("pay_withdraw_order");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(PayWithdrawOrderExample example) {
        BEGIN();
        DELETE_FROM("pay_withdraw_order");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PayWithdrawOrder record) {
        BEGIN();
        INSERT_INTO("pay_withdraw_order");
        
        if (record.getWithdrawOrderId() != null) {
            VALUES("withdraw_order_id", "#{withdrawOrderId,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawOrderNum() != null) {
            VALUES("withdraw_order_num", "#{withdrawOrderNum,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderType() != null) {
            VALUES("order_type", "#{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpenid() != null) {
            VALUES("openid", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawCoinAmount() != null) {
            VALUES("withdraw_coin_amount", "#{withdrawCoinAmount,jdbcType=BIGINT}");
        }
        
        if (record.getWithdrawAmount() != null) {
            VALUES("withdraw_amount", "#{withdrawAmount,jdbcType=BIGINT}");
        }
        
        if (record.getOrderAmount() != null) {
            VALUES("order_amount", "#{orderAmount,jdbcType=BIGINT}");
        }
        
        if (record.getChannelAcquiringNum() != null) {
            VALUES("channel_acquiring_num", "#{channelAcquiringNum,jdbcType=VARCHAR}");
        }
        
        if (record.getChannelPayTime() != null) {
            VALUES("channel_pay_time", "#{channelPayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChannelPayErrorcode() != null) {
            VALUES("channel_pay_errorcode", "#{channelPayErrorcode,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel() != null) {
            VALUES("channel", "#{channel,jdbcType=INTEGER}");
        }
        
        if (record.getChannelPayAmount() != null) {
            VALUES("channel_pay_amount", "#{channelPayAmount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderState() != null) {
            VALUES("order_state", "#{orderState,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStateSub() != null) {
            VALUES("order_state_sub", "#{orderStateSub,jdbcType=INTEGER}");
        }
        
        if (record.getOrderFlag() != null) {
            VALUES("order_flag", "#{orderFlag,jdbcType=INTEGER}");
        }
        
        if (record.getOrderDesc() != null) {
            VALUES("order_desc", "#{orderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            VALUES("client_ip", "#{clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidTime() != null) {
            VALUES("valid_time", "#{validTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishTime() != null) {
            VALUES("finish_time", "#{finishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(PayWithdrawOrderExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("withdraw_order_id");
        } else {
            SELECT("withdraw_order_id");
        }
        SELECT("withdraw_order_num");
        SELECT("order_type");
        SELECT("user_id");
        SELECT("openid");
        SELECT("user_name");
        SELECT("withdraw_coin_amount");
        SELECT("withdraw_amount");
        SELECT("order_amount");
        SELECT("channel_acquiring_num");
        SELECT("channel_pay_time");
        SELECT("channel_pay_errorcode");
        SELECT("channel");
        SELECT("channel_pay_amount");
        SELECT("order_state");
        SELECT("order_state_sub");
        SELECT("order_flag");
        SELECT("order_desc");
        SELECT("remark");
        SELECT("client_ip");
        SELECT("create_time");
        SELECT("valid_time");
        SELECT("finish_time");
        SELECT("update_time");
        FROM("pay_withdraw_order");
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
        PayWithdrawOrder record = (PayWithdrawOrder) parameter.get("record");
        PayWithdrawOrderExample example = (PayWithdrawOrderExample) parameter.get("example");
        
        BEGIN();
        UPDATE("pay_withdraw_order");
        
        if (record.getWithdrawOrderId() != null) {
            SET("withdraw_order_id = #{record.withdrawOrderId,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawOrderNum() != null) {
            SET("withdraw_order_num = #{record.withdrawOrderNum,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderType() != null) {
            SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpenid() != null) {
            SET("openid = #{record.openid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawCoinAmount() != null) {
            SET("withdraw_coin_amount = #{record.withdrawCoinAmount,jdbcType=BIGINT}");
        }
        
        if (record.getWithdrawAmount() != null) {
            SET("withdraw_amount = #{record.withdrawAmount,jdbcType=BIGINT}");
        }
        
        if (record.getOrderAmount() != null) {
            SET("order_amount = #{record.orderAmount,jdbcType=BIGINT}");
        }
        
        if (record.getChannelAcquiringNum() != null) {
            SET("channel_acquiring_num = #{record.channelAcquiringNum,jdbcType=VARCHAR}");
        }
        
        if (record.getChannelPayTime() != null) {
            SET("channel_pay_time = #{record.channelPayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChannelPayErrorcode() != null) {
            SET("channel_pay_errorcode = #{record.channelPayErrorcode,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel() != null) {
            SET("channel = #{record.channel,jdbcType=INTEGER}");
        }
        
        if (record.getChannelPayAmount() != null) {
            SET("channel_pay_amount = #{record.channelPayAmount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderState() != null) {
            SET("order_state = #{record.orderState,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStateSub() != null) {
            SET("order_state_sub = #{record.orderStateSub,jdbcType=INTEGER}");
        }
        
        if (record.getOrderFlag() != null) {
            SET("order_flag = #{record.orderFlag,jdbcType=INTEGER}");
        }
        
        if (record.getOrderDesc() != null) {
            SET("order_desc = #{record.orderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidTime() != null) {
            SET("valid_time = #{record.validTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishTime() != null) {
            SET("finish_time = #{record.finishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("pay_withdraw_order");
        
        SET("withdraw_order_id = #{record.withdrawOrderId,jdbcType=VARCHAR}");
        SET("withdraw_order_num = #{record.withdrawOrderNum,jdbcType=VARCHAR}");
        SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=BIGINT}");
        SET("openid = #{record.openid,jdbcType=VARCHAR}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("withdraw_coin_amount = #{record.withdrawCoinAmount,jdbcType=BIGINT}");
        SET("withdraw_amount = #{record.withdrawAmount,jdbcType=BIGINT}");
        SET("order_amount = #{record.orderAmount,jdbcType=BIGINT}");
        SET("channel_acquiring_num = #{record.channelAcquiringNum,jdbcType=VARCHAR}");
        SET("channel_pay_time = #{record.channelPayTime,jdbcType=TIMESTAMP}");
        SET("channel_pay_errorcode = #{record.channelPayErrorcode,jdbcType=VARCHAR}");
        SET("channel = #{record.channel,jdbcType=INTEGER}");
        SET("channel_pay_amount = #{record.channelPayAmount,jdbcType=INTEGER}");
        SET("order_state = #{record.orderState,jdbcType=INTEGER}");
        SET("order_state_sub = #{record.orderStateSub,jdbcType=INTEGER}");
        SET("order_flag = #{record.orderFlag,jdbcType=INTEGER}");
        SET("order_desc = #{record.orderDesc,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("valid_time = #{record.validTime,jdbcType=TIMESTAMP}");
        SET("finish_time = #{record.finishTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        PayWithdrawOrderExample example = (PayWithdrawOrderExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PayWithdrawOrder record) {
        BEGIN();
        UPDATE("pay_withdraw_order");
        
        if (record.getWithdrawOrderNum() != null) {
            SET("withdraw_order_num = #{withdrawOrderNum,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderType() != null) {
            SET("order_type = #{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpenid() != null) {
            SET("openid = #{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawCoinAmount() != null) {
            SET("withdraw_coin_amount = #{withdrawCoinAmount,jdbcType=BIGINT}");
        }
        
        if (record.getWithdrawAmount() != null) {
            SET("withdraw_amount = #{withdrawAmount,jdbcType=BIGINT}");
        }
        
        if (record.getOrderAmount() != null) {
            SET("order_amount = #{orderAmount,jdbcType=BIGINT}");
        }
        
        if (record.getChannelAcquiringNum() != null) {
            SET("channel_acquiring_num = #{channelAcquiringNum,jdbcType=VARCHAR}");
        }
        
        if (record.getChannelPayTime() != null) {
            SET("channel_pay_time = #{channelPayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChannelPayErrorcode() != null) {
            SET("channel_pay_errorcode = #{channelPayErrorcode,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel() != null) {
            SET("channel = #{channel,jdbcType=INTEGER}");
        }
        
        if (record.getChannelPayAmount() != null) {
            SET("channel_pay_amount = #{channelPayAmount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderState() != null) {
            SET("order_state = #{orderState,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStateSub() != null) {
            SET("order_state_sub = #{orderStateSub,jdbcType=INTEGER}");
        }
        
        if (record.getOrderFlag() != null) {
            SET("order_flag = #{orderFlag,jdbcType=INTEGER}");
        }
        
        if (record.getOrderDesc() != null) {
            SET("order_desc = #{orderDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            SET("client_ip = #{clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidTime() != null) {
            SET("valid_time = #{validTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishTime() != null) {
            SET("finish_time = #{finishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("withdraw_order_id = #{withdrawOrderId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(PayWithdrawOrderExample example, boolean includeExamplePhrase) {
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
