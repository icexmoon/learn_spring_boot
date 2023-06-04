package com.example.lombok.entity;

import lombok.Synchronized;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/6/3 10:31
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class ShareData {
    private final Object lock1 = new Object[0];
    private static final Object lock2 = new Object[0];

    @Synchronized("lock1")
    public void func1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("func1() is called.");
            Thread.yield();
        }
    }

    public void func2() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("func2() is called.");
                Thread.yield();
            }
        }
    }

    @Synchronized("lock2")
    public static void func3(){
        for (int i = 0; i < 5; i++) {
            System.out.println("func3() is called.");
            Thread.yield();
        }
    }
}
