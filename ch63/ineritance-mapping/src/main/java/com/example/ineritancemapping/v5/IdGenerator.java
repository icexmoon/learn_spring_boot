package com.example.ineritancemapping.v5;

import lombok.Synchronized;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v5
 * @ClassName : .java
 * @createTime : 2023/7/7 12:37
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class IdGenerator {
    private long id = 0;

    @Synchronized
    long nextValue() {
        id++;
        return id;
    }
}
