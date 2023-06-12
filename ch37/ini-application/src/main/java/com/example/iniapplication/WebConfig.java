package com.example.iniapplication;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ini-application
 * @Package : com.example.iniapplication
 * @ClassName : .java
 * @createTime : 2023/6/12 12:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
@Configuration
public class WebConfig {
//    @Bean
//    public ApplicationListener<ApplicationStartingEvent> startingEventApplicationListener(){
//        return event -> log.debug("ApplicationStartingEvent is called.");
//    }
//
//    @Bean
//    public ApplicationListener<ApplicationEnvironmentPreparedEvent> environmentPreparedEventApplicationListener(){
//        return event -> log.debug("ApplicationEnvironmentPreparedEvent is called.");
//    }
//
//    @Bean
//    public ApplicationListener<ApplicationContextInitializedEvent> contextInitializedEventApplicationListener(){
//        return event -> log.debug("ApplicationContextInitializedEvent is called.");
//    }
//
//    @Bean
//    public ApplicationListener<ApplicationPreparedEvent> preparedEventApplicationListener(){
//        return event -> log.debug("ApplicationPreparedEvent is called");
//    }

    @Bean
    public ApplicationListener<ContextRefreshedEvent> contextRefreshedEventApplicationListener() {
        return event -> log.debug("ContextRefreshedEvent is called.");
    }

    @Bean
    public ApplicationListener<WebServerInitializedEvent> webServerInitializedEventApplicationListener() {
        return event -> log.debug("WebServerInitializedEvent is called.");
    }

    @Bean
    public ApplicationListener<ApplicationStartedEvent> applicationStartedEventApplicationListener() {
        return event -> log.debug("ApplicationStartedEvent is called.");
    }

    @Bean
    public ApplicationListener<AvailabilityChangeEvent> applicationAliveListener() {
        return event -> {
            AvailabilityState state = event.getState();
            if (state == LivenessState.CORRECT) {
                log.debug("AvailabilityChangeEvent is called, and now Application is lived.");
            }
        };
    }

    @Order(1)
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener1() {
        return event -> log.debug("ApplicationReadyEvent1 is called.");
    }

    @Order(2)
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener2() {
        return event -> log.debug("ApplicationReadyEvent2 is called.");
    }

    @Bean
    public ApplicationListener<AvailabilityChangeEvent> applicationAllReadyListener() {
        return event -> {
            AvailabilityState state = event.getState();
            if (state == ReadinessState.ACCEPTING_TRAFFIC) {
                log.debug("AvailabilityChangeEvent is called, and now application is all ready.");
            }
        };
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            String s = Arrays.toString(args.getSourceArgs());
            log.debug("ApplicationRunner is called, source args:%s".formatted(s));
            log.debug("ApplicationRunner is called, non option args:%s".formatted(args.getNonOptionArgs()));
            log.debug("ApplicationRunner is called, option names:%s".formatted(args.getOptionNames()));
            log.debug("ApplicationRunner is called, option values:%s".formatted(args.getOptionValues("spring.profiles.active")));
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> log.debug("commandLineRunner is called, args:%s".formatted(Arrays.toString(args)));
    }
}
