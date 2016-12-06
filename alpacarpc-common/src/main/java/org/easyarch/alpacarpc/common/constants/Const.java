package org.easyarch.alpacarpc.common.constants;

import org.easyarch.alpacarpc.common.config.Configuration;

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

}
