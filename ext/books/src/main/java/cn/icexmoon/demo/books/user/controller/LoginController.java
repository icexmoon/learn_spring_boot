package cn.icexmoon.demo.books.user.controller;

import cn.icexmoon.demo.books.system.Login;
import cn.icexmoon.demo.books.system.Result;
import cn.icexmoon.demo.books.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private Login login;

    @PostMapping("")
    public String login(@RequestBody User user) {
        Result result = login.checkAndLogin(user.getName(), user.getPassword());
        return result.toString();
    }
}
