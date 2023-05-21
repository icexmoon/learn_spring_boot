package com.example.aop.controller;

import com.example.aop.service.RemoteConnect;
import com.example.aop.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.controller
 * @ClassName : .java
 * @createTime : 2023/5/21 10:10
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/remote")
public class RemoteController {
    @Autowired
    RemoteConnect remoteConnect;

    @GetMapping("")
    public String home() {
        remoteConnect.getInformationFromRemoteServer(new Object[]{1});
        return Result.success().toString();
    }
}
