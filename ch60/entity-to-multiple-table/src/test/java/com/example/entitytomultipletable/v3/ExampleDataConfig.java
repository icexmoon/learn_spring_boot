package com.example.entitytomultipletable.v3;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-to-multiple-table
 * @Package : com.example.entitytomultipletable.v3
 * @ClassName : .java
 * @createTime : 2023/7/4 18:22
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
                .loveDraw(true)
                .address("宁安大街101号")
                .build();
    }

    @Bean
    Student student2(){
        return Student.builder()
                .name("JackChen")
                .loveMusic(true)
                .email("123@tom.com")
                .build();
    }

    @Bean
    Student student3(){
        return Student.builder()
                .name("BrusLee")
                .loveDraw(true)
                .loveMusic(true)
                .email("666@qq.com")
                .address("北京东路200号")
                .build();
    }
}
