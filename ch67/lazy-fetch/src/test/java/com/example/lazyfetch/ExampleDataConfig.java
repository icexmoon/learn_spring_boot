package com.example.lazyfetch;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lazy-fetch
 * @Package : com.example.lazyfetch
 * @ClassName : .java
 * @createTime : 2023/7/8 15:26
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
                .domain("qq.com")
                .build());
        icexmoon.addEmail(Email.builder()
                .account("666")
                .domain("tom.com")
                .build());
        return icexmoon;
    }

    @Bean
    Student student2() {
        Student lalala = Student.builder()
                .name("lalala")
                .build();
        lalala.addEmail(Email.builder()
                .account("123")
                .domain("gmail.com")
                .build());
        return lalala;
    }
}
