package com.example.entitytomultipletable.v1;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-to-multiple-table
 * @Package : com.example.entitytomultipletable
 * @ClassName : .java
 * @createTime : 2023/7/4 17:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student() {
        return Student.builder()
                .name("icexmoon")
                .loveMusic(true)
                .address("宁安大家100号")
                .build();
    }

    @Bean
    Student student2() {
        return Student.builder()
                .name("JackChen")
                .loveDraw(true)
                .address("南京路56号")
                .build();
    }

    @Bean
    Student student3() {
        return Student.builder()
                .name("BrusLee")
                .loveDraw(true)
                .loveMusic(true)
                .email("123@qq.com")
                .build();
    }
}
