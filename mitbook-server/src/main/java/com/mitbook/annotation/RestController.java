package com.mitbook.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author pengzhengfa
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Component
public @interface RestController {

}