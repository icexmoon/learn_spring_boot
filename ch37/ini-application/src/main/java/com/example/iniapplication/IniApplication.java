package com.example.iniapplication;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@Log4j2
public class IniApplication {

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(IniApplication.class);
//        application.addListeners(applicationStartedEventApplicationListener(),
//                applicationEnvironmentPreparedEventApplicationListener(),
//                applicationContextInitializedEventApplicationListener(),
//                applicationPreparedEventApplicationListener());
//        application.run(args);
        new SpringApplicationBuilder()
                .sources(IniApplication.class)
                .listeners(applicationEnvironmentPreparedEventApplicationListener(),
                        applicationStartedEventApplicationListener(),
                        applicationContextInitializedEventApplicationListener(),
                        applicationPreparedEventApplicationListener())
                .run(args);
    }

    private static ApplicationListener<ApplicationStartingEvent> applicationStartedEventApplicationListener(){
        return event -> System.out.println("ApplicationStartingEvent is called.");
    }

    private static ApplicationListener<ApplicationEnvironmentPreparedEvent> applicationEnvironmentPreparedEventApplicationListener(){
        return event -> log.debug("ApplicationEnvironmentPreparedEvent is called.");
    }

    private static ApplicationListener<ApplicationContextInitializedEvent> applicationContextInitializedEventApplicationListener(){
        return event -> log.debug("ApplicationContextInitializedEvent is called.");
    }

    private static ApplicationListener<ApplicationPreparedEvent> applicationPreparedEventApplicationListener(){
        return event -> log.debug("ApplicationPreparedEvent is called.");
    }
}
