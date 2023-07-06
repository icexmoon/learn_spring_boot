package com.example.filterentityassociation.v3;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v3
 * @ClassName : .java
 * @createTime : 2023/7/6 13:56
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
        return icexmoon;
    }

    @Bean
    Address address1() {
        return Address.builder()
                .name("香榭丽舍大街101号")
                .build();
    }

    @Bean
    Address address2() {
        return Address.builder()
                .name("白金汉宫301室")
                .build();
    }
}
