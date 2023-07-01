package com.example.keyuniqindex;

import com.example.keyuniqindex.entity.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 11:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Primary
    @Bean
    Student student() {
        return Student.builder()
                .number("2010000001")
                .name("icexmoon")
                .birthDay(LocalDate.of(2000, 1, 1))
                .gender(Gender.MALE)
                .build();
    }

    @Bean
    Student student2(){
        return Student.builder()
                .number("2010000002")
                .name("lalala")
                .birthDay(LocalDate.of(2001,5,1))
                .gender(Gender.MALE)
                .build();
    }

    @Bean
    Student student3(){
        return Student.builder()
                .number("2010000003")
                .name("JeckChen")
                .birthDay(LocalDate.of(2005,10,1))
                .gender(Gender.MALE)
                .build();
    }

    @Bean
    ClassRoom classRoom(){
        return ClassRoom.builder()
                .name("一年级一班")
                .build();
    }

    @Bean
    Teacher teacher(){
        return Teacher.builder()
                .name("LiLei")
                .build();
    }

    @Primary
    @Bean
    Club club(){
        return Club.builder()
                .name("SF club")
                .build();
    }

    @Bean
    Club club2(){
        return Club.builder()
                .name("history lover club")
                .build();
    }
}
