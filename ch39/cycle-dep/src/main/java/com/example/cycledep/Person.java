package com.example.cycledep;

import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cycle-dep
 * @Package : com.example.cycledep
 * @ClassName : .java
 * @createTime : 2023/6/13 17:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class Person implements InitializingBean {
    @Getter
    private final String name = "LinDa";
    private Dog pet;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public String toString() {
        return "Person(name=%s, pet=%s)".formatted(name, pet.getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.pet = ctx.getBean(Dog.class);
        this.pet.setOwner(this);
    }
}
