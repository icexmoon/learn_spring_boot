package com.example.validator.controller;

import com.example.validator.entity.Person;
import com.example.validator.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.controller
 * @ClassName : .java
 * @createTime : 2023/5/15 11:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @Value("${my.person}")
    private Person person;

    @GetMapping("")
    public String home(@RequestParam("person") Person person){
        System.out.println(person);
        return Result.success().toString();
    }

    @GetMapping("/prop")
    public String prop(){
        System.out.println(this.person);
        return Result.success().toString();
    }
}
