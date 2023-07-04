package com.example.manytomany.v1;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany
 * @ClassName : .java
 * @createTime : 2023/7/3 16:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Course mathCourse() {
        return Course.builder()
                .name("Math")
                .build();
    }

    @Bean
    Course physicsCourse() {
        return Course.builder()
                .name("Physics")
                .build();
    }

    @Bean
    Course chemistryCourse() {
        return Course.builder()
                .name("Chemistry")
                .build();
    }

    @Bean
    Course artCourse() {
        return Course.builder()
                .name("Art")
                .build();
    }

    @Bean
    Student student1() {
        return Student.builder()
                .name("icexmoon")
                .build()
                .addCourse(mathCourse())
                .addCourse(physicsCourse())
                .addCourse(chemistryCourse());
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("BrusLee")
                .build()
                .addCourse(artCourse())
                .addCourse(mathCourse());
    }

    @Bean
    Student student3() {
        return Student.builder()
                .name("JackChen")
                .build()
                .addCourse(artCourse())
                .addCourse(chemistryCourse());
    }
}
