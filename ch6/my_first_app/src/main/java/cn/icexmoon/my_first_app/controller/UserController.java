package cn.icexmoon.my_first_app.controller;

import cn.icexmoon.my_first_app.model.Result;
import cn.icexmoon.my_first_app.model.User;
import cn.icexmoon.my_first_app.service.UserService;
import cn.icexmoon.my_first_app.service.UserServiceInterface;
import cn.icexmoon.my_first_app.service.UserServiceMPImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserService userService, UserServiceMPImpl userServiceMPImpl) {
        userServiceInterface = userServiceMPImpl;
    }

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

    @PostMapping("")
    public String addUser(@RequestBody User user) {
        long newId = userServiceInterface.addUser(user);
        Result result = new Result();
        result.setData(newId);
        return result.toString();
    }

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

    @GetMapping("")
    public String getUsers() {
        Result result = new Result();
        result.setData(userServiceInterface.getUsers());
        return result.toString();
    }
}
