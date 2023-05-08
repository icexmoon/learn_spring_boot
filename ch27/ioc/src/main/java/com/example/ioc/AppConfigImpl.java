package com.example.ioc;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/7 19:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface AppConfigImpl {
    @Bean("cal2")
    default Calculator calculator2(){
        return new Calculator();
    }
}
