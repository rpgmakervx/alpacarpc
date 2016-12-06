package org.easyarch.alpaca.serializer.dp.type;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 上午10:36
 */

public enum SerializeType {
    JAVA("java"),JSON("json"),HESSIAN("hessian"),PROTOBUF("protobuf");
    private String type;

    SerializeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
