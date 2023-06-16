package com.example.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : async
 * @Package : com.example.async
 * @ClassName : .java
 * @createTime : 2023/6/16 12:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Order(2)
@Configuration
@EnableAsync
public class WebConfig {
    @Autowired
    private Fibonacci fibonacci;
    private static final int MAX_FIBONACCI_INDEX = 40;
//    @Autowired
//    private TaskExecutor taskExecutor;

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            @MyClock
            public void run(ApplicationArguments args) throws Exception {
                List<Integer> numbers = new ArrayList<>();
                List<Future<Integer>> futures = new ArrayList<>();
                for (int n = 1; n <= MAX_FIBONACCI_INDEX; n++) {
                    futures.add(fibonacci.asyncFibonacci(n));
                }
                for (Future<Integer> future : futures) {
                    numbers.add(future.get());
                }
                System.out.println(numbers);
            }
        };
    }

    @Bean
    public ApplicationRunner applicationRunner2() {
        return new ApplicationRunner() {
            @Override
            @MyClock
            public void run(ApplicationArguments args) throws Exception {
                List<Integer> numbers = new ArrayList<>();
                for (int n = 1; n <= MAX_FIBONACCI_INDEX; n++) {
                    numbers.add(fibonacci.fibonacci(n));
                }
                System.out.println(numbers);
            }
        };
    }

//    @Bean
//    public ApplicationRunner applicationRunner3(){
//        return args -> {
//            System.out.println(taskExecutor);
//            if (taskExecutor instanceof ThreadPoolTaskExecutor){
//                var executor = (ThreadPoolTaskExecutor) taskExecutor;
//                System.out.println("getThreadNamePrefix:%s".formatted(executor.getThreadNamePrefix()));
//                System.out.println("getActiveCount:%s".formatted(executor.getActiveCount()));
//                System.out.println("getCorePoolSize:%s".formatted(executor.getCorePoolSize()));
//                System.out.println("getKeepAliveSeconds:%s".formatted(executor.getKeepAliveSeconds()));
//                System.out.println("getMaxPoolSize:%s".formatted(executor.getMaxPoolSize()));
//                System.out.println("getQueueCapacity:%s".formatted(executor.getQueueCapacity()));
//                System.out.println("getPoolSize:%s".formatted(executor.getPoolSize()));
//            }
//        };
//    }

    @Bean
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("another-ThreadPoolTaskExecutor-");
        return threadPoolTaskExecutor;
    }

    @Bean
    public ApplicationRunner applicationRunner3() {
        return args -> {
//            Future<Integer> future = fibonacci.asyncFibonacci(0);
//            System.out.println(future.get());
            fibonacci.print(0);
        };
    }
}

