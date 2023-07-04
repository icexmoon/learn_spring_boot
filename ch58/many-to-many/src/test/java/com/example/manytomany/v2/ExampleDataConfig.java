package com.example.manytomany.v2;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany.v2
 * @ClassName : .java
 * @createTime : 2023/7/3 21:15
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student1() {
        Student icexmoon = Student.builder()
                .name("icexmoon")
                .build();
//        icexmoon.addCourse(math(), 99);
//        icexmoon.addCourse(physics(), 90);
//        icexmoon.addCourse(chemistry(), 88);
        return icexmoon;
    }

    @Bean
    Student student2() {
        Student jackChen = Student.builder()
                .name("JackChen")
                .build();
//        jackChen.addCourse(art(), 100);
//        jackChen.addCourse(math(), 95);
        return jackChen;
    }

    @Bean
    Student student3() {
        Student brusLee = Student.builder()
                .name("BrusLee")
                .build();
//        brusLee.addCourse(chemistry(), 92);
//        brusLee.addCourse(math(), 80);
        return brusLee;
    }

    @Bean
    Course math() {
        return Course.builder()
                .name("Math")
                .build();
    }

    @Bean
    Course physics() {
        return Course.builder()
                .name("Physics")
                .build();
    }

    @Bean
    Course chemistry() {
        return Course.builder()
                .name("Chemistry")
                .build();
    }

    @Bean
    Course art() {
        return Course.builder()
                .name("Art")
                .build();
    }
}
