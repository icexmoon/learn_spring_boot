package com.example.test.service;

import com.example.test.RemoteServer;
import com.example.test.TestApplication;
import com.example.test.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test.service
 * @ClassName : .java
 * @createTime : 2023/6/19 20:10
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {TestApplication.class})
public class TestUserService3 {
    @Autowired
    private UserService userService;
    @MockBean
    private RemoteServer remoteServer;

    @Test
    void testGetHelloMsg() {
        BDDMockito.given(this.remoteServer.getWeather()).willReturn(RemoteServer.Weather.RAIN);
        var msg = userService.getHelloMsg();
        Assertions.assertEquals("今天有雨，记得带伞。", msg);
    }
}
