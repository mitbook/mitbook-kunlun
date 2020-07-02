package com.mitbook.annotation;

import com.mitbook.common.Constant;

import java.lang.annotation.*;

/**
 * @author pengzhengfa
 */
@Target(value = ElementType.PARAMETER)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequestParam {

    String name();

    boolean required() default true;

    String defaultValue() default Constant.EMPTY;
}
