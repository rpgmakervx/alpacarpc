package org.easyarch.alpacarpc.serializer.dp;

import java.io.*;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 上午2:39
 */

public class JavaSerializer<T> extends OriginSerializer<T> {

    public byte[] serialize(T bean) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(excludeFileds(bean));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }

    public T deserialize(byte[] bytes, Class<T> cls) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (bais != null){
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
