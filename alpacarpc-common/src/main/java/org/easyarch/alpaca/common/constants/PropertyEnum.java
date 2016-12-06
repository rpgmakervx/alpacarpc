package org.easyarch.alpaca.common.constants;

/**
 * Description :
 * Created by xingtianyu on 16-12-5
 * 下午7:33
 * TODO:配置文件属性信息和默认值
 */
public enum  PropertyEnum {

    ENVIRONMENT("alpaca.environment","test"),
    PROTOCOL_KEY("alpaca.rpc.protocol","protobuf");

    private String property;
    private String def;
    PropertyEnum(String property,String def){
        this.property = property;
        this.def = def;
    }

    public String getProperty() {
        return property;
    }

    public String getDef() {
        return def;
    }
}
