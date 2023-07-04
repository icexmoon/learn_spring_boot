package com.example.manytomany;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany
 * @ClassName : .java
 * @createTime : 2023/7/3 19:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@Log4j2
public class WebConfig {
    @Bean
    ApplicationRunner applicationRunner(){
        return (args)->{
            log.debug("Debugging log");
            log.info("Info log");
            log.warn("Hey, This is a warning!");
            log.error("Oops! We have an Error. OK");
            log.fatal("Damn! Fatal error. Please fix me.");
        };
    }
}
