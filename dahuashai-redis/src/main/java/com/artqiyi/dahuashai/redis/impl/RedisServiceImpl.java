/**
 *
 */
package com.artqiyi.dahuashai.redis.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.nustaq.serialization.FSTConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import com.artqiyi.dahuashai.common.util.CacheKey;
import com.artqiyi.dahuashai.common.util.PropertiesUtils;
import com.artqiyi.dahuashai.redis.RedisConstants;
import com.artqiyi.dahuashai.redis.RedisService;

/**
 * @author Qinyinling
 *
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

	private static  Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Resource (name = "redisTemplate")
	private RedisTemplate<Object, Object> redisTemplate;

	private FSTConfiguration fst = FSTConfiguration.createDefaultConfiguration();

	/**
	 * 仅供同一数据需要对不同应用区分开时使用
	 * 生成集合key
	 * @param businessMark  业务
	 * @param keySet  key集合
	 * @return
	 */
	@Override
	public String genKey(String businessMark, TreeSet<String> keySet) {
	    String app= PropertiesUtils.getProperty("app","default_app");
		CacheKey cacheKey=new CacheKey(businessMark);
		cacheKey.addKey(app);
		cacheKey.addKeySet(keySet);
		return cacheKey.genKey();
	}

	/**仅供同一数据需要对不同应用区分开时使用
	 * 生成key
	 * @param businessMark 业务
	 * @param key  key名
	 * @return
	 */
	@Override
	public String genCollectionKey(String businessMark, String key) {
        String app=PropertiesUtils.getProperty("app","default_app");
		CacheKey cacheKey=new CacheKey(businessMark);
		cacheKey.addKey(app);
		cacheKey.addKey(key);
		return cacheKey.genKey();
	}


	/* (non-Javadoc)
	 * @see com.foresee.base.redis.IRedisService#setString(java.lang.String, java.lang.String)
	 */
	@Override
	public void setString(String key, String value) {
		setString(key, value, RedisConstants.TTL_HALF_HOUR);

	}

	/* (non-Javadoc)
	 * @see com.foresee.base.redis.IRedisService#setString(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void setString(String key, String value, final int expiredSeconds) {
		if(expiredSeconds>0){
			redisTemplate.opsForValue().set(key,value,expiredSeconds, TimeUnit.SECONDS);
		}else{
			redisTemplate.opsForValue().set(key,value);
		}
	}

	@Override
	public void registerClass(Class... clazz) {
		fst.registerClass(clazz);
	}

	/* (non-Javadoc)
	 * @see com.foresee.base.redis.IRedisService#setObject(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setObject(String key, Serializable value) {
		setObject(key, value, RedisConstants.TTL_HALF_HOUR);
	}

	/* (non-Javadoc)
	 * @see com.foresee.base.redis.IRedisService#setObject(java.lang.String, java.lang.Object, int)
	 */
	@Override
	public void setObject(String key, Serializable value, final int expiredSeconds) {
		if(expiredSeconds>0){
			redisTemplate.opsForValue().set(key,value,expiredSeconds, TimeUnit.SECONDS);
		}else{
			redisTemplate.opsForValue().set(key,value);
		}
	}

	/* (non-Javadoc)
	 * @see com.foresee.base.redis.IRedisService#getString(java.lang.String)
	 */
	@Override
	public String getString(String key) {
		return this.getString(key, 0);
	}

	/* (non-Javadoc)
	 * @see com.foresee.base.redis.IRedisService#getObject(java.lang.String)
	 */
	@Override
	public Object getObject(String key) {
		return this.getObject(key, 0);
	}
	 /**
     * 描述 : <Object转byte[]>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param obj
     * @return
     */
    private byte[] toByteArray(Object obj) {
       return fst.asByteArray(obj);
    }

    /**
     * 描述 : <byte[]转Object>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param bytes
     * @return
     */
    private Object toObject(byte[] bytes) {
      return fst.asObject(bytes);
    }

    public void evict(Object key) {
        final String keyf = (String) key;
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(keyf.getBytes());
            }
        });
    }

    public void clear() {
        redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

	@Override
	public String getString(String key, final int expiredSeconds) {
		return String.valueOf(redisTemplate.opsForValue().get(key));
	}

	@Override
	public Object getObject(String key, final int expiredSeconds) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void removeObject(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void expire(String key,final int expiredSeconds) {
		 final String keyf = (String) key;
	        redisTemplate.execute(new RedisCallback<Object>() {
	            public Long doInRedis(RedisConnection connection)
	                    throws DataAccessException {
	                byte[] key = keyf.getBytes();
	                if (expiredSeconds > 0) {
	                	Long ttl = connection.ttl(key);
	                	if(expiredSeconds > ttl){
		                    connection.expire(key, expiredSeconds);
	                	}
	                }
	                return 1L;
	            }
	        });
	}
    @Override
	public void expire(String key,final int expireTime,TimeUnit unit){
		redisTemplate.expire(key,expireTime,unit);
	}

	public long getExpire(String key){
		return redisTemplate.getExpire(key);
	}

	@Override
	public void setHashObject(final String key, final String field,final Object value,final int expired){
		redisTemplate.opsForHash().put(key,field,value);
	}



	@Override
	public void setHashObjectWithPiple(final String key, final Map<String, Object> values,final int expired) {
		if(!exists(key)){
			long start = System.currentTimeMillis();
			redisTemplate.execute(new RedisCallback<Object>(){
				@Override
				public Object doInRedis(RedisConnection connection){
					connection.hSet(key.getBytes(),"PLACEHOLDER".getBytes(), "占位符".getBytes());
					return null;
				}
			});
			logger.info("setHashObjectWithPiple 占位执行完成，占位用时(ms)={}",(System.currentTimeMillis()-start));
			start = System.currentTimeMillis();
			redisTemplate.execute(new RedisCallback<Object>() {
				@Override
				public Object doInRedis(RedisConnection connection){
					Set<String> mapKeys = values.keySet();
					Iterator<String> it = mapKeys.iterator();
					connection.watch(key.getBytes());
					connection.multi();
					while(it.hasNext()){
						String mapKey = it.next();
						Object object = values.get(mapKey);
						connection.hSet(key.getBytes(),mapKey.getBytes(), toByteArray(object));
					}
					connection.hDel(key.getBytes(), "PLACEHOLDER".getBytes());
					if(expired>0){
						connection.expire(key.getBytes(), expired);
					}
					connection.exec();
					return null;
				}
			});
			logger.info("setHashObjectWithPiple管道方法执行查库完成,命令数量为：{},执行用时(ms)={}",values.size(),(System.currentTimeMillis()-start));
		 }else{
			logger.info("setHashObjectWithPiple方法，未执行管道，因为key:{} 已经存在！",key);
		 }

	}

	@Override
	public Object getHashObject(final String key,final String field) {
		return redisTemplate.opsForHash().get(key,field);
	}

	@Override
	public Object getHashObject(final String key,final String field,int threadSleepMilliseconds){
		Object object = getHashObject(key,field);
		if(object == null){
			try {
				Thread.sleep(threadSleepMilliseconds);
				object = getHashObject(key,field);
			} catch (InterruptedException e) {
				logger.info("执行getHashObject方法时，线程被打断，原因："+ e.getMessage());
				logger.error("执行getHashObject方法时，线程被打断，堆栈信息：" + e.getStackTrace());
			}
		}
		if(object == null){
			logger.warn("尝试线程休眠后,获取的数据为空，key:{},field:{},threadSleep(ms);{}",key,field);
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getHashObject(final String key) {
		Map<Object,Object> dataMap=redisTemplate.opsForHash().entries(key);
		List<Object> objects = new ArrayList<>();
		for (Map.Entry<Object, Object> entry : dataMap.entrySet()) {
			objects.add(entry.getValue());
		}
		return objects;
	}

	@Override
	public List<?> scanHashData(final String key,final String fieldMatch,final long count) {
		if(!exists(key)){
			logger.error("调用scanHashData方法,redis中无此key:{},请检查！！！",key);
			return null;
		}
		long start = System.currentTimeMillis();
		List<?> objects = redisTemplate.execute(new RedisCallback<List<?>>() {
			@Override
			public List<?> doInRedis(RedisConnection connection){
				List<Object> list = new ArrayList<>();
				ScanOptions scanOption = ScanOptions.scanOptions().match(fieldMatch).count(count).build();
				Cursor<Entry<byte[], byte[]>> cursor = connection.hScan(key.getBytes(), scanOption);
				while(cursor.hasNext()){
					Entry<byte[], byte[]> object = cursor.next();
					byte[] value = object.getValue();
					list.add(toObject(value));
				}
				return list;
			}
		});
		logger.info("scanHashData方法执行查库完成,查询数据量为：{},返回数据量为：{},执行用时(ms)={}",count,objects.size());
		return objects;
	}

	/**
	 * 删除
	 * @param key
	 * @param field
	 */
	@Override
	public void removeHashObject(final String key,final String field) {
		redisTemplate.opsForHash().delete(key,field);
	}

	@Override
	public boolean hasHashKey(String key, String field) {
		return redisTemplate.opsForHash().hasKey(key,field);
	}

	@Override
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public void setObject(String key, Serializable value, int expiredSeconds, boolean cover) {
		if(cover){
			setObject(key, value,expiredSeconds);
		}else{
			if(!exists(key)){
				setObject(key, value,expiredSeconds);
			}
		}
	}

	/**
	 * increment有bug
	 * 对key值进行加1
	 * @param key
	 * @return
	 */
	public int incrInt(String key) {
		Long expire = redisTemplate.getExpire(key);
		Object o = redisTemplate.opsForValue().get(key);
		if (o!=null){
			int i = (Integer)o;
			if (expire>0){
				redisTemplate.opsForValue().set(key,++i,expire);
			}else {
				redisTemplate.opsForValue().set(key,++i);
			}
			return i;
		}else {
			redisTemplate.opsForValue().set(key,1);
			return 1;
		}
	}

}
