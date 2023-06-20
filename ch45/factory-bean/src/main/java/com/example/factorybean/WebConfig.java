package com.example.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 13:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
public class WebConfig {
    @Bean("clock")
    public ClockFactory clockFactory() {
        return new ClockFactory();
    }

    @Bean
    public TankFactory tankFactory() {
        return new TankFactory("红旗机械厂", Tank.Model.T99A);
    }
}
