package com.example.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 13:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class ClockFactory implements FactoryBean<Clock> {
    private static int num = 0;

    @Override
    public Clock getObject() throws Exception {
        return new Clock(LocalDateTime.now(), ++num);
    }

    @Override
    public Class<?> getObjectType() {
        return Clock.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public String toString() {
        return "ClockFactory(num=%d)".formatted(num);
    }
}
