package org.easyarch.alpaca.serializer.dp.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import org.apache.commons.lang3.ArrayUtils;
import org.easyarch.alpaca.serializer.dp.BaseSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 下午8:48
 */

public class HessianSerializer<T> extends BaseSerializer<T> {
    public byte[] serialize(T bean) {
        if (bean == null){
            return null;
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        try {
            ho.writeObject(bean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return os.toByteArray();
    }

    public T deserialize(byte[] bytes, Class<T> cls) {
        if (ArrayUtils.isEmpty(bytes)){
            return null;
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        HessianInput hi = new HessianInput(bais);
        try {
            return (T) hi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
