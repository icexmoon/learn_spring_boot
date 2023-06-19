package com.example.dianno;

import com.example.dianno.entity.Car;
import com.example.dianno.entity.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-anno
 * @Package : com.example.dianno
 * @ClassName : .java
 * @createTime : 2023/6/18 19:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
public class WebConfig {
//    @Lazy
//    @Autowired
//    private CarrierService carrierService;
    @Autowired
    private ApplicationContext context;

    @Bean
    Car defaultCar(){
        return new Car("长安汽车","X5");
    }

    @Bean
    Motorcycle defaultMotorcycle(){
        return new Motorcycle("哈雷","A7");
    }

    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            var carrierService = context.getBean(CarrierService.class);
            var defaultCarrier = carrierService.getDefaultCarrier();
            System.out.println(defaultCarrier);
        };
    }

    @Bean
    MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor(defaultMotorcycle());
    }
}
