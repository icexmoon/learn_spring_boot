package com.example.ineritancemapping.v3;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v2
 * @ClassName : .java
 * @createTime : 2023/7/7 10:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student() {
        return new Student("icexmoon", 90);
    }

    @Bean
    Student student2() {
        return new Student("lalala", 95);
    }

    @Bean
    Student student3() {
        return new Student("JackChen", 85);
    }

    @Bean
    Teacher teacher() {
        return new Teacher("Catherine", Teacher.Course.MATH);
    }

    @Bean
    Teacher teacher2() {
        return new Teacher("Tina", Teacher.Course.MUSIC);
    }

    @Bean
    Teacher teacher3() {
        return new Teacher("LiLei", Teacher.Course.CHEMISTRY);
    }

    @Bean
    Person person(){
        return new Person("Tom");
    }

    @Bean
    Person person2(){
        return new Person("Adam");
    }
}
