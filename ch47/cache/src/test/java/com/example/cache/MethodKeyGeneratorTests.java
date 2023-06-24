package com.example.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/24 9:57
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {CacheApplication.class})
public class MethodKeyGeneratorTests {

    @Autowired
    private UserService userService;
    @Autowired
    private CacheUtil cacheUtil;

    @Test
    void testMethodKeyGenerator() {
        String name = "DavisMiller";
        userService.getAddressWithMethodKeyCache(name);
        userService.getAddressWithMethodKeyCache2(name);
        userService.getAddressWithMethodKeyCache(name);
        String name2 = "RodriguezSmith";
        userService.getAddressWithMethodKeyCache(name2);
        userService.getAddressWithMethodKeyCache(name2);
    }
}
