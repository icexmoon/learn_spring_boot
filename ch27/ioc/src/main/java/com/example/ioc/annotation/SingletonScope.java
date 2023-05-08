package com.example.ioc.annotation;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.annotaion
 * @ClassName : .java
 * @createTime : 2023/5/6 10:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope("singleton")
public @interface SingletonScope {
}
