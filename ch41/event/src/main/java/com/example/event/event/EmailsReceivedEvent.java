package com.example.event.event;

import com.example.event.entity.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event
 * @ClassName : .java
 * @createTime : 2023/6/15 11:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 收到多个电子邮件的事件
 */
public class EmailsReceivedEvent {
    @Setter
    @Getter
    private List<Email> emails = Collections.emptyList();
    private final Object source;

    public EmailsReceivedEvent(Object source) {
        this.source = source;
    }
}
