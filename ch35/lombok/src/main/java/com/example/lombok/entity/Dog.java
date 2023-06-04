package com.example.lombok.entity;

import lombok.Value;
import lombok.With;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/6/3 11:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
public class Dog {
    String name;
    @With
    Integer age;
}
