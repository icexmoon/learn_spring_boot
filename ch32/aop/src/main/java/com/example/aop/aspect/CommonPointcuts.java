package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/20 11:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
public class CommonPointcuts {
    @Pointcut("within(com.example.aop.controller..*)")
    public void inControllerLayer(){}

    @Pointcut("within(com.example.aop.service..*)")
    public void inServiceLayer(){}

    @Pointcut("execution(public * *(..))")
    public void publicMethods(){}

    @Pointcut("inControllerLayer() && publicMethods()")
    public void publicControllerMethods(){}

    @Pointcut("inServiceLayer() && publicMethods()")
    public void publicServiceMethods(){}
}
