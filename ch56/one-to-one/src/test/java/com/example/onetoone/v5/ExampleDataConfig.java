package com.example.onetoone.v5;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v5
 * @ClassName : .java
 * @createTime : 2023/7/2 16:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student() {
        Student icexmoon = Student.builder()
                .name("icexmoon")
                .birthDay(LocalDate.of(1995, 10, 1))
                .build();
        return icexmoon;
    }

    @Bean
    Student student2() {
        var s = Student.builder()
                .name("lalala")
                .birthDay(LocalDate.of(2000, 10, 1))
                .build();
        s.addStudentInfoAssociation(StudentInfo.builder()
                .loveMusic(true)
                .loveDraw(true)
                .desc("This is a good boy.")
                .build());
        return s;
    }

    @Bean
    Student student3() {
        var s = Student.builder()
                .name("JackChen")
                .birthDay(LocalDate.of(2002, 5, 1))
                .build();
        s.addStudentInfoAssociation(StudentInfo.builder()
                .loveDraw(false)
                .loveMusic(true)
                .desc("will be a famous singer.")
                .build());
        return s;
    }
}
