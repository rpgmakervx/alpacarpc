package org.easyarch.alpacarpc.serializer.component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 上午1:58
 */

public class FieldPool {
    public static Map<Class<?>, Set<String>> excludedFields = new ConcurrentHashMap<Class<?>, Set<String>>();
    public static Map<Class<?>, Set<String>> includedFields = new ConcurrentHashMap<Class<?>, Set<String>>();

}
