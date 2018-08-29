package com.artqiyi.dahuashai.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Map转换器
 * author: chencunjun
 * date:2018/4/17.
 */
public class MapConventUtil {

    /**
     * bean对象转为map对象
     * @param obj
     * @return
     */
    public static Map<String, Object> obj2Map(Object obj)  {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(obj == null){
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * map转bean对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object map2Obj(Map<String, Object> map, Class<?> beanClass)  {
        try {
            if (map == null)
                return null;

            Object obj = beanClass.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }

                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }

            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }
}
