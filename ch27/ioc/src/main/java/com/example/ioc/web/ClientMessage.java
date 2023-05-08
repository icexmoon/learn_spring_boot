package com.example.ioc.web;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/6 17:15
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 保存由客户端传入的信息
 */
@Data
@Component
@RequestScope
public class ClientMessage implements ApplicationContextAware {
    String message;

    @PostConstruct
    public void afterPropertiesSet() {
        System.out.println("ClientMessage Instance is build.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ClientMessage Instance is will destroyed, message is %s.".formatted(message));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ctx is get.");
        System.out.println(applicationContext.getBean("cal"));
    }
}
