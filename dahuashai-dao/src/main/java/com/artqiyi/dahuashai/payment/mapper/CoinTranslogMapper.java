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

import com.artqiyi.dahuashai.payment.domain.CoinTranslog;
import com.artqiyi.dahuashai.payment.domain.CoinTranslogExample;

public interface CoinTranslogMapper {
    @SelectProvider(type=CoinTranslogSqlProvider.class, method="countByExample")
    int countByExample(CoinTranslogExample example);

    @DeleteProvider(type=CoinTranslogSqlProvider.class, method="deleteByExample")
    int deleteByExample(CoinTranslogExample example);

    @Delete({
        "delete from coin_translog",
        "where coin_translog_id = #{coinTranslogId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer coinTranslogId);

    @Insert({
        "insert into coin_translog (coin_translog_id, user_id, ",
        "user_name, account_type, ",
        "trans_type, trans_type_sub, ",
        "trans_flag, trans_amount, ",
        "balance, remark, ",
        "award_percent_invitor, award_from_user_id, ",
        "trans_time, update_time, ",
        "create_time)",
        "values (#{coinTranslogId,jdbcType=INTEGER}, #{userId,jdbcType=BIGINT}, ",
        "#{userName,jdbcType=VARCHAR}, #{accountType,jdbcType=INTEGER}, ",
        "#{transType,jdbcType=VARCHAR}, #{transTypeSub,jdbcType=VARCHAR}, ",
        "#{transFlag,jdbcType=INTEGER}, #{transAmount,jdbcType=INTEGER}, ",
        "#{balance,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{awardPercentInvitor,jdbcType=INTEGER}, #{awardFromUserId,jdbcType=BIGINT}, ",
        "#{transTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(CoinTranslog record);

    @InsertProvider(type=CoinTranslogSqlProvider.class, method="insertSelective")
    int insertSelective(CoinTranslog record);

    @SelectProvider(type=CoinTranslogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="coin_translog_id", property="coinTranslogId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_type", property="accountType", jdbcType=JdbcType.INTEGER),
        @Result(column="trans_type", property="transType", jdbcType=JdbcType.VARCHAR),
        @Result(column="trans_type_sub", property="transTypeSub", jdbcType=JdbcType.VARCHAR),
        @Result(column="trans_flag", property="transFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="trans_amount", property="transAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="award_percent_invitor", property="awardPercentInvitor", jdbcType=JdbcType.INTEGER),
        @Result(column="award_from_user_id", property="awardFromUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="trans_time", property="transTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CoinTranslog> selectByExample(CoinTranslogExample example);

    @Select({
        "select",
        "coin_translog_id, user_id, user_name, account_type, trans_type, trans_type_sub, ",
        "trans_flag, trans_amount, balance, remark, award_percent_invitor, award_from_user_id, ",
        "trans_time, update_time, create_time",
        "from coin_translog",
        "where coin_translog_id = #{coinTranslogId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="coin_translog_id", property="coinTranslogId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_type", property="accountType", jdbcType=JdbcType.INTEGER),
        @Result(column="trans_type", property="transType", jdbcType=JdbcType.VARCHAR),
        @Result(column="trans_type_sub", property="transTypeSub", jdbcType=JdbcType.VARCHAR),
        @Result(column="trans_flag", property="transFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="trans_amount", property="transAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="award_percent_invitor", property="awardPercentInvitor", jdbcType=JdbcType.INTEGER),
        @Result(column="award_from_user_id", property="awardFromUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="trans_time", property="transTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CoinTranslog selectByPrimaryKey(Integer coinTranslogId);

    @UpdateProvider(type=CoinTranslogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CoinTranslog record, @Param("example") CoinTranslogExample example);

    @UpdateProvider(type=CoinTranslogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CoinTranslog record, @Param("example") CoinTranslogExample example);

    @UpdateProvider(type=CoinTranslogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CoinTranslog record);

    @Update({
        "update coin_translog",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "account_type = #{accountType,jdbcType=INTEGER},",
          "trans_type = #{transType,jdbcType=VARCHAR},",
          "trans_type_sub = #{transTypeSub,jdbcType=VARCHAR},",
          "trans_flag = #{transFlag,jdbcType=INTEGER},",
          "trans_amount = #{transAmount,jdbcType=INTEGER},",
          "balance = #{balance,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "award_percent_invitor = #{awardPercentInvitor,jdbcType=INTEGER},",
          "award_from_user_id = #{awardFromUserId,jdbcType=BIGINT},",
          "trans_time = #{transTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where coin_translog_id = #{coinTranslogId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CoinTranslog record);
}