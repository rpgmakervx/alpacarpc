package org.easyarch.alpacarpc.common.constants;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 下午6:43
 */

public enum Environment {
    TEST("test",Const.TEST_RESOURCE+"alpacarpc.xml"),DEPLOY("deploy",Const.DEPLOY_RESOURCE+"alpacarpc.xml");
    public String env;
    public String confPath;
    Environment(String env,String confPath){
        this.env = env;
        this.confPath = confPath;
    }


    public static String getConfPath(String env) {
        for (Environment envroment:Environment.values()){
            if (env.equalsIgnoreCase(envroment.env)){
                return envroment.confPath;
            }
        }
        return DEPLOY.confPath;
    }
}
