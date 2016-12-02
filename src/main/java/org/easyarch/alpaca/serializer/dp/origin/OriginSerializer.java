package org.easyarch.alpaca.serializer.dp.origin;

import org.easyarch.alpaca.serializer.dp.BaseSerializer;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 上午2:39
 */

public class OriginSerializer<T> extends BaseSerializer<T> {

    public byte[] serialize(T bean) {
        return new byte[0];
    }

    public T deserialize(byte[] bytes, Class<T> cls) {
        return null;
    }
}
