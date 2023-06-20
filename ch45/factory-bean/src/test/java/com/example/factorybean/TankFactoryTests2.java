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
 * @createTime : 2023/6/20 15:26
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig
public class TankFactoryTests2 {
    @Configuration
    static class Config{
        @Bean
        public TankFactory tankFactory(){
            return new TankFactory("", null);
        }
    }
    @Autowired
    private Tank tank1;
    @Autowired
    private Tank tank2;

    @Test
    void testInject(){
        Assertions.assertNotSame(tank1, tank2);
    }
}
