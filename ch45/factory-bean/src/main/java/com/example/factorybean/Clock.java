package com.example.factorybean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 13:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Clock {
    private LocalDateTime time;
    private int num;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public Clock(LocalDateTime time, int num) {
        this.time = time;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Clock#%d(%s)".formatted(num, dateTimeFormatter.format(time));
    }
}
