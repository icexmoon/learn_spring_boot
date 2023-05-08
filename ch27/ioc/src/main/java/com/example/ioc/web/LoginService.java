package com.example.ioc.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/6 19:15
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class LoginService {

    @AllArgsConstructor
    private class Account {
        String name;
        String password;
    }

    @Autowired
    private LoginUser loginUser;
    private Map<String, Account> accounts = Collections.synchronizedMap(new HashMap<>());

    public LoginService() {
        this.accounts.put("hello", new Account("hello", "123"));
        this.accounts.put("LiLei", new Account("LiLei", "123"));
    }

    /**
     * 执行登录操作
     *
     * @param name     用户名
     * @param password 密码
     * @return 成功或失败
     */
    public boolean login(String name, String password) {
        //注销用户
        loginUser.setUserName(null);
        //检查密码是否正确
        if (!accounts.containsKey(name)) {
            return false;
        }
        Account localAccount = accounts.get(name);
        if (localAccount == null || !localAccount.password.equals(password)) {
            return false;
        }
        //执行登录操作
        loginUser.setUserName(name);
        return true;
    }

    public boolean isLogined() {
        return loginUser.isLogined();
    }

    public String getUserName() {
        return loginUser.getUserName();
    }


    /**
     * 注销用户
     */
    public void exit(){
        loginUser.setUserName(null);
    }

}
