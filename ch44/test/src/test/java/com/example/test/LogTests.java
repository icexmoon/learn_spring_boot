package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @ClassName LogTests
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2025/7/2 上午10:47
 * @Version 1.0
 */
@Slf4j
public class LogTests {
    @Test
    public void test() {
        log.error("test error");
        log.info("test info");
        log.debug("test debug");
        log.trace("test trace");
    }
}
