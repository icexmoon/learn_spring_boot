package com.example.schedul;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : schedul
 * @Package : com.example.schedul
 * @ClassName : .java
 * @createTime : 2023/6/14 16:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
//@Configuration
@Log4j2
public class MyScheduleConfig implements SchedulingConfigurer {
    @Autowired
    private DelayService delayService;

    @Bean
    public Executor executor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(executor());
        taskRegistrar.addTriggerTask(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("hello, now is %s".formatted(now));
        }, triggerContext -> {
            Instant instant = triggerContext.lastCompletion();
            if (instant == null) {
                instant = new Date().toInstant();
            }
            int delay = delayService.getDelaySeconds();
            instant = instant.plus(delay, ChronoUnit.SECONDS);
            return instant;
        });
    }
}
