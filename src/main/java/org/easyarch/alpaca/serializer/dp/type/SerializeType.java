package org.easyarch.alpaca.serializer.dp.type;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 上午10:36
 */

public enum SerializeType {
    JAVA(0),JSON(1),HESSIAN(2),PROTOBUF(3);
    private int code;

    SerializeType(int code) {
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
