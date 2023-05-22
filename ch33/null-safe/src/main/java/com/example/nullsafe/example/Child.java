package com.example.nullsafe.example;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : null-safe
 * @Package : com.example.nullsafe.example
 * @ClassName : .java
 * @createTime : 2023/5/22 18:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Child extends Parent {
    @NonNull
    @Override
    public Integer plus(@Nullable Integer a, @Nullable Integer b) {
        return a + b;
    }
}
