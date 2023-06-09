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
 * @createTime : 2023/6/9 22:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Motorcycle extends Vehicle{
    private boolean twoWheeler;

    public Motorcycle(String name, String manufacturer, boolean twoWheeler) {
        super(name, manufacturer);
        this.twoWheeler = twoWheeler;
    }
}
