package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 13:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class FibonacciService {
    @Autowired
    private FibonacciUtil fibonacciUtil;

    public int fibonacci(int n) {
        return fibonacciUtil.doFibonacci(n);
    }
}
