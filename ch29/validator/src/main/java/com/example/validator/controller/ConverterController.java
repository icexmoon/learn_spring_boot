package com.example.validator.controller;

import com.example.validator.entity.Person;
import com.example.validator.util.Result;
import jakarta.annotation.Resource;
import org.springframework.core.convert.ConversionService;
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
 * @createTime : 2023/5/15 19:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/converter")
public class ConverterController {
    @Resource
    private ConversionService conversionService;

    @GetMapping("")
    public String converter(@RequestParam("person") String personText){
        Person person = conversionService.convert(personText, Person.class);
        System.out.println(person);
        return Result.success().toString();
    }

    @GetMapping("/auto")
    public String converter(@RequestParam("person") Person person){
        System.out.println(person);
        return Result.success().toString();
    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
//
//    }
}
