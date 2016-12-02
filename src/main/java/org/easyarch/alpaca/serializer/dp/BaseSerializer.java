package org.easyarch.alpaca.serializer.dp;

/**
 * Description :
 * Created by xingtianyu on 16-11-30
 * 上午9:29
 */

abstract public class BaseSerializer<T> {

    abstract public byte[] serialize(T bean);

    abstract public T deserialize(byte[] bytes,Class<T> cls);
}
