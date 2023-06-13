package com.example.cycledep;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cycle-dep
 * @Package : com.example.cycledep
 * @ClassName : .java
 * @createTime : 2023/6/13 18:15
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@Log4j2
public class WebConfig {
    @Autowired
    ApplicationContext ctx;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Person person = ctx.getBean(Person.class);
            Dog dog = ctx.getBean(Dog.class);
            log.debug(person);
            log.debug(dog);
        };
    }
}
