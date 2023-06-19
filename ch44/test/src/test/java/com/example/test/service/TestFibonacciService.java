package com.example.test.service;

import com.example.test.FibonacciService;
import com.example.test.FibonacciUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 14:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
//@ExtendWith(SpringExtension.class)
public class TestFibonacciService {
    private static FibonacciService fibonacciService = new FibonacciService();

    @SneakyThrows
    @BeforeAll
    public static void init() {
        var cls = FibonacciService.class.getDeclaredField("fibonacciUtil");
        cls.setAccessible(true);
        cls.set(fibonacciService, new FibonacciUtil());
    }

    @Test
    public void testFibonacci() {
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
