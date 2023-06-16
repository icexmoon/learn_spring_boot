package com.example.async;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : async
 * @Package : com.example.async
 * @ClassName : .java
 * @createTime : 2023/6/16 13:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
@Component
public class AnalysisAspect {
    @Around("execution(* *(..)) && @annotation(anno)")
    public Object analysisTimes(ProceedingJoinPoint pjp,MyClock anno) throws Throwable {
        LocalDateTime time1 = LocalDateTime.now();
        Object retVal = pjp.proceed();
        LocalDateTime time2 = LocalDateTime.now();
        long seconds = Duration.between(time1, time2).toMillis();
        String methodName = pjp.getSignature().getName();
        String clsName = pjp.getSignature().getDeclaringType().getName();
        System.out.println("%s.%s() is called, use %d mills.".formatted(clsName, methodName, seconds));
        return retVal;
    }
}
