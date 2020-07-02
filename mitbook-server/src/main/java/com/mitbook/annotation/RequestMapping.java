package com.mitbook.annotation;

import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * @author pengzhengfa
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequestMapping {

    String uri() default "";

    RequestMethod method() default RequestMethod.GET;
}
