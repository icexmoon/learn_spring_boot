package com.example.aop.service.impl;

import com.example.aop.service.RemoteConnect;
import com.example.aop.system.annotation.ThrowingRecall;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.service
 * @ClassName : .java
 * @createTime : 2023/5/21 10:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class RemoteConnectImpl implements RemoteConnect {
    @Override
    @ThrowingRecall
    public Object getInformationFromRemoteServer(Object[] params) {
        //用随机数模拟可能出现的远程调用出错
        Random random = new Random();
        int i = random.nextInt(10) + 1;
        if (i <= 5) {
            System.out.println("remote call is fail.");
            throw new RuntimeException("远程调用出现问题");
        }
        System.out.println("remote call is success.");
        return null;
    }
}
