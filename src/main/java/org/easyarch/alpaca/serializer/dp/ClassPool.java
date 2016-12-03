package org.easyarch.alpaca.serializer.dp;

import com.dyuproject.protostuff.Schema;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 上午1:58
 */

class ClassPool {
    public static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();
    public static Map<Class<?>, Set<String>> fieldExclusion = new ConcurrentHashMap<Class<?>, Set<String>>();

}
