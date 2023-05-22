package com.example.nullsafe.example;

import org.springframework.lang.NonNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : null-safe
 * @Package : com.example.nullsafe.example
 * @ClassName : .java
 * @createTime : 2023/5/22 18:41
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class GrandSon extends Child{
    @NonNull
    @Override
    public Integer plus(@NonNull Integer a, @NonNull Integer b) {
        return super.plus(a, b);
    }
}
