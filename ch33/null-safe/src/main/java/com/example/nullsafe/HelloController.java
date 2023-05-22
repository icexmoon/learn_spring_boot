package com.example.nullsafe;

import com.example.nullsafe.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : null-safe
 * @Package : com.example.nullsafe
 * @ClassName : .java
 * @createTime : 2023/5/22 14:26
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private MyUtil myUtil;
    @Autowired
    private HelloService helloService;

    @GetMapping("")
    public Object hello() {
        helloService.plusWithNoAnnotation(1, null);
        Integer c = helloService.plus(1, null);
        System.out.println(c);
        myUtil.plus(1, null);
        return null;
    }
}
