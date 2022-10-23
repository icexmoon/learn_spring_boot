package cn.icexmoon.books2.user.controller;

import cn.icexmoon.books2.user.entity.User;
import cn.icexmoon.books2.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.controller
 * @ClassName : .java
 * @createTime : 2022/10/10 8:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/user/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
