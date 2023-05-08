package com.example.ioc.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.ScopeNotActiveException;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/8 18:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class PrintBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            System.out.println("#%d bean %s is created: %s".formatted(getOrder(), beanName, bean));
        } catch (ScopeNotActiveException e) {
            ;
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
