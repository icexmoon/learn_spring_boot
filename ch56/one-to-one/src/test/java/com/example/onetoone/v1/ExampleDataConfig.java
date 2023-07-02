package com.example.onetoone.v1;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone
 * @ClassName : .java
 * @createTime : 2023/7/2 10:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    public Student student() {
        return Student.builder()
                .name("icexmoon")
                .birthDay(LocalDate.of(2000, 1, 1))
                .studentInfo(null)
                .build();
    }

    @Bean
    public Student student2() {
        return Student.builder()
                .name("lalala")
                .birthDay(LocalDate.of(2005, 10, 1))
                .studentInfo(studentInfo2())
                .build();
    }

    @Bean
    public Student student3(){
        return Student.builder()
                .name("JackChen")
                .birthDay(LocalDate.of(2008,3,5))
                .studentInfo(studentInfo3())
                .build();
    }

    @Bean
    public StudentInfo studentInfo3() {
        return StudentInfo.builder()
                .loveDraw(false)
                .loveMusic(true)
                .desc("very good boy.")
                .build();
    }

    @Bean
    public StudentInfo studentInfo(){
        return StudentInfo.builder()
                .loveMusic(false)
                .loveDraw(false)
                .desc("")
                .build();
    }

    @Bean
    public StudentInfo studentInfo2(){
        return StudentInfo.builder()
                .loveMusic(false)
                .loveDraw(true)
                .desc("will be a good drawer.")
                .build();
    }
}
