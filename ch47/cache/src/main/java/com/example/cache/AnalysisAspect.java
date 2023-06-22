package com.example.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 10:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Order(0)
@Aspect
public class AnalysisAspect {
    @Around(value = "execution(* *(..)) && @annotation(annotation)")
    public Object analysisTimes(ProceedingJoinPoint pjp, Clock annotation) throws Throwable {
        LocalDateTime time1 = LocalDateTime.now();
        Object retVal = pjp.proceed();
        LocalDateTime time2 = LocalDateTime.now();
        long millis = Duration.between(time1, time2).toMillis();
        String methodName = pjp.getSignature().getName();
        String clsName = pjp.getSignature().getDeclaringType().getName();
        System.out.println("%s.%s() is called, use %d mills.".formatted(clsName, methodName, millis));
        return retVal;
    }
}
