package com.example.factorybean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 13:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {FactoryBeanApplication.class})
public class ClockFactoryTests {
    @Autowired
    private ClockFactory clockFactory1;
    @Autowired
    private ClockFactory clockFactory2;
    @Autowired
    private Clock clock1;
    @Autowired
    private Clock clock2;

    @Test
    void testClockFactoryInject() {
        Assertions.assertSame(clockFactory1, clockFactory2);
        Assertions.assertNotSame(clock1, clock2);
    }
}
