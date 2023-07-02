package com.example.onetoone.v4;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v4
 * @ClassName : .java
 * @createTime : 2023/7/2 15:50
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
                .studentInfo(null)
                .build();
    }

    @Bean
    Student student2(){
        StudentInfo studentInfo = StudentInfo.builder()
                .loveDraw(true)
                .loveMusic(false)
                .desc("will be a famous drawer.")
                .build();
        Student jackChen = Student.builder()
                .name("JackChen")
                .birthDay(LocalDate.of(2002, 10, 1))
                .build();
        jackChen.addStudentInfoAssociation(studentInfo);
        return jackChen;
    }

    @Bean
    Student student3(){
        StudentInfo studentInfo = StudentInfo.builder()
                .loveMusic(true)
                .loveDraw(false)
                .desc("The boy really like music.")
                .build();
        Student brusLee = Student.builder()
                .name("BrusLee")
                .birthDay(LocalDate.of(1990, 3, 6))
                .studentInfo(studentInfo)
                .build();
        brusLee.addStudentInfoAssociation(studentInfo);
        return brusLee;
    }
}
