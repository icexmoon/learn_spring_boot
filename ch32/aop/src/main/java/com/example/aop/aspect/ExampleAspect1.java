package com.example.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.aspect
 * @ClassName : .java
 * @createTime : 2023/5/20 21:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Aspect
@Component
public class ExampleAspect1 implements Ordered {
    @Before("execution(* com.example.aop.service.UserService.getUserById(..))")
    public void beforeGetUserCall1(){
        System.out.println("beforeGetUserCall1() is called.");
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @After("execution(* com.example.aop.service.UserService.getUserById(..))")
    public void afterGetUserCall1(){
        System.out.println("afterGetUserCall1() is called.");
    }
}
