package com.artqiyi.dahuashai.payment.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrder;
import com.artqiyi.dahuashai.payment.domain.PayWithdrawOrderExample;

public interface PayWithdrawOrderMapper {
    @SelectProvider(type=PayWithdrawOrderSqlProvider.class, method="countByExample")
    int countByExample(PayWithdrawOrderExample example);

    @DeleteProvider(type=PayWithdrawOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(PayWithdrawOrderExample example);

    @Delete({
        "delete from pay_withdraw_order",
        "where withdraw_order_id = #{withdrawOrderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String withdrawOrderId);

    @Insert({
        "insert into pay_withdraw_order (withdraw_order_id, withdraw_order_num, ",
        "order_type, user_id, ",
        "openid, user_name, ",
        "withdraw_coin_amount, withdraw_amount, ",
        "order_amount, channel_acquiring_num, ",
        "channel_pay_time, channel_pay_errorcode, ",
        "channel, channel_pay_amount, ",
        "order_state, order_state_sub, ",
        "order_flag, order_desc, ",
        "remark, client_ip, ",
        "create_time, valid_time, ",
        "finish_time, update_time)",
        "values (#{withdrawOrderId,jdbcType=VARCHAR}, #{withdrawOrderNum,jdbcType=VARCHAR}, ",
        "#{orderType,jdbcType=INTEGER}, #{userId,jdbcType=BIGINT}, ",
        "#{openid,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{withdrawCoinAmount,jdbcType=BIGINT}, #{withdrawAmount,jdbcType=BIGINT}, ",
        "#{orderAmount,jdbcType=BIGINT}, #{channelAcquiringNum,jdbcType=VARCHAR}, ",
        "#{channelPayTime,jdbcType=TIMESTAMP}, #{channelPayErrorcode,jdbcType=VARCHAR}, ",
        "#{channel,jdbcType=INTEGER}, #{channelPayAmount,jdbcType=INTEGER}, ",
        "#{orderState,jdbcType=INTEGER}, #{orderStateSub,jdbcType=INTEGER}, ",
        "#{orderFlag,jdbcType=INTEGER}, #{orderDesc,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{clientIp,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{validTime,jdbcType=TIMESTAMP}, ",
        "#{finishTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(PayWithdrawOrder record);

    @InsertProvider(type=PayWithdrawOrderSqlProvider.class, method="insertSelective")
    int insertSelective(PayWithdrawOrder record);

    @SelectProvider(type=PayWithdrawOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="withdraw_order_id", property="withdrawOrderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="withdraw_order_num", property="withdrawOrderNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="withdraw_coin_amount", property="withdrawCoinAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="withdraw_amount", property="withdrawAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="order_amount", property="orderAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="channel_acquiring_num", property="channelAcquiringNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_pay_time", property="channelPayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="channel_pay_errorcode", property="channelPayErrorcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel", property="channel", jdbcType=JdbcType.INTEGER),
        @Result(column="channel_pay_amount", property="channelPayAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_state", property="orderState", jdbcType=JdbcType.INTEGER),
        @Result(column="order_state_sub", property="orderStateSub", jdbcType=JdbcType.INTEGER),
        @Result(column="order_flag", property="orderFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="order_desc", property="orderDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_time", property="validTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="finish_time", property="finishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PayWithdrawOrder> selectByExample(PayWithdrawOrderExample example);

    @Select({
        "select",
        "withdraw_order_id, withdraw_order_num, order_type, user_id, openid, user_name, ",
        "withdraw_coin_amount, withdraw_amount, order_amount, channel_acquiring_num, ",
        "channel_pay_time, channel_pay_errorcode, channel, channel_pay_amount, order_state, ",
        "order_state_sub, order_flag, order_desc, remark, client_ip, create_time, valid_time, ",
        "finish_time, update_time",
        "from pay_withdraw_order",
        "where withdraw_order_id = #{withdrawOrderId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="withdraw_order_id", property="withdrawOrderId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="withdraw_order_num", property="withdrawOrderNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="withdraw_coin_amount", property="withdrawCoinAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="withdraw_amount", property="withdrawAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="order_amount", property="orderAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="channel_acquiring_num", property="channelAcquiringNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_pay_time", property="channelPayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="channel_pay_errorcode", property="channelPayErrorcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel", property="channel", jdbcType=JdbcType.INTEGER),
        @Result(column="channel_pay_amount", property="channelPayAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_state", property="orderState", jdbcType=JdbcType.INTEGER),
        @Result(column="order_state_sub", property="orderStateSub", jdbcType=JdbcType.INTEGER),
        @Result(column="order_flag", property="orderFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="order_desc", property="orderDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_time", property="validTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="finish_time", property="finishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PayWithdrawOrder selectByPrimaryKey(String withdrawOrderId);

    @UpdateProvider(type=PayWithdrawOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PayWithdrawOrder record, @Param("example") PayWithdrawOrderExample example);

    @UpdateProvider(type=PayWithdrawOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PayWithdrawOrder record, @Param("example") PayWithdrawOrderExample example);

    @UpdateProvider(type=PayWithdrawOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PayWithdrawOrder record);

    @Update({
        "update pay_withdraw_order",
        "set withdraw_order_num = #{withdrawOrderNum,jdbcType=VARCHAR},",
          "order_type = #{orderType,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "openid = #{openid,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "withdraw_coin_amount = #{withdrawCoinAmount,jdbcType=BIGINT},",
          "withdraw_amount = #{withdrawAmount,jdbcType=BIGINT},",
          "order_amount = #{orderAmount,jdbcType=BIGINT},",
          "channel_acquiring_num = #{channelAcquiringNum,jdbcType=VARCHAR},",
          "channel_pay_time = #{channelPayTime,jdbcType=TIMESTAMP},",
          "channel_pay_errorcode = #{channelPayErrorcode,jdbcType=VARCHAR},",
          "channel = #{channel,jdbcType=INTEGER},",
          "channel_pay_amount = #{channelPayAmount,jdbcType=INTEGER},",
          "order_state = #{orderState,jdbcType=INTEGER},",
          "order_state_sub = #{orderStateSub,jdbcType=INTEGER},",
          "order_flag = #{orderFlag,jdbcType=INTEGER},",
          "order_desc = #{orderDesc,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "valid_time = #{validTime,jdbcType=TIMESTAMP},",
          "finish_time = #{finishTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where withdraw_order_id = #{withdrawOrderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PayWithdrawOrder record);
}