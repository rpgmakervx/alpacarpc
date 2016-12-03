package org.easyarch.alpaca.serializer.dp.protobuf;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeEnv;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.apache.commons.lang3.ArrayUtils;
import org.easyarch.alpaca.serializer.component.annotation.Member;
import org.easyarch.alpaca.serializer.component.annotation.NotMember;
import org.easyarch.alpaca.serializer.component.bean.Person;
import org.easyarch.alpaca.serializer.component.bean.User;
import org.easyarch.alpaca.serializer.dp.BaseSerializer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.easyarch.alpaca.serializer.dp.protobuf.SchemaPool.cachedSchema;
import static org.easyarch.alpaca.serializer.dp.protobuf.SchemaPool.fieldExclusion;

/**
 * Description :
 * Created by xingtianyu on 16-11-27
 * 上午11:57
 */

public class ProtostuffSerializer<T> extends BaseSerializer<T> {


    private Schema<T> getSchema(Class<T> cls, Set<String> exclutions) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls, exclutions, RuntimeEnv.ID_STRATEGY);
            if (schema != null) {
                cachedSchema.put(cls, schema);
            }
        }
        return schema;
    }

    static {
        fieldExclusion.put(Person.class,scan(Person.class));
        fieldExclusion.put(User.class,scan(User.class));
    }
    @Override
    public byte[] serialize(T object) {
        if (object == null){
            return null;
        }
        Class<T> clazz = (Class<T>) object.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        Schema<T> schema = getSchema(clazz, fieldExclusion.get(clazz));
        byte[] bytes = ProtobufIOUtil.toByteArray(object, schema, buffer);
        return bytes;
    }

    @Override
    public T deserialize(byte[] bytes, Class<T> clazz) {
        if (ArrayUtils.isEmpty(bytes)){
            return null;
        }
        try {
            T message = clazz.newInstance();
            Schema<T> schema = getSchema(clazz, fieldExclusion.get(clazz));
            ProtobufIOUtil.mergeFrom(bytes, message, schema);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Set<String> scan(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Set<String> exclutions = new HashSet<String>();
        for (Field f : fields) {
            Annotation member = f.getAnnotation(Member.class);
            Annotation notMember = f.getAnnotation(NotMember.class);
            if (member == null || notMember != null) {
                exclutions.add(f.getName());
            }
        }
        return exclutions;
    }

}
