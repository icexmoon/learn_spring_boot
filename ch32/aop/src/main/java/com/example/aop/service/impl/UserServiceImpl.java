package com.example.aop.service.impl;

import com.example.aop.entity.User;
import com.example.aop.service.UserService;
import com.example.aop.system.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.service.impl
 * @ClassName : .java
 * @createTime : 2023/5/19 16:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private TestUtil testUtil;

    @Override
    public void addUser(User user) {
        testUtil.doSomething();
    }

    @Override
    public User getUserById(int id) {
        testUtil.doSomething();
        return new User(id, "icexmoon", "123");
    }
}
