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
 * @createTime : 2023/5/22 18:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Parent {
    @Nullable
    public Integer plus(@NonNull Integer a, @NonNull Integer b) {
        Integer c = a + b;
        if (c <= 0) {
            return null;
        }
        return c;
    }
}
