package org.easyarch.alpaca.common.constants;

import org.easyarch.alpaca.common.config.Configuration;

import java.io.File;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 下午6:35
 */

public class Const {

    public static final String DEPLOY_ROOTPATH =
            System.getProperty("user.dir") + File.separator + ".." + File.separator;
    public static final String TEST_RESOURCE = Configuration.class.getResource("/").getPath();
    public static final String DEPLOY_RESOURCE = DEPLOY_ROOTPATH + "conf" + File.separator;
    public static final String ENV_CONFIG = Configuration
            .class.getResource("")
            .getPath() +
            File.separator +
            "environment.properties";

    public static final String ENVIRONMENT = "alpaca.environment";
    public static final String PROTOCOL_KEY = "alpaca.rpc.protocol";
}
