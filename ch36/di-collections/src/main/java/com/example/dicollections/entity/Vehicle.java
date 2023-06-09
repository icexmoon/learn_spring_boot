package com.example.dicollections.entity;

import lombok.AllArgsConstructor;
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
 * @createTime : 2023/6/9 22:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class Vehicle {
    private String name;
    private String manufacturer;
}
