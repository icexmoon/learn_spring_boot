package com.example.log;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : log
 * @Package : com.example.log
 * @ClassName : .java
 * @createTime : 2023/5/23 11:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/hello")
@Log4j2
public class HelloController {
    @GetMapping("")
    public Object home() {
        for (int i = 0; i < 1000; i++) {
            log.debug("test debug.");
        }
        return null;
    }
}
