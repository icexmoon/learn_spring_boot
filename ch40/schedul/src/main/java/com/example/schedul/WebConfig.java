package com.example.schedul;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : schedul
 * @Package : com.example.schedul
 * @ClassName : .java
 * @createTime : 2023/6/14 15:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@EnableScheduling
@EnableAsync
public class WebConfig {
//    @Bean
//    public TaskScheduler taskScheduler(){
//        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//        threadPoolTaskScheduler.setPoolSize(5);
//        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
//        return threadPoolTaskScheduler;
//    }
}
