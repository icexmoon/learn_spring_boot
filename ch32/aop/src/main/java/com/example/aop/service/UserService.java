package com.example.aop.service;

import com.example.aop.entity.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.service
 * @ClassName : .java
 * @createTime : 2023/5/19 16:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserService {
    void addUser(User user);

    User getUserById(int id);
}
