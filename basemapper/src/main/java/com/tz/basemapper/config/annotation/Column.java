package com.tz.basemapper.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: Column
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 18:40
 * @version: 1.0
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value() default "";

    boolean primary() default false;
}
