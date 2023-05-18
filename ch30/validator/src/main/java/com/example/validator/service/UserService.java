package com.example.validator.service;

import com.example.validator.dto.UserDTO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.service
 * @ClassName : .java
 * @createTime : 2023/5/17 19:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserService {
    void addUser(UserDTO userDTO);
    void addUserWithSpringValidator(UserDTO userDTO);
}
