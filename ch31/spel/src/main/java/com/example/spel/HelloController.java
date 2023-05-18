package com.example.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : spel
 * @Package : com.example.spel
 * @ClassName : .java
 * @createTime : 2023/5/18 21:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("#{ environment.getProperty('user.region') }")
    private String region;
    @Autowired
    private Environment environment;
    @Value("${user.region}")
    private String region2;
    private int randomNum;
    private HelloService helloService;
    private String author;


    public HelloController(@Value("#{ T(java.lang.Math).random()*10+1 }") int randomNum) {
        this.randomNum = randomNum;
    }

    @Autowired
    public void configure(HelloService helloService, @Value("#{ 'icexmoon' }") String author) {
        this.helloService = helloService;
        this.author = author;
    }

    @GetMapping("")
    public String hello() {
        System.out.println(this.region);
        String region = environment.getProperty("user.region");
        System.out.println(region);
        System.out.println(region2);
        System.out.println(randomNum);
        System.out.println(author);
        return Result.success().toString();
    }
}
