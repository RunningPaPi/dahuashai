/**
 * 
 */
package com.artqiyi.dahuashai.redis;

/**
 * @author Qinyinling
 *
 */
public class RedisConstants {
	public final static int TTL_MINUTE=60;
	public final static int TTL_10_MINUTE=10*TTL_MINUTE;
	public final static int TTL_DEFAULT=3*TTL_10_MINUTE;
	public final static int TTL_HALF_HOUR=TTL_DEFAULT;
	public final static int TTL_HOUR=2*TTL_HALF_HOUR;
	public final static int TTL_HALF_DAY = 12*TTL_HOUR;
	public final static int TTL_DAY=2*TTL_HALF_DAY;
	public final static int TTL_WEEK=7*TTL_DAY;
	public final static int TTL_MONTH=30*TTL_DAY;
	public final static int TTL_QUARTER_OF_A_YEAR=3*TTL_MONTH;
	public final static int TTL_YEAR=4*TTL_QUARTER_OF_A_YEAR;
}
