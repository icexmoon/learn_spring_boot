package com.example.dicollections.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections.entity
 * @ClassName : .java
 * @createTime : 2023/6/9 22:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Car extends Vehicle {
    private String engineType;

    public Car(String name, String manufacturer, String engineType) {
        super(name, manufacturer);
        this.engineType = engineType;
    }
}
