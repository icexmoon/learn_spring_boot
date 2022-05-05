package cn.icexmoon.my_first_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.icexmoon.my_first_app.mapper")
public class MyFirstAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyFirstAppApplication.class, args);
	}

}
