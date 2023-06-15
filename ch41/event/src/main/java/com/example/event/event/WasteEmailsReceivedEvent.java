package com.example.event.event;

import com.example.event.entity.Email;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event
 * @ClassName : .java
 * @createTime : 2023/6/15 13:04
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class WasteEmailsReceivedEvent extends ApplicationEvent {
    @Getter
    private final List<Email> emails;

    public WasteEmailsReceivedEvent(Object source, @NonNull List<Email> emails) {
        super(source);
        this.emails = emails;
    }
}
