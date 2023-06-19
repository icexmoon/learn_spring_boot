package com.example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 19:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringBootTest(args = "--app.test=one")
public class TestApplicationArgs {
    @Test
    void testArgs(@Autowired ApplicationArguments arguments){
        Assertions.assertTrue(arguments.getOptionNames().contains("app.test"));
        Assertions.assertTrue(arguments.getOptionValues("app.test").contains("one"));
    }
}


