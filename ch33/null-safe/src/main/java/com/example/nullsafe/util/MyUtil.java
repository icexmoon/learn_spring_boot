package com.example.nullsafe.util;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : null-safe
 * @Package : com.example.nullsafe.util
 * @ClassName : .java
 * @createTime : 2023/5/22 17:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class MyUtil {
    @Nullable
    private Integer test;

    public Integer plus(@Nullable Integer a, @Nullable Integer b) {
        if (a == null) {
            a = 0;
        }
        if (b == null) {
            b = 0;
        }
        Integer c = a + b;
        return c;
    }
}
