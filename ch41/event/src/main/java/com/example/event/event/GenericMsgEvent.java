package com.example.event.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.event
 * @ClassName : .java
 * @createTime : 2023/6/15 16:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class GenericMsgEvent<T> extends ApplicationEvent{
    @Getter
    private final T msg;

    public GenericMsgEvent(Object source, T msg) {
        super(source);
        this.msg = msg;
    }
}
