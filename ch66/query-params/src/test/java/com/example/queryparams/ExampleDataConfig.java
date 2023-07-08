package com.example.queryparams;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : query-params
 * @Package : com.example.queryparams
 * @ClassName : .java
 * @createTime : 2023/7/8 12:18
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
                .type(Student.Type.COLLEGE_STUDENT)
                .mathScore(scoreGenerator().nextInt())
                .englishScore(scoreGenerator().nextInt())
                .chineseScore(scoreGenerator().nextInt())
                .build();
    }

    @Bean
    Student student1() {
        return Student.builder()
                .name("lalala")
                .type(Student.Type.MIDDLE_SCHOOL_STUDENT)
                .mathScore(scoreGenerator().nextInt())
                .englishScore(scoreGenerator().nextInt())
                .chineseScore(scoreGenerator().nextInt())
                .build();
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("JackChen")
                .type(Student.Type.HIGH_SCHOOL_STUDENT)
                .mathScore(scoreGenerator().nextInt())
                .englishScore(scoreGenerator().nextInt())
                .chineseScore(scoreGenerator().nextInt())
                .build();
    }

    @Bean
    RandomIntGenerator scoreGenerator() {
        return new RandomIntGenerator(60, 100);
    }
}
