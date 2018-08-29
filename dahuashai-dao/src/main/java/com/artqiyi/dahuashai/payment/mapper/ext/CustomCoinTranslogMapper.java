/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-dao
 * Author: author  wushyue@gmail.com
 * Create On: Apr 25, 2018 4:20:39 PM
 * Modify On: Apr 25, 2018 4:20:39 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.payment.mapper.ext;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.artqiyi.dahuashai.payment.mapper.CoinTranslogMapper;


/**
 * 
 * 定制的SystemNoticeMapper
 *
 * @author wushuang
 * @since 2018-04-25
 */
public interface CustomCoinTranslogMapper extends CoinTranslogMapper {
	
	@Select({
		"SELECT sum(trans_amount) FROM coin_translog where user_id = #{userId,jdbcType=BIGINT} and account_type = 1 and trans_flag = 2 "
		+ "and trans_time BETWEEN #{startTime,jdbcType=TIMESTAMP} and #{endTime,jdbcType=TIMESTAMP}"})
	Integer getSumCoinByUserIdAndTime(@Param("userId") Long userId, @Param("startTime") Date startTime,  @Param("endTime") Date endTime);

	@Select({
		"SELECT sum(trans_amount) FROM coin_translog where user_id = #{userId,jdbcType=BIGINT} and trans_type = #{transType}"
		+ "and trans_time BETWEEN #{startTime,jdbcType=TIMESTAMP} and #{endTime,jdbcType=TIMESTAMP}"})
	Integer getIgnoreSumCoinByUserIdAndTime(@Param("userId") Long userId,@Param("transType") String transType, @Param("startTime") Date startTime,  @Param("endTime") Date endTime);

	@Select({
		"SELECT sum(trans_amount) FROM coin_translog where user_id = #{userId,jdbcType=BIGINT} and trans_type = #{transType}"})
	Integer getIgnoreSumCoinByUserId(@Param("userId") Long userId,@Param("transType") String transType);
	
	@Select({
	"SELECT sum(trans_amount) FROM coin_translog where user_id = #{userId,jdbcType=BIGINT} and account_type = 3 and trans_flag = 1 "})
	Integer getSumRewardByUserId(@Param("userId") Long userId);

}
