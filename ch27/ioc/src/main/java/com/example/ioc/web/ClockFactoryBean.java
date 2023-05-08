package com.example.ioc.web;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/8 20:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class ClockFactoryBean implements FactoryBean<SimpleClock> {
    private static int i = 0;
    @Override
    public SimpleClock getObject() throws Exception {
        return new SimpleClock(LocalDateTime.now(), i++);
    }

    @Override
    public Class<?> getObjectType() {
        return SimpleClock.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
