package com.example.validator.controller;

import com.example.validator.entity.Name;
import com.example.validator.system.annotation.NameFormat;
import com.example.validator.util.Result;
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
 * @createTime : 2023/5/16 15:01
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("")
    public String name(@NameFormat @RequestParam Name name) {
        System.out.println(name);
        return Result.success().toString();
    }
}
