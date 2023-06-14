package com.example.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : schedul
 * @Package : com.example.schedul
 * @ClassName : .java
 * @createTime : 2023/6/14 15:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class MySchedule {
    @Scheduled(fixedRate = 1000)
    public void sayHello() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("hello, now is %s".formatted(now));
        Thread.sleep(2000);
    }

    @Scheduled(fixedRate = 1000)
    public void sayHello2() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("hello2, now is %s".formatted(now));
        Thread.sleep(2000);
    }
}
