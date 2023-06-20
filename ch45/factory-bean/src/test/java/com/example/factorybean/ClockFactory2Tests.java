package com.example.factorybean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 14:22
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig
public class ClockFactory2Tests {
    @Configuration
    static class Config {
        @Bean
        public ClockFactory2 clockFactory2() {
            return new ClockFactory2();
        }
    }

    @Autowired
    private ClockFactory2 clockFactory1;
    @Autowired
    private ClockFactory2 clockFactory2;
    @Autowired
    private Clock clock1;
    @Autowired
    private Clock clock2;

    @Test
    void testInject(){
        Assertions.assertSame(clockFactory1, clockFactory2);
        Assertions.assertSame(clock1, clock2);
    }
}
