package com.example.async;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : async
 * @Package : com.example.async
 * @ClassName : .java
 * @createTime : 2023/6/16 12:37
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
@Aspect
public class MyAsyncAspect {
    @Around(value = "execution(void *(..)) && @annotation(annotation)")
    public Object asyncCall(ProceedingJoinPoint pjp, MyAsync annotation) {
        new Thread(() -> {
            try {
                pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();
        return null;
    }
}
