package cn.icexmoon.my_first_app.controller;

import cn.icexmoon.my_first_app.model.Result;
import cn.icexmoon.my_first_app.model.User;
import cn.icexmoon.my_first_app.service.UserService;
import cn.icexmoon.my_first_app.service.UserServiceInterface;
import cn.icexmoon.my_first_app.service.UserServiceMPImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserService userService, UserServiceMPImpl userServiceMPImpl) {
        userServiceInterface = userServiceMPImpl;
    }

    @ApiOperation("添加多个用户")
    @PostMapping("/some/{flag}")
    public String addSomeUsers(@PathVariable int flag) {
        boolean broken = false;
        if (flag == 1) {
            broken = true;
        }
        Result result = new Result();
        userServiceInterface.addSomeUsers(broken);
        return result.toString();
    }

    @ApiOperation("添加新用户")
    @PostMapping("")
    public String addUser(@RequestBody User user) {
        long newId = userServiceInterface.addUser(user);
        Result result = new Result();
        result.setData(newId);
        return result.toString();
    }

    @ApiOperation("删除指定用户")
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable long id) {
        Result result = new Result();
        User user = userServiceInterface.getUser(id);
        if (user == null) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        userServiceInterface.deleteUser(id);
        result.setMsg("delete success.");
        return result;
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/{id}")
    public Result updateUser(@PathVariable long id, @RequestBody User user) {
        Result result = new Result();
        User u = userServiceInterface.getUser(id);
        if (u == null) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        user.setId(id);
        userServiceInterface.updateUser(user);
        return result;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/{id}")
    public Result getUser(@PathVariable long id) {
        Result result = new Result();
        User user = userServiceInterface.getUser(id);
        if (user == null) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        result.setData(user);
        return result;
    }

    @ApiOperation("获取用户列表")
    @GetMapping("")
    public String getUsers() {
        log.info("getUsers is called.========");
        Result result = new Result();
        result.setData(userServiceInterface.getUsers());
        return result.toString();
    }
}
