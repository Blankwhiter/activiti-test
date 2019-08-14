package com.example.activititest.utils;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class CommUtil {
    /**
     * 把指定的复杂对象属性，按照指定的内容，封装到新的map中
     * @param source 目标对象
     * @param ps     需要封装到map中的属性
     * @return
     */
    public static Map<String, Object> obj2map(Object source, String[] ps) {
        Map<String, Object> map = new HashMap<>();
        if (source == null)
            return null;
        if (ps == null || ps.length < 1) {
            return null;
        }
        for (String p : ps) {
            PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(
                    source.getClass(), p);
            if (sourcePd != null && sourcePd.getReadMethod() != null) {
                try {
                    Method readMethod = sourcePd.getReadMethod();
                    if (!Modifier.isPublic(readMethod.getDeclaringClass()
                            .getModifiers())) {
                        readMethod.setAccessible(true);
                    }
                    Object value = readMethod.invoke(source, new Object[0]);
                    map.put(p, value);
                } catch (Exception ex) {
                    throw new RuntimeException(
                            "Could not copy properties from source to target",
                            ex);
                }
            }
        }
        return map;
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
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
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }


}
