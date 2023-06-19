package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestApplication.class);
        application.addListeners((ApplicationListener<ApplicationStartedEvent>) event -> {
            System.out.println("ApplicationStartingEvent is called.");
        });
        application.run(args);
    }
}
