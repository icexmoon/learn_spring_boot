package com.example.filterentityassociation.v4;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v4
 * @ClassName : .java
 * @createTime : 2023/7/6 18:09
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
                .averageScore(90)
                .build();
    }

    @Bean
    Student student1() {
        return Student.builder()
                .name("lalala")
                .averageScore(95)
                .build();
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("JackChen")
                .averageScore(80)
                .build();
    }
}
