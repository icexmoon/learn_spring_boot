package com.example.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/24 8:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = CacheApplication.class)
public class MethodKeyTests {
    @Test
    void testMethodKeyHashCode() throws NoSuchMethodException {
        Method currentMethod = this.getClass().getDeclaredMethod("testMethodKeyHashCode");
        var key = new MethodKey(currentMethod, "11");
        var key2 = new MethodKey(currentMethod, "11");
        Assertions.assertEquals(key, key2);
        Assertions.assertEquals(key.hashCode(), key2.hashCode());
        var key3 = new MethodKey(currentMethod, "22");
        Assertions.assertNotEquals(key2, key3);
    }
}
