package com.example.test.controller;

import com.example.test.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test.controller
 * @ClassName : .java
 * @createTime : 2023/6/19 18:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestFibonacciController4 {
    @Test
    void testFibonacci(@Autowired TestRestTemplate testRestTemplate) {
        int[] fibonacciArr = new int[]{1, 1, 2, 3, 5, 8};
        for (int i = 0; i < fibonacciArr.length; i++) {
            int n = i + 1;
            var body = testRestTemplate.getForObject("/fibonacci/" + n, Result.class);
            Assertions.assertEquals(body, Result.success(fibonacciArr[i]));
        }
    }
}
