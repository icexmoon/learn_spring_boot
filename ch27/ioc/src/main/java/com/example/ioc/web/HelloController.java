package com.example.ioc.web;

import com.example.ioc.annotation.CategoryQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/6 17:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController()
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private ClientMessage clientMessage;
    @Autowired
    private LoginService loginService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private Clock clock1;
    @Autowired
    private Clock clock2;
    @Autowired
    private ApplicationContext ctx;
    @CategoryQualifier(BookCategoryEnum.HISTORY)
    @Autowired
//    @Resource(name = "literatureBookCategories")
    private List<BookCategory> bookCategories;
//    @Resource
//    private List<BookCategory> literatureBookCategories;
    @Autowired
    BookCategory bookCategory;

    @GetMapping("")
    public String hello(@RequestParam("msg") String msg) {
        System.out.println(clock1);
        System.out.println(clock2);
        System.out.println(ctx.getBean("clockFactoryBean"));
        System.out.println(ctx.getBean("&clockFactoryBean"));
        clientMessage.setMessage(msg);
        helloService.doSomething();
        String userName = "guest";
        if (loginService.isLogined()) {
            userName = loginService.getUserName();
        }
        System.out.println(dataSource);
        for (BookCategory bookCategory : bookCategories) {
            System.out.println(bookCategory);
        }
        return Result.success("hello, %s".formatted(userName)).toString();
    }

    @GetMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password) {
        if (!loginService.login(name, password)) {
            return Result.fail("login operation is fail, please check your password.").toString();
        }
        return Result.success(null).toString();
    }

    @GetMapping("/exit")
    public String exit() {
        loginService.exit();
        return Result.success(null).toString();
    }
}
