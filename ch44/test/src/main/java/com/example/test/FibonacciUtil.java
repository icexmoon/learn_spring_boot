package com.example.test;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 13:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class FibonacciUtil {
    public int doFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n 不能小于等于0");
        }
        if (n <= 2) {
            return 1;
        }
        return doFibonacci(n - 1) + doFibonacci(n - 2);
    }
}
