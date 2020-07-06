/*
 * Copyright 1999-2020 Mitbook Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mitbook.common.utils;

import com.mitbook.annotation.RestController;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author pengzhengfa
 */
@Component
@Lazy(value = false)
public class SpringContextHolder implements ApplicationContextAware, InitializingBean, DisposableBean {

    private static ApplicationContext applicationContext;
    private List<Class<?>> controllerClass;

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
        this.controllerClass = loadControllerClass(applicationContext);
    }

    @Override
    public void destroy() {
        SpringContextHolder.applicationContext = null;
    }

    public List<Class<?>> loadControllerClass(ApplicationContext ctx) {
        final Class<? extends Annotation> clazz = RestController.class;
        return ctx.getBeansWithAnnotation(clazz)
                .values().stream()
                .map(AopUtils::getTargetClass)
                .filter(cls -> Objects.nonNull(cls.getAnnotation(clazz)))
                .collect(Collectors.toList());
    }

    public List<Class<?>> loadControllerClass() {
        return controllerClass;
    }

    @Override
    public void afterPropertiesSet() {

    }
}
