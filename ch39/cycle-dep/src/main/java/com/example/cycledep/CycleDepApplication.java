package com.example.cycledep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CycleDepApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(CycleDepApplication.class)
                .listeners()
                .run(args);
//        SpringApplication.run(CycleDepApplication.class, args);
    }
}
