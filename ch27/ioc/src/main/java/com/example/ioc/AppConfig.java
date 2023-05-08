package com.example.ioc;

import com.example.ioc.web.Car;
import com.example.ioc.web.ClockFactoryBean;
import com.example.ioc.web.Vehicle;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/5 12:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration()
@ComponentScan(basePackages = "com.example.ioc")
public class AppConfig implements AppConfigImpl{
    @Bean({"sc1", "supperCalculator1"})
    public SupperCalculator supperCalculator1() {
        Calculator calculator = calculator();
        System.out.println(calculator);
        return new SupperCalculator(calculator);
    }

    @Bean("sc2")
    public SupperCalculator supperCalculator2() {
        Calculator calculator = calculator();
        System.out.println(calculator);
        return new SupperCalculator(calculator);
    }

    @Bean("sc3")
    public SupperCalculator supperCalculator3() {
        Calculator calculator = calculator();
        System.out.println(calculator);
        return new SupperCalculator(calculator);
    }

    @Bean(value = "cal", initMethod = "", destroyMethod = "destroy")
    public Calculator calculator() {
        Calculator calculator = new Calculator();
        calculator.construct();
        return calculator;
    }

    @Bean
    public Vehicle car(){
        return new Car();
    }

//    @Bean
//    public static PrintBeanPostProcessor printBeanPostProcessor(){
//        return new PrintBeanPostProcessor();
//    }

    @Bean
    public static PropertyOverrideConfigurer propertyOverrideConfigurer(){
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocation(new ClassPathResource("override.properties"));
        return propertyOverrideConfigurer;
    }

    @Bean
    public ClockFactoryBean clockFactoryBean(){
        return new ClockFactoryBean();
    }
}
