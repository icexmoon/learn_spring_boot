package com.example.ineritancemapping.v5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v2
 * @ClassName : .java
 * @createTime : 2023/7/7 10:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Autowired
    private IdGenerator idGenerator;

    @Bean
    Student student() {
        Student icexmoon = new Student("icexmoon", 90);
        icexmoon.setId(idGenerator.nextValue());
        return icexmoon;
    }

    @Bean
    Student student2() {
        Student lalala = new Student("lalala", 95);
        lalala.setId(idGenerator.nextValue());
        return lalala;
    }

    @Bean
    Student student3() {
        Student jackChen = new Student("JackChen", 85);
        jackChen.setId(idGenerator.nextValue());
        return jackChen;
    }

    @Bean
    Teacher teacher() {
        Teacher catherine = new Teacher("Catherine", Teacher.Course.MATH);
        catherine.setId(idGenerator.nextValue());
        return catherine;
    }

    @Bean
    Teacher teacher2() {
        Teacher tina = new Teacher("Tina", Teacher.Course.MUSIC);
        tina.setId(idGenerator.nextValue());
        return tina;
    }

    @Bean
    Teacher teacher3() {
        Teacher liLei = new Teacher("LiLei", Teacher.Course.CHEMISTRY);
        liLei.setId(idGenerator.nextValue());
        return liLei;
    }

    @Bean
    Person person() {
        Person tom = new Person("Tom");
        tom.setId(idGenerator.nextValue());
        return tom;
    }

    @Bean
    Person person2() {
        Person adam = new Person("Adam");
        adam.setId(idGenerator.nextValue());
        return adam;
    }
}
