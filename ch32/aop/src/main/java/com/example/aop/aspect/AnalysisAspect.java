package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/19 17:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
public class AnalysisAspect {
//    @Around("anyServicePublicCalls() || com.example.aop.aspect.OtherAspect.getUserCall()")
//    public Object analysisTimes(ProceedingJoinPoint pjp) throws Throwable {
//        return this.analysisExecutionTime(pjp);
//    }

    @Pointcut("execution(* com.example.aop.service.*.*(..))")
    public void anyServicePublicCalls(){}

    @Pointcut("execution(public * *(..))")
    public void allPublicMethods(){}

    @Pointcut("within(com.example.aop.controller..*)")
    public void allControllerCls(){}

    @Pointcut("allPublicMethods() && allControllerCls()")
    public void allControllerPublicMethods(){}

    @Around("com.example.aop.aspect.CommonPointcuts.publicControllerMethods()")
    public Object analysisControllerPublicMethods(ProceedingJoinPoint pjp) throws Throwable {
        return this.analysisExecutionTime(pjp);
    }

    private Object analysisExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
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
