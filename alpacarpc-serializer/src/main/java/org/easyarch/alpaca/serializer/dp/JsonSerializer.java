package org.easyarch.alpaca.serializer.dp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import org.apache.commons.lang3.ArrayUtils;

import java.nio.charset.Charset;
import java.util.Set;

import static org.easyarch.alpaca.serializer.component.FieldPool.excludedFields;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 上午9:44
 */

public class JsonSerializer<T> implements Serializer<T> {

    @Override
    public byte[] serialize(T bean) {
        if (bean == null)
            return null;
        Set<String> exclusion = excludedFields.get(bean.getClass());
        PropertyFilter filter = new PropertyFilter() {
            @Override
            public boolean apply(Object object, String name, Object value) {
                return exclusion.contains(name);
            }
        };
        return JSON.toJSONString(bean,filter).getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public T deserialize(byte[] bytes, Class<T> cls) {
        if (ArrayUtils.isEmpty(bytes))
            return null;
        return JSON.parseObject(bytes,0,bytes.length, Charset.forName("UTF-8"),cls);
    }
}
