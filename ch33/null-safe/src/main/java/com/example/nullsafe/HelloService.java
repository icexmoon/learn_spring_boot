package com.example.nullsafe;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : null-safe
 * @Package : com.example.nullsafe
 * @ClassName : .java
 * @createTime : 2023/5/22 14:28
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class HelloService {
    public Integer plusWithNoAnnotation(Integer a, Integer b) {
        return a + b;
    }

    @NonNull
    public Integer plus(@NonNull Integer a, @NonNull Integer b) {
        return a + b;
    }

    @NonNull
    public Integer plusAllowNull(@Nullable Integer a, @Nullable Integer b) {
        if (a == null) {
            a = 0;
        }
        if (b == null) {
            b = 0;
        }
        return a + b;
    }
}
