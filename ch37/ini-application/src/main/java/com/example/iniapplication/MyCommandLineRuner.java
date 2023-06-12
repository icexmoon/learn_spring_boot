package com.example.iniapplication;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ini-application
 * @Package : com.example.iniapplication
 * @ClassName : .java
 * @createTime : 2023/6/12 11:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
@Component
public class MyCommandLineRuner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.debug("MyCommandLineRuner is begin.");
//        new LongTimeTask().run();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new LongTimeTask());
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        log.debug("MyCommandLineRuner is end.");
    }

    private static class LongTimeTask implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            int delay = random.nextInt(10) + 1;
            try {
                Thread.sleep((20 + delay) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
