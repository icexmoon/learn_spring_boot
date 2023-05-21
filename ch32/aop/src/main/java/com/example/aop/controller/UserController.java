package com.example.aop.controller;

import com.example.aop.entity.User;
import com.example.aop.service.SampleService;
import com.example.aop.service.UserService;
import com.example.aop.system.annotation.Auditable;
import com.example.aop.system.annotation.MethodCache;
import com.example.aop.system.annotation.SimpleLog;
import com.example.aop.system.util.Result;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.controller
 * @ClassName : .java
 * @createTime : 2023/5/19 16:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SampleService<Integer> sampleService;

    @Auditable(1)
    @GetMapping("/get/{id}")
    @SimpleLog
    @MethodCache()
    public String getUser(@Min(1) @PathVariable("id") Integer id) {
        System.out.println("UserController.getUser(%d) is called.".formatted(id));
        userService.getUserById(id);
        userService.addUser(new User(id, "icexmoon", "123"));
        return Result.success().toString();
    }

    @GetMapping("")
    public String home() {
        int i = 1 / 0;
        return Result.success().toString();
    }

    @GetMapping("/sample")
    public String sample() {
        sampleService.sampleGenericMethod(1);
        sampleService.sampleGenericCollectionMethod(List.of(1, 2, 3));
        return Result.success().toString();
    }
}
