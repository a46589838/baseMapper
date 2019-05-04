package com.tz.basemapper.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: TableName
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 16:57
 * @version: 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value() default "";
}
