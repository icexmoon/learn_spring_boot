package com.example.cache;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 10:04
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 不使用缓存的 fibonacci 服务
 */
@Service
public class FibonacciService2 {
    @Clock
    public long fibonacci(int n) {
        return doFibonacci(n);
    }

    private long doFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n不能小于等于0");
        }
        if (n <= 2) {
            return 1;
        }
        return this.doFibonacci(n - 2) + this.doFibonacci(n - 1);
    }
}
