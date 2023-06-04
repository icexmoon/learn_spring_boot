package com.example.lombok.entity;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/6/3 12:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class LazyExample {
    @Getter(lazy = true)
    private final Long bigFibnacci = fibonacci(30);

    private static long fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
