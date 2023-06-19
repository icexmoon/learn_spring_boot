package com.example.dianno.entity;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-anno
 * @Package : com.example.dianno.entity
 * @ClassName : .java
 * @createTime : 2023/6/19 13:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
@ToString
public class MultiConstructorExample {
    private final Car car;
    private final Motorcycle motorcycle;
    private final String msg;
    private static final String DEFAULT_MSG = "hello";

    @Autowired(required = false)
    public MultiConstructorExample(Car car, Motorcycle motorcycle, String msg) {
        this.car = car;
        this.motorcycle = motorcycle;
        this.msg = msg;
    }

    @Autowired(required = false)
    public MultiConstructorExample(Car car, Motorcycle motorcycle) {
        this(car, motorcycle, DEFAULT_MSG);
    }

    public MultiConstructorExample(){
        this(null, null, DEFAULT_MSG);
    }
}
