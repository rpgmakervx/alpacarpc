package org.easyarch.alpaca.serializer.dp;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.apache.commons.lang3.ArrayUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 下午8:48
 */

public class HessianSerializer<T> extends OriginSerializer<T> implements Serializer<T> {
    public byte[] serialize(T bean) {
        if (bean == null){
            return null;
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        try {
            ho.startMessage();
            ho.writeObject(bean);
            ho.completeMessage();
            ho.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return os.toByteArray();
    }

    public T deserialize(byte[] bytes, Class<T> cls) {
        if (ArrayUtils.isEmpty(bytes)){
            return null;
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Hessian2Input hi = new Hessian2Input(bais);

        Object bean = null;
        try {
            hi.startMessage();
            bean = hi.readObject();
            hi.completeMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bais != null){
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (T) bean;
    }
}
