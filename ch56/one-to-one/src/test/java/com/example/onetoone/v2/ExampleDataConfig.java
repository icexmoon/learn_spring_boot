package com.example.onetoone.v2;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v2
 * @ClassName : .java
 * @createTime : 2023/7/2 12:44
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
                .birthDay(LocalDate.of(2000, 1, 1))
                .build();
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("lalala")
                .birthDay(LocalDate.of(2005, 10, 1))
                .build();
    }

    @Bean
    Student student3() {
        return Student.builder()
                .name("LiXiang")
                .birthDay(LocalDate.of(2002, 5, 8))
                .build();
    }

    @Bean
    StudentInfo studentInfo2(){
        return StudentInfo.builder()
                .loveDraw(false)
                .loveMusic(true)
                .desc("is a good game player.")
                .student(student2())
                .build();
    }

    @Bean
    StudentInfo studentInfo3(){
        return StudentInfo.builder()
                .loveMusic(true)
                .loveDraw(false)
                .desc("The boy like music very much.")
                .student(student3())
                .build();
    }
}
