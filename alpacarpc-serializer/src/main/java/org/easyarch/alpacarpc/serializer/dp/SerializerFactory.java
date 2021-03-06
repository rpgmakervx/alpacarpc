package org.easyarch.alpacarpc.serializer.dp;

import org.easyarch.alpacarpc.common.annotation.Transient;
import org.easyarch.alpacarpc.common.bean.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.easyarch.alpacarpc.serializer.component.FieldPool.excludedFields;
import static org.easyarch.alpacarpc.serializer.component.FieldPool.includedFields;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 上午10:11
 */

public class SerializerFactory {

    static {
        scan(Person.class);
    }
    private static void scan(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Set<String> exclutions = new HashSet<String>();
        Set<String> inclusions = new HashSet<String>();
        for (Field f : fields) {
            Annotation transients = f.getAnnotation(Transient.class);
            if (transients != null) {
                exclutions.add(f.getName());
            }else{
                inclusions.add(f.getName());
            }
        }
        excludedFields.put(clazz,exclutions);
        includedFields.put(clazz,inclusions);
    }

    public static void createSerializer(){

    }

}
