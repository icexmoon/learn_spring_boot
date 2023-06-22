package com.example.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 10:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {CacheApplication.class})
@Import(ClockConfig.class)
public class FibonacciService3Tests {
    @Autowired
    FibonacciService3 fibonacciService;

    @Test
    void testFibonacci() {
        var result = fibonacciService.fibonacci(40);
        Assertions.assertEquals(102334155L, result);
        var result2 = fibonacciService.fibonacci(40);
        Assertions.assertEquals(result2, result);
        fibonacciService.fibonacci(39);
    }
}
