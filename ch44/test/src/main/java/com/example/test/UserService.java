package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 20:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class UserService {
    @Autowired
    private RemoteServer remoteServer;

    /**
     * 生成一段用户欢迎信息
     *
     * @return
     */
    public String getHelloMsg() {
        var weather = remoteServer.getWeather();
        var msg = new StringBuilder();
        switch (weather) {
            case RAIN -> msg.append("今天有雨，记得带伞。");
            case CLOUDY -> msg.append("今天多云，可以出去浪。");
            case SUNNY -> msg.append("阳关有点强烈，记得防晒喔。");
            default -> msg.append("我也不清楚天气状态，自己看天气预报吧。");
        }
        return msg.toString();
    }
}
