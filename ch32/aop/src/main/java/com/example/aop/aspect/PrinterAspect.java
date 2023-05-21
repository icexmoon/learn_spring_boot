package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/20 12:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
@Component
public class PrinterAspect {
    @Before("com.example.aop.aspect.CommonPointcuts.publicControllerMethods()")
    public void beforeControllerMethodsCall(JoinPoint jp) {
        String clsName = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        System.out.println("before %s.%s() is call.".formatted(clsName, methodName));
    }

    @AfterReturning(
            value = "com.example.aop.aspect.CommonPointcuts.publicControllerMethods()",
            returning = "retVal")
    public void afterControllerMethodsCallAndReturn(JoinPoint jp, Object retVal) {
        String clsName = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        System.out.println("after %s.%s() is call and get a return: %s.".formatted(clsName, methodName, retVal));
    }

    @AfterThrowing(
            value = "com.example.aop.aspect.CommonPointcuts.publicControllerMethods()",
            throwing = "exp")
    public void afterControllerMethodsCallAndThrow(JoinPoint jp, Throwable exp) {
        String clsName = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        System.out.println("after %s.%s() is call and get a throw: %s.".formatted(clsName, methodName, exp));
    }

    @After("com.example.aop.aspect.CommonPointcuts.publicControllerMethods()")
    public void afterControllerMethodsCall(JoinPoint jp) {
        String clsName = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        System.out.println("after %s.%s() is call end finally.".formatted(clsName, methodName));
    }

    @Around("com.example.aop.aspect.CommonPointcuts.publicControllerMethods() && args(uid))")
    public Object aroundControllerMethodsCall(ProceedingJoinPoint pjp, Integer uid) throws Throwable {
        System.out.println("around before");
        System.out.println("id is %d".formatted(uid));
        uid = uid + 1;
        Object result = pjp.proceed(new Object[]{uid});
        System.out.println("around end.");
        return result;
    }

    @Before(value = "execution(* com.example.aop.service.SampleService.*(..)) && args(arg)",
            argNames = "arg")
    public void beforeSampleMethodsCall(Integer arg) {
        System.out.println("get arg %d".formatted(arg));
    }

    @Before("execution(* com.example.aop.service.SampleService.*(..)) && args(arg)")
    public void beforeSampleMethodsCall2(Collection<Integer> arg) {
        System.out.println("get arg %s".formatted(arg.toString()));
    }

//    @Before("execution(* com.example.aop.service.UserService.getUserById(..))")
//    public void beforeGetUserCall1(){
//        System.out.println("beforeGetUserCall1() is called.");
//    }
//
//    @Before("execution(* com.example.aop.service.UserService.getUserById(..))")
//    public void beforeGetUserCall2(){
//        System.out.println("beforeGetUserCall2() is called.");
//    }
}
