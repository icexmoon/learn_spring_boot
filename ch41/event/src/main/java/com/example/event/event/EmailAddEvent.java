package com.example.event.event;

import com.example.event.entity.EmailEntity;
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
 * @createTime : 2023/6/15 14:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class EmailAddEvent extends ApplicationEvent {
    @Getter
    private final EmailEntity email;

    public EmailAddEvent(Object source, EmailEntity email) {
        super(source);
        this.email = email;
    }
}