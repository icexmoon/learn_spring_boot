package com.example.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 13:57
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class TestFibonacciUtil {
    @Test
    void testFibonacci() {
        FibonacciUtil util = new FibonacciUtil();
        int[] fibonacci = new int[]{1, 1, 2, 3, 5, 8, 13, 21};
        for (int i = 0; i < fibonacci.length; i++) {
            assertEquals(fibonacci[i], util.doFibonacci(i + 1));
        }
        int[] errorIndex = new int[]{0, -1, -2};
        for (int ei : errorIndex) {
            var exp = assertThrows(IllegalArgumentException.class, () -> util.doFibonacci(ei));
            assertEquals("n 不能小于等于0", exp.getMessage());
        }
    }
}
