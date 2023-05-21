package com.example.aop.controller;

import com.example.aop.system.annotation.SimpleLog;
import com.example.aop.system.util.Result;
import org.springframework.aop.framework.AopContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.controller
 * @ClassName : .java
 * @createTime : 2023/5/21 17:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/self")
public class SelfController {
    @GetMapping("")
    @SimpleLog
    public String home() {
        System.out.println("SelfController.home() is call.");
//        this.anotherMethod();
        SelfController aopProxy = (SelfController) AopContext.currentProxy();
        aopProxy.anotherMethod();
        return Result.success().toString();
    }

    @SimpleLog
    public void anotherMethod() {
        System.out.println("SelfController.anotherMethod() is call.");
    }
}
