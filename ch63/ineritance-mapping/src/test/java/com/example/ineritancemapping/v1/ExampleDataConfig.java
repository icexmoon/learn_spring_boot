package com.example.ineritancemapping.v1;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping
 * @ClassName : .java
 * @createTime : 2023/7/7 9:15
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
        return new Student("lalala", 85);
    }

    @Bean
    Student student3() {
        return new Student("JackChen", 95);
    }

    @Bean
    Teacher teacher() {
        return new Teacher("BrusLee", Teacher.Course.CHEMISTRY);
    }

    @Bean
    Teacher teacher2() {
        return new Teacher("Tina", Teacher.Course.MATH);
    }

    @Bean
    Teacher teacher3() {
        return new Teacher("Cacherine", Teacher.Course.MUSIC);
    }
}
