package com.example.query;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : query
 * @Package : com.example.query
 * @ClassName : .java
 * @createTime : 2023/7/8 10:38
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
                .birthDay(LocalDate.of(2000, 10, 1))
                .address("香榭丽舍大街101号")
                .build();
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("lalala")
                .birthDay(LocalDate.of(2002, 10, 20))
                .address("北京东路25号")
                .build();
    }

    @Bean
    Student student3() {
        return Student.builder()
                .name("JackChen")
                .address("南京路55号")
                .birthDay(LocalDate.of(1998, 5, 1))
                .build();
    }
}
