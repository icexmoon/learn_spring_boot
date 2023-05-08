package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
//        xmlApplicationContextTest();
//        annotationApplicationContextTest();
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        Calculator cal2 = (Calculator) ctx.getBean("cal2");
//        cal2.add(2);
//        System.out.println(cal2.print());
//        ctxTest(ctx);
        SpringApplication.run(IocApplication.class, args);
//        Calculator calculator1 = (Calculator) ctx.getBean("calculator");
//        Calculator calculator2 = (Calculator) ctx.getBean("calculator");
//        if (calculator1 == calculator2){
//            System.out.println("get same calculator.");
//        }
//        calculator1.add(2);
//        calculator2.add(3);
//        System.out.println(calculator1.print());
//        System.out.println(calculator2.print());
    }

    private static void annotationApplicationContextTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Calculator.class, SupperCalculator.class);
        ctxTest(ctx);
    }

    private static void xmlApplicationContextTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:app.xml");
        ctxTest(ctx);
    }

    private static void ctxTest(ApplicationContext ctx) {
//        Calculator calculator = ctx.getBean(Calculator.class);
//        calculator.add(1);
//        calculator.add(2);
//        System.out.println(calculator.print());
//        SupperCalculator supperCalculator = ctx.getBean(SupperCalculator.class);
        SupperCalculator supperCalculator = (SupperCalculator) ctx.getBean("supperCalculator");
        supperCalculator.add(2);
        supperCalculator.power(3);
        System.out.println(supperCalculator.print());
        SupperCalculator supperCalculator1 = (SupperCalculator) ctx.getBean("supperCalculator1");
        supperCalculator1.add(3);
        supperCalculator1.power(3);
        SupperCalculator supperCalculator2 = (SupperCalculator) ctx.getBean("sc2");
        supperCalculator2.add(3);
        supperCalculator2.power(2);
        System.out.println(supperCalculator1.print());
        System.out.println(supperCalculator2.print());
    }

}
