package com.example.ioc.web;

import com.example.ioc.ScopeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/8 20:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Scope(ScopeValue.PROTOTYPE)
@Component
public class Clock {
    private static int i = 0;
    private int num = i++;
    private LocalDateTime time;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public Clock(LocalDateTime time) {
        this.time = time;
    }

    @Autowired
    public Clock() {
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Clock#%d(%s)".formatted(num, dateTimeFormatter.format(time));
    }
}
