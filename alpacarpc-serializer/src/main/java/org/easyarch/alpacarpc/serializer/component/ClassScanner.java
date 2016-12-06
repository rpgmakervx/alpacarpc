package org.easyarch.alpacarpc.serializer.component;

import org.easyarch.alpacarpc.common.annotation.RPCEntity;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.easyarch.alpacarpc.common.pool.ClassPool.transportClasses;

/**
 * Description :
 * Created by xingtianyu on 16-12-5
 * 下午8:55
 */

public class ClassScanner {

    public void scanByClass(String classpath){

    }

    public Set<Class> scanByJar(String jarpath){
        Set<Class> clazzs = new HashSet<>();
        Pattern pattern = Pattern.compile(".*\\.(class)");
        Matcher matcher = null;
        try {
            File file = new File(jarpath);
            if (!file.isDirectory()){
                return clazzs;
            }
            File[] files = file.listFiles(pathname -> pathname.getName().endsWith(".jar"));
            for (File f : files){
                JarFile jarFile = new JarFile(f.getAbsoluteFile());
                Enumeration<JarEntry> entrys = jarFile.entries();
                while (entrys.hasMoreElements()) {
                    JarEntry jarEntry = entrys.nextElement();
                    String filename = jarEntry.getName();
                    if (matcher == null){
                        matcher = pattern.matcher(filename);
                    }else{
                        matcher.reset(filename);
                    }
                    if (matcher.matches()){
                        filename = filename.substring(0, filename.lastIndexOf(".")).replace(File.separator,".");
                        URL[] urls = new URL[]{new URL("file:"+jarpath)};
                        URLClassLoader classLoader = new URLClassLoader(urls);
                        Class clazz = classLoader.loadClass(filename);
                        if (clazz.getAnnotation(RPCEntity.class) != null){
                            clazzs.add(clazz);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzs;
    }

    public void scanByPackage(){
        transportClasses.addAll(new ClassScanner().scanByJar(""));
    }


    public static void main(String[] args) {

    }
}
