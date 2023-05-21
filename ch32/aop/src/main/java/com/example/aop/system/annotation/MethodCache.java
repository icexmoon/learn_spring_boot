package com.example.aop.system.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.system.annotation
 * @ClassName : .java
 * @createTime : 2023/5/21 12:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodCache {
    String value() default "";

    long cacheLong() default 5;//缓存时间长度

    TimeUnit unit() default TimeUnit.MINUTES; //时间单位
}
