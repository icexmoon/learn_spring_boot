package com.example.entitytomultipletable.v4;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-to-multiple-table
 * @Package : com.example.entitytomultipletable.v4
 * @ClassName : .java
 * @createTime : 2023/7/4 18:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student(){
        return Student.builder()
                .name("icexmoon")
                .hobbies(Student.Hobbies.builder()
                        .loveDraw(true)
                        .build())
                .details(Student.Details.builder()
                        .address("宁安大街101号")
                        .build())
                .build();
    }

    @Bean
    Student student2(){
        return Student.builder()
                .name("JackChen")
                .hobbies(Student.Hobbies.builder()
                        .loveMusic(true)
                        .build())
                .details(Student.Details.builder()
                        .email("123@qq.com")
                        .address("北京东路100号")
                        .build())
                .build();
    }

    @Bean
    Student student3(){
        return Student.builder()
                .name("BrusLee")
                .hobbies(Student.Hobbies.builder()
                        .loveMusic(true)
                        .loveDraw(true)
                        .build())
                .build();
    }
}
