package cn.icexmoon.my_first_app.controller;

import cn.icexmoon.my_first_app.model.Result;
import cn.icexmoon.my_first_app.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {
    private Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());
    private AtomicLong index = new AtomicLong();

    @PostMapping("")
    public String addUser(@RequestBody User user) {
        Long newId = index.incrementAndGet();
        user.setId(newId);
        users.put(newId, user);
        Result result = new Result();
        result.setData(newId);
        return result.toString();
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable long id) {
        Result result = new Result();
        if (!users.containsKey(id)) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        users.remove(id);
        result.setMsg("delete success.");
        return result;
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable long id,@RequestBody User user) {
        Result result = new Result();
        if (!users.containsKey(id)) {
            result.setSuccess(false);
            result.setMsg("no this person.");
            return result;
        }
        user.setId(id);
        users.put(id, user);
        return result;
    }

    @GetMapping("/{id}")
    public Result getUser(@PathVariable long id) {
        Result result = new Result();
        User user = users.get(id);
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
        result.setData(users.values());
        return result.toString();
    }
}
