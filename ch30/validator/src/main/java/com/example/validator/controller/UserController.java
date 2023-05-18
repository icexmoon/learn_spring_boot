package com.example.validator.controller;

import com.example.validator.dto.UserDTO;
import com.example.validator.service.UserService;
import com.example.validator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator
 * @ClassName : .java
 * @createTime : 2023/5/17 17:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@Validated @RequestBody UserDTO user) {
        userService.addUser(user);
        return Result.success().toString();
    }

    @PostMapping("/add/springValidator")
    public String addUserWithSpringValidator(@RequestBody UserDTO user){
        userService.addUserWithSpringValidator(user);
        return Result.success().toString();
    }

//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
//        webDataBinder.addValidators(new UserValidator());
//    }
}
