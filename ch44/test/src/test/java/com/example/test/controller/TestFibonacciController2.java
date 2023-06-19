package com.example.test.controller;

import com.example.test.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestFibonacciController2 {
    @Test
    void testFibonacci(@Autowired WebTestClient client) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        int[] fibonacciArr = new int[]{1, 1, 2, 3, 5, 8};
        for (int i = 0; i < fibonacciArr.length; i++) {
            int n = i + 1;
            var targetResultStr = mapper.writeValueAsString(Result.success(fibonacciArr[i]));
            client.get().uri("/fibonacci/" + n)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody().json(targetResultStr, false);
        }
    }
}
