package org.easyarch.alpaca.serializer.component.annotation;/**
 * Description :
 * Created by YangZH on 16-11-27
 * 下午12:48
 */

import java.lang.annotation.*;

/**
 * Description : 
 * Created by code4j on 16-11-27
 *  下午12:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Member {
    String name() default "";
//    byte sortId();
}
