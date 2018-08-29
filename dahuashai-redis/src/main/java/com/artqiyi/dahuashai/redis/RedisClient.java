package com.artqiyi.dahuashai.redis;

import com.artqiyi.dahuashai.redis.serializer.ProtoStuffUtil;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Component
public class RedisClient {
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisClient(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * get cache
     *
     * @param key
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> T get(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.get(key.getBytes()));
        if (result == null) {
            return null;
        }

        return ProtoStuffUtil.deserialize(result, targetClass);
    }

    /**
     * put cache
     *
     * @param key
     * @param obj
     * @param <T>
     * @return
     */
    public <T> void set(String key, T obj) {
        final byte[] value = ProtoStuffUtil.serialize(obj);
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.set(key.getBytes(), value);
            return null;
        });
    }

    /**
     * setNx
     *
     * @param key
     * @param obj
     * @param <T>
     * @return
     */
    public <T> Boolean setNx(String key, T obj) {
        final byte[] value = ProtoStuffUtil.serialize(obj);
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            return connection.setNX(key.getBytes(), value);
        });
    }

    /**
     * exists
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.exists(key.getBytes()));
    }

    /**
     * del
     *
     * @param key
     */
    public void del(String key) {
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.del(key.getBytes());
            return null;
        });
    }

    /**
     * incr key
     *
     * @param key
     * @return
     */
    public Long incr(String key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.incr(key.getBytes()));
    }

    /**
     * put cache with expire time
     *
     * @param key
     * @param obj
     * @param expireTime 单位: s
     * @param <T>
     */
    public <T> void setWithExpire(String key, T obj, final long expireTime) {
        final byte[] value = ProtoStuffUtil.serialize(obj);
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.setEx(key.getBytes(), expireTime, value);
            return null;
        });
    }

    /**
     * ttl
     *
     * @param key
     * @return
     */
    public long ttl(String key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.ttl(key.getBytes()));
    }

    /**
     * get list cache
     *
     * @param key
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> List<T> getList(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.get(key.getBytes()));
        if (result == null) {
            return null;
        }

        return ProtoStuffUtil.deserializeList(result, targetClass);
    }

    /**
     * put list cache
     *
     * @param key
     * @param objList
     * @param <T>
     * @return
     */
    public <T> void setList(String key, List<T> objList) {
        final byte[] value = ProtoStuffUtil.serializeList(objList);
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.set(key.getBytes(), value);
            return null;
        });
    }

    /**
     * put list cache with expire time
     *
     * @param key
     * @param objList
     * @param expireTime
     * @param <T>
     * @return
     */
    public <T> void setListWithExpire(String key, List<T> objList, final long expireTime) {
        final byte[] value = ProtoStuffUtil.serializeList(objList);
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.setEx(key.getBytes(), expireTime, value);
            return null;
        });
    }

    /**
     * get h cache
     *
     * @param key
     * @param field
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> T hGet(final String key, final String field, Class<T> targetClass) {
        byte[] result = redisTemplate
                .execute((RedisCallback<byte[]>) connection -> connection.hGet(key.getBytes(), field.getBytes()));
        if (result == null) {
            return null;
        }

        return ProtoStuffUtil.deserialize(result, targetClass);
    }

    /**
     * put hash cache
     *
     * @param key
     * @param field
     * @param obj
     * @param <T>
     * @return
     */
    public <T> boolean hSet(String key, String field, T obj) {
        final byte[] value = ProtoStuffUtil.serialize(obj);
        return redisTemplate.execute(
                (RedisCallback<Boolean>) connection -> connection.hSet(key.getBytes(), field.getBytes(), value));
    }

    /**
     * hExists
     *
     * @param key
     * @param field
     */
    public Boolean hExists(String key, String field) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.hExists(key.getBytes(), field.getBytes()));
    }

    /**
     * hDel
     *
     * @param key
     * @param field
     */
    public void hDel(String key, String field) {
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.hDel(key.getBytes(), field.getBytes());
            return null;
        });
    }

    /**
     * hLen
     *
     * @param key
     */
    public Long hLen(String key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> {
            return connection.hLen(key.getBytes());
        });
    }


    /**
     * put hash cache
     *
     * @param key
     * @param field
     * @param obj
     * @param <T>
     */
    public <T> void hSetWithExpire(String key, String field, T obj, long expireTime) {
        final byte[] value = ProtoStuffUtil.serialize(obj);
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.hSet(key.getBytes(), field.getBytes(), value);
            connection.expire(key.getBytes(), expireTime);
            return null;
        });
    }

    /**
     * get list cache
     *
     * @param key
     * @param field
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> List<T> hGetList(final String key, final String field, Class<T> targetClass) {
        byte[] result = redisTemplate
                .execute((RedisCallback<byte[]>) connection -> connection.hGet(key.getBytes(), field.getBytes()));
        if (result == null) {
            return null;
        }

        return ProtoStuffUtil.deserializeList(result, targetClass);
    }

    /**
     * put list cache
     *
     * @param key
     * @param field
     * @param objList
     * @param <T>
     * @return
     */
    public <T> boolean hSetList(String key, String field, List<T> objList) {
        final byte[] value = ProtoStuffUtil.serializeList(objList);
        return redisTemplate.execute(
                (RedisCallback<Boolean>) connection -> connection.hSet(key.getBytes(), field.getBytes(), value));
    }

    /**
     * get cache by keys
     *
     * @param key
     * @param fields
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> Map<String, T> hMGet(String key, Collection<String> fields, Class<T> targetClass) {
        List<byte[]> byteFields = fields.stream().map(String::getBytes).collect(Collectors.toList());
        byte[][] queryFields = new byte[byteFields.size()][];
        byteFields.toArray(queryFields);
        List<byte[]> cache = redisTemplate
                .execute((RedisCallback<List<byte[]>>) connection -> connection.hMGet(key.getBytes(), queryFields));

        Map<String, T> results = new HashMap<>(16);
        Iterator<String> it = fields.iterator();
        int index = 0;
        while (it.hasNext()) {
            String k = it.next();
            if (cache.get(index) == null) {
                index++;
                continue;
            }

            results.put(k, ProtoStuffUtil.deserialize(cache.get(index), targetClass));
            index++;
        }

        return results;
    }

    /**
     * set cache by keys
     *
     * @param key
     * @param values
     * @param <T>
     */
    public <T> void hMSet(String key, Map<String, T> values) {
        Map<byte[], byte[]> byteValues = new HashMap<>(16);
        for (Map.Entry<String, T> value : values.entrySet()) {
            byteValues.put(value.getKey().getBytes(), ProtoStuffUtil.serialize(value.getValue()));
        }

        redisTemplate.execute((RedisCallback<Void>) connection -> {
            connection.hMSet(key.getBytes(), byteValues);
            return null;
        });
    }

    /**
     * get caches in hash
     *
     * @param key
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> Map<String, T> hGetAll(String key, Class<T> targetClass) {
        Map<byte[], byte[]> records = redisTemplate
                .execute((RedisCallback<Map<byte[], byte[]>>) connection -> connection.hGetAll(key.getBytes()));

        Map<String, T> ret = new HashMap<>(16);
        for (Map.Entry<byte[], byte[]> record : records.entrySet()) {
            T obj = ProtoStuffUtil.deserialize(record.getValue(), targetClass);
            ret.put(new String(record.getKey()), obj);
        }

        return ret;
    }

    /**
     * list index
     *
     * @param key
     * @param index
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> T lIndex(String key, int index, Class<T> targetClass) {
        byte[] value =
                redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.lIndex(key.getBytes(), index));
        return ProtoStuffUtil.deserialize(value, targetClass);
    }

    /**
     * list range
     *
     * @param key
     * @param start
     * @param end
     * @param targetClass
     * @param <T>
     * @return
     */
    public <T> List<T> lRange(String key, int start, int end, Class<T> targetClass) {
        List<byte[]> value = redisTemplate
                .execute((RedisCallback<List<byte[]>>) connection -> connection.lRange(key.getBytes(), start, end));
        return value.stream().map(record -> ProtoStuffUtil.deserialize(record, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * list left push
     *
     * @param key
     * @param obj
     * @param <T>
     */
    public <T> void lPush(String key, T obj) {
        final byte[] value = ProtoStuffUtil.serialize(obj);
        redisTemplate.execute((RedisCallback<Long>) connection -> connection.lPush(key.getBytes(), value));
    }

    /**
     * list left push
     *
     * @param key
     * @param objList
     * @param <T>
     */
    public <T> void lPush(String key, List<T> objList) {
        List<byte[]> byteFields = objList.stream().map(ProtoStuffUtil::serialize).collect(Collectors.toList());
        byte[][] values = new byte[byteFields.size()][];

        redisTemplate.execute((RedisCallback<Long>) connection -> connection.lPush(key.getBytes(), values));
    }

    /**
     * 排行榜的存入
     *
     * @param redisKey
     * @param immutablePair
     */
    public <T> void zAdd(String redisKey, ImmutablePair<T, BigDecimal> immutablePair) {
        final byte[] key = redisKey.getBytes();
        final byte[] value = ProtoStuffUtil.serialize(immutablePair.left);
        redisTemplate.execute((RedisCallback<Boolean>) connection -> connection
                .zAdd(key, immutablePair.getRight().doubleValue(), value));

    }

    /**
     * 获取排行榜低->高排序
     *
     * @param redisKey 要进行排序的类别
     * @param start
     * @param end
     * @return
     */
    public <T> List<ImmutablePair<T, BigDecimal>> zRangeWithScores(String redisKey, int start, int end, Class<T> targetClass) {
        Set<RedisZSetCommands.Tuple> items = redisTemplate.execute(
                (RedisCallback<Set<RedisZSetCommands.Tuple>>) connection -> connection
                        .zRangeWithScores(redisKey.getBytes(), start, end));

        return items.stream()
                .map(record -> ImmutablePair.of(ProtoStuffUtil.deserialize(record.getValue(), targetClass), BigDecimal.valueOf(record.getScore())))
                .collect(Collectors.toList());
    }


    /**
     * 获取排行榜高->低排序
     *
     * @param redisKey 要进行排序的类别
     * @param start
     * @param end
     * @return
     */
    public <T> List<ImmutablePair<T, BigDecimal>> zRevRangeWithScores(String redisKey, int start, int end, Class<T> targetClass) {
        Set<RedisZSetCommands.Tuple> items = redisTemplate.execute(
                (RedisCallback<Set<RedisZSetCommands.Tuple>>) connection -> connection
                        .zRevRangeWithScores(redisKey.getBytes(), start, end));
        return items.stream()
                .map(record -> ImmutablePair.of(ProtoStuffUtil.deserialize(record.getValue(), targetClass), BigDecimal.valueOf(record.getScore())))
                .collect(Collectors.toList());
    }


    /**
     * 获取某成员的排名(从小到大)
     *
     * @param key
     * @param member
     * @param <T>
     * @return
     */
    public <T> Long zRank(String key, T member) {
        byte[] mBytes = ProtoStuffUtil.serialize(member);
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRank(key.getBytes(), mBytes));
    }


    /**
     * 获取某成员的排名(从大到小)
     *
     * @param key
     * @param member
     * @param <T>
     * @return
     */
    public <T> Long zRevRank(String key, T member) {
        byte[] mBytes = ProtoStuffUtil.serialize(member);
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.zRevRank(key.getBytes(), mBytes));
    }
}
