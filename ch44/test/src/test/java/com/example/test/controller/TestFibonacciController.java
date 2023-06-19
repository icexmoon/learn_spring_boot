package com.example.test.controller;

import com.example.test.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
@SpringBootTest
@AutoConfigureMockMvc
public class TestFibonacciController {
    @Test
    void testFibonacci(@Autowired MockMvc mockMvc) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        int[] fibonacciArr = new int[]{1, 1, 2, 3, 5, 8};
        for (int i = 0; i < fibonacciArr.length; i++) {
            int n = i + 1;
            var targetResultStr = mapper.writeValueAsString(Result.success(fibonacciArr[i]));
            mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci/" + n))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(targetResultStr, false));
        }
    }
}
