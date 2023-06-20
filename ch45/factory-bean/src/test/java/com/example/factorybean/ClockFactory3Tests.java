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
 * @createTime : 2023/6/20 16:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig
public class ClockFactory3Tests {
    @Configuration
    static class Config{
        @Bean
        public ClockFactory3 clockFactory3(){
            return new ClockFactory3();
        }
    }

    @Test
    void testInject(@Autowired Clock clock1, @Autowired Clock clock2){
        Assertions.assertSame(clock1, clock2);
    }
}
