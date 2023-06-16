package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : async
 * @Package : com.example.async
 * @ClassName : .java
 * @createTime : 2023/6/16 11:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class Fibonacci {
    /**
     * 返回斐波那契数列的第n位的值
     *
     * @param n 从1开始（包括）
     * @return
     */
    public int fibonacci(int n) throws InterruptedException {
//        Thread.sleep(1);
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @Async
    public Future<Integer> asyncFibonacci(int n) throws InterruptedException {
        if (n < 1) {
            throw new IllegalArgumentException("n 不能小于1");
        }
        System.out.println(Thread.currentThread().getName());
        int result = fibonacci(n);
        return CompletableFuture.completedFuture(result);
    }

    /**
     * 打印斐波那契数列第n位的结果到控制台
     *
     * @param n 从1开始（包括）
     * @throws InterruptedException
     */
    @Async
    public void print(int n) throws InterruptedException {
        if (n < 1) {
            throw new IllegalArgumentException("n不能小于1");
        }
        System.out.printf("fibonacci %d=%d%n", n, fibonacci(n));
    }
}
