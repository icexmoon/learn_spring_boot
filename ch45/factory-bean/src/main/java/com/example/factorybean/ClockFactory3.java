package com.example.factorybean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

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
public class ClockFactory3 extends AbstractFactoryBean<Clock> {
    private static int num = 0;

    public ClockFactory3() {
        super();
        setSingleton(true);
    }

    @Override
    public Class<?> getObjectType() {
        return Clock.class;
    }

    @Override
    protected Clock createInstance() throws Exception {
        return new Clock(LocalDateTime.now(), ++num);
    }
}
