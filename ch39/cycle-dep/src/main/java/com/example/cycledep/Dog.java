package com.example.cycledep;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cycle-dep
 * @Package : com.example.cycledep
 * @ClassName : .java
 * @createTime : 2023/6/13 17:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class Dog {
    @Getter
    private final String name = "Audi";
    @Setter
    private Person owner;

    @Override
    public String toString() {
        return "Dog(name=%s, owner=%s)".formatted(name, owner.getName());
    }
}
