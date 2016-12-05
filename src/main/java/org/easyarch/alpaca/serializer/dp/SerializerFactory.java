package org.easyarch.alpaca.serializer.dp;

import org.easyarch.alpaca.serializer.component.annotation.Transient;
import org.easyarch.alpaca.serializer.component.bean.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.easyarch.alpaca.serializer.component.ClassPool.excludedFields;
import static org.easyarch.alpaca.serializer.component.ClassPool.includedFields;

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
