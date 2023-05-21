package com.example.aop.aspect;

import com.example.aop.system.annotation.SimpleLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/21 11:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Profile("dev")
@Component()
@Aspect
public class LogAspect {
    @Around("com.example.aop.aspect.CommonPointcuts.publicControllerMethods() && @annotation(simpleLogAnnotation)")
    public Object controllerLogMethodsCall(ProceedingJoinPoint pjp, SimpleLog simpleLogAnnotation) throws Throwable {
        return this.doLog(pjp);
    }

    private Object doLog(ProceedingJoinPoint pjp) throws Throwable {
        String clsName = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        LocalDateTime now = LocalDateTime.now();
        Object result = pjp.proceed();
        System.out.println("###%s### %s.%s(%s) is called, result is %s.".formatted(now, clsName, methodName, Arrays.toString(args), result));
        return result;
    }
}
