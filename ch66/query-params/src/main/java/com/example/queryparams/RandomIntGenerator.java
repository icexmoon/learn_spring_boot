package com.example.queryparams;

import lombok.Synchronized;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : query-params
 * @Package : com.example.queryparams
 * @ClassName : .java
 * @createTime : 2023/7/8 12:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class RandomIntGenerator {
    private int min = 0;
    private int max = 100;
    private Random random = new Random();

    public RandomIntGenerator(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("min 不能小于 max");
        }
        this.min = min;
        this.max = max;
    }

    @Synchronized
    public int nextInt() {
        return random.nextInt(max - min + 1) + min;
    }
}
