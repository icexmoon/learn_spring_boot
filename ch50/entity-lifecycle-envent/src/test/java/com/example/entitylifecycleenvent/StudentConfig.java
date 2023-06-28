package com.example.entitylifecycleenvent;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle-envent
 * @Package : com.example.entitylifecycleenvent
 * @ClassName : .java
 * @createTime : 2023/6/28 18:25
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class StudentConfig {
    @Bean
    Student student1(){
        return new Student("icexmoon", LocalDate.of(1989, 10, 1), Gender.MALE);
    }
    @Bean
    Student student2(){
        return new Student("JackChen", LocalDate.of(1990, 5, 1), Gender.MALE);
    }
    @Bean
    Student student3(){
        return new Student("HanMeimei", LocalDate.of(1991, 6, 1), Gender.FEMALE);
    }
}
