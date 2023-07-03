package com.example.onetomany;

import com.example.onetomany.entity.Email;
import com.example.onetomany.entity.Student;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-many
 * @Package : com.example.onetomany
 * @ClassName : .java
 * @createTime : 2023/7/3 10:47
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
                .build();
        icexmoon.addEmail(Email.builder()
                .account("123")
                .domain("tom.com")
                .build());
        icexmoon.addEmail(Email.builder()
                .account("666")
                .domain("gmail.com")
                .build());
        return icexmoon;
    }

    @Bean
    Student student2() {
        Student lalala = Student.builder()
                .name("lalala")
                .build();
        lalala.addEmail(Email.builder()
                .account("111")
                .domain("tom.com")
                .build());
        lalala.addEmail(Email.builder()
                .account("123")
                .domain("qq.com")
                .build());
        return lalala;
    }

    @Bean
    Student student3() {
        return Student.builder()
                .name("JackChen")
                .build();
    }
}
