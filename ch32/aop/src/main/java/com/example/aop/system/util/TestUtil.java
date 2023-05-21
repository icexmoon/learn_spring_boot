package com.example.aop.system.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.system.util
 * @ClassName : .java
 * @createTime : 2023/5/19 16:37
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class TestUtil {
    private Random random = new Random();

    /**
     * 做一些消耗时间的工作
     */
    public void doSomething() {
        int times = random.nextInt(1000) + 10000000;
        calcPi(times);
    }

    private static double calcPi(int n) {
        double Pi = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                Pi = Pi - ((double) 1 / (2 * i + 1));
            } else {
                Pi = Pi + ((double) 1 / (2 * i + 1));
            }
        }
        return Pi * 4;
    }
}
