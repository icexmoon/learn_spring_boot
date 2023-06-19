package com.example.test.service;

import com.example.test.FibonacciService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 15:01
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
public class TestFibonacciService10 {
    @Autowired
    private FibonacciService fibonacciService;
    @Autowired
    private String msg;

    @TestConfiguration
    static class Config{
        @Bean String msg(){
            return "hello";
        }
    }

    @Test
    void testMsg(){
        Assertions.assertEquals("hello", msg);
    }

    @Test
    void testFibonacci() {
        int[] fibonacciArr = new int[]{1, 1, 2, 3, 5, 8};
        for (int i = 0; i < fibonacciArr.length; i++) {
            Assertions.assertEquals(fibonacciArr[i], fibonacciService.fibonacci(i + 1));
        }
        int[] errorIndexes = new int[]{0, -1, -2};
        for (int ei : errorIndexes) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> fibonacciService.fibonacci(ei));
        }
    }
}
