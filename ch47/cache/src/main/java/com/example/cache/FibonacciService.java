package com.example.cache;

import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.Cacheable;
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
 * @Description :
 */
@Service
public class FibonacciService {
    @Clock
    public int fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n不能小于等于0");
        }
        if (n <= 2) {
            return 1;
        }
        return doFibonacci(n - 2) + doFibonacci(n - 1);
    }

    @Cacheable("fibonacci")
    private int doFibonacci(int n){
        if (n <= 2) {
            return 1;
        }
        var aopProxy = (FibonacciService) AopContext.currentProxy();
        return aopProxy.doFibonacci(n - 2) + aopProxy.doFibonacci(n - 1);
    }
}
