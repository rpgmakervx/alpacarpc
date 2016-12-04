package org.easyarch.alpaca.common.config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.easyarch.alpaca.common.constants.Const;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 下午5:40
 */

public class Configuration {

    private static SAXReader reader = new SAXReader();
    private static Document document = null;
    private static Element root = null;

    private static Map<String,String> properties ;
    public static void init(){
        properties = new ConcurrentHashMap<>();
        try {
            InputStream is = new FileInputStream(Const.TESTROOTPATH);
            document = reader.read(is);
            root = document.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Configuration.class.getResource("/").getPath());
    }
}
