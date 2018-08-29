package com.artqiyi.dahuashai.redis.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProtoStuffUtil {
    private static final Logger log = LoggerFactory.getLogger(ProtoStuffUtil.class);

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

    private ProtoStuffUtil(){}


    /**
     * 获取Schema
     * @param cls
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls);
            if (schema != null) {
                cachedSchema.put(cls, schema);
            }
        }
        return schema;
    }

	/**
     * 序列化对象
     *
     * @param obj
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        if (obj == null) {
            log.error("【序列化】 序列化失败，传入对象为空");
            throw new RuntimeException("序列化失败");
        }

        Schema<T> schema = (Schema<T>) getSchema(obj.getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] protoStuff;
        try {
            protoStuff = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            log.error("【序列化】 序列化失败, obj={},Exception={}", obj, e);
            throw new RuntimeException("序列化失败");
        } finally {
            buffer.clear();
        }
        return protoStuff;
    }

    /**
     * 反序列化对象
     *
     * @param paramArrayOfByte
     * @param targetClass
     * @return
     */
    public static <T> T deserialize(byte[] paramArrayOfByte, Class<T> targetClass) {
        if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
            log.error("【反序列化】 反序列化失败，反序列对象为空");
            throw new RuntimeException("反序列化失败");
        }

        T instance;
        try {
            instance = targetClass.newInstance();
        } catch (Exception e) {
            log.error("【反序列化】 反序列化失败：Exception={}", e);
            throw new RuntimeException("反序列化失败");
        }
        Schema<T> schema = getSchema(targetClass);
        ProtostuffIOUtil.mergeFrom(paramArrayOfByte, instance, schema);
        return instance;
    }

    /**
     * 序列化列表
     *
     * @param objList
     * @return
     */
    public static <T> byte[] serializeList(List<T> objList) {
        if (objList == null || objList.isEmpty()) {
            log.error("【序列化列表】 序列化失败，传入对象为空");
            throw new RuntimeException("Failed to serializer");
        }

        Schema<T> schema = (Schema<T>) getSchema(objList.get(0).getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] protoStuff;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
            protoStuff = bos.toByteArray();
        } catch (Exception e) {
            log.error("【序列化列表】 序列化失败, list={},Exception={}", objList, e);
            throw new RuntimeException("序列化列表失败");
        } finally {
            buffer.clear();
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return protoStuff;
    }

    /**
     * 反序列化列表
     *
     * @param paramArrayOfByte
     * @param targetClass
     * @return
     */
    public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
        if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
            log.error("【反序列化列表】 序列化失败，传入对象为空");
            throw new RuntimeException("反序列化列表失败");
        }

        Schema<T> schema = getSchema(targetClass);
        List<T> result;
        try {
            result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(paramArrayOfByte), schema);
        } catch (Exception e) {
            log.error("反序列化列表失败：Exception={}", e);
            throw new RuntimeException("反序列化列表失败");
        }
        return result;
    }

}
