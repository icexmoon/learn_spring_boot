package com.example.jpajoin;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa-join
 * @Package : com.example.jpajoin
 * @ClassName : .java
 * @createTime : 2023/7/9 9:31
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student icexmoon() {
        Student icexmoon = Student.builder()
                .name("icexmoon")
                .build();
        return icexmoon.addEmail(Email.builder()
                        .account("icexmoon")
                        .domain("qq.com")
                        .build())
                .addEmail(Email.builder()
                        .account("111")
                        .domain("tom.com")
                        .build());
    }

    @Bean
    Student jackChen() {
        Student jackChen = Student.builder()
                .name("JackChen")
                .build();
        jackChen.addEmail(Email.builder()
                        .account("123")
                        .domain("gmail.com")
                        .build())
                .addEmail(Email.builder()
                        .account("jack")
                        .domain("qq.com")
                        .build());
        return jackChen;
    }

    @Bean
    Student harry() {
        Student harry = Student.builder()
                .name("Harry")
                .build();
        harry.addEmail(Email.builder()
                        .account("harry")
                        .domain("qq.com")
                        .build())
                .addEmail(Email.builder()
                        .account("harry")
                        .domain("gmail.com")
                        .build());
        return harry;
    }

    @Bean
    School school() {
        return School.builder()
                .name("霍格沃茨魔法学校")
                .build()
                .addStudent(harry())
                .addStudent(icexmoon());
    }

    @Bean
    School school2() {
        return School.builder()
                .name("布斯巴顿魔法学校")
                .build()
                .addStudent(jackChen());
    }
}
