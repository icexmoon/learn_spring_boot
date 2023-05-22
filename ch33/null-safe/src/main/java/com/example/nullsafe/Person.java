package com.example.nullsafe;

import org.springframework.lang.NonNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : null-safe
 * @Package : com.example.nullsafe
 * @ClassName : .java
 * @createTime : 2023/5/22 17:25
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Person {
    @NonNull
    private String name;

    public Person(@NonNull String name) {
        this.name = name;
    }
}
