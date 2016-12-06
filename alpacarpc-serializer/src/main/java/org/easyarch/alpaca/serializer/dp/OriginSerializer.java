package org.easyarch.alpaca.serializer.dp;

import java.util.Set;

import static org.easyarch.alpaca.serializer.component.FieldPool.includedFields;

/**
 * Description :
 * Created by xingtianyu on 16-12-6
 * 下午6:37
 */

abstract public class OriginSerializer<T> implements Serializer<T> {

    protected T excludeFileds(T bean){
        Set<String> fieldNames = includedFields.get(bean.getClass());
        T newBean = null;
        try {
            Class<T> cls = (Class<T>) bean.getClass();
            newBean = (T) bean.getClass().newInstance();
            for (String fieldName : fieldNames){
                Object oldVal = cls.getField(fieldName).get(bean);
                cls.getDeclaredField(fieldName).set(newBean,oldVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newBean;
    }
}
