package com.example.event;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event
 * @ClassName : .java
 * @createTime : 2023/6/15 13:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EmailBlacklist {
    private final Set<String> addresses = Set.of("lilei@qq.com", "123@qq.com", "ddd@qq.com");

    public boolean inBlackList(String address) {
        return addresses.contains(address);
    }
}
