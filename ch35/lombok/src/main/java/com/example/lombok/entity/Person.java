package com.example.lombok.entity;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/6/1 10:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Builder
@Value
public class Person {
    String name;
    String city;
    String job;
    @Singular
    List<String> hobbies;
    @Builder.Default
    LocalDateTime createTime = LocalDateTime.now();
}
