package cn.icexmoon.my_first_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.icexmoon.my_first_app.mapper")
public class MyFirstAppApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyFirstAppApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
