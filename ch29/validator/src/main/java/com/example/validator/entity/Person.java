package com.example.validator.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator
 * @ClassName : .java
 * @createTime : 2023/5/15 9:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@NoArgsConstructor
public class Person {

    private String name;
    private int age = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person(name:%s,age:%d)".formatted(name, age);
    }
}
