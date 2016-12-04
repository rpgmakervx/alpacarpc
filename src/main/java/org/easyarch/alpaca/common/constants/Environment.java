package org.easyarch.alpaca.common.constants;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 下午6:43
 */

public enum Environment {
    ONLINE("online"),OFFLINE("offline");
    public String env;

    Environment(String env){
        this.env = env;
    }
}
