package com.example.dilombok;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-lombok
 * @Package : com.example.dilombok
 * @ClassName : .java
 * @createTime : 2023/6/13 15:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class FibonacciService {
    /**
     * 返回一个斐波那契数列位于第n位的值
     *
     * @param n 从1开始（包括）
     * @return
     */
    public int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
