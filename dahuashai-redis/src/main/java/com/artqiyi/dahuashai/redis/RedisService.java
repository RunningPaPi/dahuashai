/**
 * 
 */
package com.artqiyi.dahuashai.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public interface RedisService {
    /**
     * 生成缓存的key ，内部实现会加一个app前缀，可以配置在resources下的app.properties文件里
     * @param businessMark 业务标识
     * @param keySet        唯一值
     * @return
     */
	public String genKey(String businessMark,TreeSet<String> keySet);

    /**
     * 生成集合缓存的key，内部实现会加一个app前缀，可以配置在resources下的app.properties文件里
     * @param businessMark 业务标识
     * @param key           唯一值
     * @return
     */
	public String genCollectionKey(String businessMark, String key);

    /**
     * 设置字符串，默认过期时间为30分钟
     * @param key
     * @param value
     */
	public void setString(String key, String value);

    /**
     *设置字符串，可定义过期时间
     * @param key
     * @param value
     * @param expiredSeconds 过期时间 单位为秒
     */
	public void setString(String key, String value, int expiredSeconds);

	/**
	 * 注册缓存对象的类到fst，这样可能提高性能
	 * @param clazz
	 */
	public void registerClass(Class... clazz);

    /**
     *设置对象，默认过期时间为30分钟
     * @param key
     * @param value
     */
	public void setObject(String key, Serializable value);

    /**
     *设置对象，可定义过期时间
     * @param key
     * @param value
     * @param expiredSeconds 过期时间 单位为秒
     */
	public void setObject(String key, Serializable value, int expiredSeconds);

    /**
     * 获到字符串，不改变过期时间
     * @param key
     * @return
     */
	public String getString(String key);

    /**
     *获到字符串，可改变过期时间
     * @param key
     * @param expiredSeconds 如果expiredSeconds大于已存的过期时间，设置过期时间为expiredSeconds
     * @return
     */
	public String getString(String key, int expiredSeconds);

    /**
     *获到对象，不改变过期时间
     * @param key
     * @return
     */
	public Object getObject(String key);

    /**
     *获到对象，可改变过期时间
     * @param key
     * @param expiredSeconds 如果expiredSeconds大于已存的过期时间，设置过期时间为expiredSeconds
     * @return
     */
	public Object getObject(String key, int expiredSeconds);

    /**
     *删除指定的key的缓存
     * @param key
     */
	public void removeObject(String key);

    /**
     *设置指定的key的过期时间，单位为秒
     * @param key
     * @param expiredSeconds
     */
	public void expire(String key, int expiredSeconds);

	/**
	 * 设置指定的key的过期时间
	 * @param key
	 * @param expireTime
	 * @param unit
	 */
	public void expire(String key,final int expireTime,TimeUnit unit);

    /**
     * 获取key的剩余存活时间
     * @param key
     * @return
     */
	public long getExpire(String key);

	/**
	 * 参数重载 根据 key 设置值
	 * @Title: setObject
	 * @Description:
	 * @param key
	 * @param value
	 * @param expiredSeconds
	 * @param cover   false：有则不覆盖，无则添加;true:无论有无均覆盖
	 * @throws
	 */
	public void setObject(final String key, final Serializable value, final int expiredSeconds, final boolean cover);
	/**
	 * 判断 key 是否存在
	 * @Title: exists
	 * @Description:
	 * @param key
	 * @return
	 * @throws
	 */
	public boolean exists(final String key);

	/**
	 * 哈希结构的存储，简单场景
	 * 当 expiredSeconds 大于零时，设置有效期，否则不设置有效期
	 * @Title: setHashObject
	 * @Description:
	 * @param key
	 * @param field
	 * @param value
	 * @throws
	 */
	void setHashObject(final String key, final String field, final Object value, final int expiredSeconds);

	/**
	 * 哈希结构的存储，大量数据场景，高效率的存储
	 * 当 expiredSeconds 大于零时，设置有效期，否则不设置有效期
	 * @Title: setHashObjectWithPiple
	 * @Description: 利用管道技术设置hash数据
	 * @param key 表名
	 * @param values   field,object
	 * @throws
	 */
	public void setHashObjectWithPiple(final String key, final Map<String, Object> values, final int expiredSeconds);
	/**
	 *
	 * @Title: getHashObject
	 * @Description: 获取hash对象
	 * @param key
	 * @param field
	 * @return
	 * @throws
	 */
	public Object getHashObject(final String key, final String field);

	/**
	 * 参数重载 设置线程休眠时间
	 * 尝试获取数据，当第一次取不到数据时，再尝试线程休眠，根据休眠时间再次获取数据。
	 * 场景：取数据的时候数据没有，正在入库，变更码表
	 * @Title: getHashObject
	 * @Description: 获取hash对象
	 * @param threadSleep  毫秒
	 * @return
	 * @throws
	 */
	public Object getHashObject(final String key, final String field, final int threadSleep);
	/**
	 *
	 * @Title: getHashObject
	 * @Description: 获取hash对象
	 * @param key
	 * @return
	 * @throws
	 */
	public List<?> getHashObject(final String key);
	/**
	 *
	 * @Title: scanHashData
	 * @Description: 根据key 和  模糊的field，模糊查询hash对象
	 * @param key
	 * @param fieldMatch
	 * @param count 查询返回结果数量
	 * @return
	 * @throws
	 */
	public List<?> scanHashData(final String key, final String fieldMatch, final long count);

	/**
	 *
	 * @Title: removeHashObject
	 * @Description: 移除 hash对象
	 * @param key
	 * @param field
	 * @throws
	 */
	public void removeHashObject(final String key, final String field);

	/**
	 * 是否存在某个key
	 * @param key
	 * @param field
	 * @return
	 */
	public boolean hasHashKey(final String key, final String field);

	/**
	 * 对key值进行加1
	 * @param key
	 * @return
	 */
	public int incrInt(String key);

}
