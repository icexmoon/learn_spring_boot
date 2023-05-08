package com.example.ioc.web;

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
 * @createTime : 2023/5/8 20:57
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class SimpleClock {
    private LocalDateTime time;
    private int num;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public SimpleClock(LocalDateTime time, int num) {
        this.time = time;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Clock#%d(%s)".formatted(num, dateTimeFormatter.format(time));
    }
}
