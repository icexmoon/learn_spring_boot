package com.example.identitifier.v6;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : identitifier
 * @Package : com.example.identitifier
 * @ClassName : .java
 * @createTime : 2023/7/7 15:10
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student() {
        return Student.builder()
                .name("icexmoon")
                .build();
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("BrusLee")
                .build();
    }

    @Bean
    Student student3() {
        return Student.builder()
                .name("JackChen")
                .build();
    }
}
