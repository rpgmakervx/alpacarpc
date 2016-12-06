package org.easyarch.alpaca.common.pool;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Description :
 * Created by xingtianyu on 16-12-6
 * 下午11:40
 */

public class ClassPool {

    public static Set<Class> transportClasses = new CopyOnWriteArraySet<>();
}
