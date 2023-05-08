package com.example.ioc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/6 17:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class HelloService {
    @Autowired
    private ClientMessage clientMessage;
    @Autowired
    private Vehicle car;

    public void doSomething() {
        String msg = clientMessage.getMessage();
        System.out.println(String.format("get msg from client: %s", msg));
    }
}
