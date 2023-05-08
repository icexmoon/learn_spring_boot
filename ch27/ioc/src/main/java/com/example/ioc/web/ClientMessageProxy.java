package com.example.ioc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/6 17:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
//@Component
public class ClientMessageProxy extends ClientMessage{
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void setMessage(String message) {
        ClientMessage clientMessage = (ClientMessage) ctx.getBean("clientMessage");
        clientMessage.setMessage(message);
    }

    @Override
    public String getMessage() {
        ClientMessage clientMessage = (ClientMessage) ctx.getBean("clientMessage");
        return clientMessage.getMessage();
    }
}
