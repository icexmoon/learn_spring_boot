package com.example.event.event;

import com.example.event.entity.Email;
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
 * @createTime : 2023/6/15 16:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class WasteEmailRemovedEvent extends ApplicationEvent {
    @Getter
    private final Email email;
    public WasteEmailRemovedEvent(Object source, Email email) {
        super(source);
        this.email = email;
    }
}
