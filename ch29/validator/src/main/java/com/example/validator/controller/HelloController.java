package com.example.validator.controller;

import com.example.validator.entity.Dog;
import com.example.validator.entity.Person;
import com.example.validator.system.pe.CustomPropertyEditorRegistrar;
import com.example.validator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator
 * @ClassName : .java
 * @createTime : 2023/5/15 9:03
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private CustomPropertyEditorRegistrar customPropertyEditorRegistrar;

    @GetMapping("")
    public String hello(@RequestParam Person person, @RequestParam Dog dog){
        System.out.println(person);
        System.out.println(dog);
        return Result.success().toString();
    }

    @InitBinder
    void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Person.class, new PersonEditor());
//        binder.registerCustomEditor(Dog.class, new DogEditor());
        customPropertyEditorRegistrar.registerCustomEditors(binder);
    }
}
