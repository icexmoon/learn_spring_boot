package cn.icexmoon.books2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("cn.icexmoon.books2.*.mapper")
@SpringBootApplication
@EnableAspectJAutoProxy
public class Books2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Books2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
