package com.example.test;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 20:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class RemoteServer {
    public enum Weather{
        RAIN,
        SUNNY,
        CLOUDY
    }

    /**
     * 通过远程服务查询当前天气
     * 该接口还未完成
     * @return
     */
    public Weather getWeather(){
        return null;
    }
}
