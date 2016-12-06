package org.easyarch.alpaca.serializer.component;

import com.dyuproject.protostuff.Schema;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 上午1:58
 */

public class ClassPool {
    public static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();
    public static Map<Class<?>, Set<String>> excludedFields = new ConcurrentHashMap<Class<?>, Set<String>>();
    public static Map<Class<?>, Set<String>> includedFields = new ConcurrentHashMap<Class<?>, Set<String>>();

}
