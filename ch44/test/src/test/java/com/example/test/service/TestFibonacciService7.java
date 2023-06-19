package com.example.test.service;

import com.example.test.FibonacciService;
import com.example.test.FibonacciUtil;
import lombok.SneakyThrows;
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
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 15:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig
public class TestFibonacciService7 {
    @Configuration
    public static class Config {
        @SneakyThrows
        @Bean
        FibonacciService fibonacciService() {
            FibonacciService fibonacciService = new FibonacciService();
            return fibonacciService;
        }

        @Bean
        FibonacciUtil fibonacciUtil(){
            return new FibonacciUtil();
        }
    }

    @Autowired
    private FibonacciService fibonacciService;

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
