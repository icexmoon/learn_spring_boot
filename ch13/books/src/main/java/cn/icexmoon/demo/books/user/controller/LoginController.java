package cn.icexmoon.demo.books.user.controller;

import cn.icexmoon.demo.books.system.Login;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.user.entity.User;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("登录")
    public Result login(@RequestBody User user) {
        return login.checkAndLogin(user.getName(), user.getPassword());
    }
}
