package cn.icexmoon.my_first_app.controller;

import cn.icexmoon.my_first_app.model.Result;
import cn.icexmoon.my_first_app.model.User;
import cn.icexmoon.my_first_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public String addUser(@RequestBody User user) {
        long newId = userService.addUser(user);
        Result result = new Result();
        result.setData(newId);
        return result.toString();
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable long id) {
        Result result = new Result();
        User user = userService.getUser(id);
        if (user == null) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        userService.deleteUser(id);
        result.setMsg("delete success.");
        return result;
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable long id, @RequestBody User user) {
        Result result = new Result();
        User u = userService.getUser(id);
        if (u == null) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        user.setId(id);
        userService.updateUser(user);
        return result;
    }

    @GetMapping("/{id}")
    public Result getUser(@PathVariable long id) {
        Result result = new Result();
        User user = userService.getUser(id);
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
        result.setData(userService.getUsers());
        return result.toString();
    }
}
