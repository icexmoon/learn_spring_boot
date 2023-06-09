package com.example.dicollections.controller;

import com.example.dicollections.entity.Motorcycle;
import com.example.dicollections.entity.Vehicle;
import com.example.dicollections.system.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections.controller
 * @ClassName : .java
 * @createTime : 2023/6/9 23:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private List<Vehicle> vehicles;
    @Autowired
    private List<Motorcycle> motorcycles;

    @GetMapping("/print")
    public Result<Object> print() throws NoSuchFieldException {
        System.out.println(vehicles);
        System.out.println(motorcycles);
        ResolvableType resolvableType = ResolvableType.forField(this.getClass().getDeclaredField("vehicles"));
        System.out.println(resolvableType);
        ResolvableType generic = resolvableType.getGeneric();
        System.out.println(generic);
        Class<?> resolve = generic.resolve();
        System.out.println(resolve);
        return Result.success();
    }
}
