package org.easyarch.alpaca.common.config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.easyarch.alpaca.common.constants.Const;
import org.easyarch.alpaca.common.constants.Environment;
import org.easyarch.alpaca.common.constants.PropertyEnum;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
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

    static{
        properties = new ConcurrentHashMap<>();
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(Const.ENV_CONFIG));
            String env = prop.getProperty(PropertyEnum.ENVIRONMENT.getProperty());
            System.out.println("env:"+env);
            System.out.println("conf:"+Environment.getConfPath(env));
            InputStream is = new FileInputStream(Environment.getConfPath(env));
            document = reader.read(is);
            root = document.getRootElement();
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init(){
        Iterator<Element> elementIterator = root.elementIterator();
        while (elementIterator.hasNext()) {
            Element property = elementIterator.next();
            Element name = property.element("name");
            Element value = property.element("value");
            properties.put(name.getTextTrim(),value.getTextTrim());
        }
    }

    public static Map<String,String> getProperties(){
        return properties;
    }

    public static String getProperty(String name){
        return properties.get(name);
    }
}
