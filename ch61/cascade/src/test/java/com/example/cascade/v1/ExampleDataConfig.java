package com.example.cascade.v1;

import com.example.cascade.v1.Email;
import com.example.cascade.v1.Student;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cascade
 * @Package : com.example.cascade
 * @ClassName : .java
 * @createTime : 2023/7/5 11:12
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
                .name("icexmoon")
                .domain("qq.com")
                .build());
        icexmoon.addEmail(Email.builder()
                .name("123")
                .domain("qq.com")
                .build());
        return icexmoon;
    }

    @Bean
    Student student2() {
        Student brusLee = Student.builder()
                .name("BrusLee")
                .build();
        brusLee.addEmail(Email.builder()
                .name("666")
                .domain("tom.com")
                .build());
        brusLee.addEmail(Email.builder()
                .name("123")
                .domain("gmail.com")
                .build());
        return brusLee;
    }
}
