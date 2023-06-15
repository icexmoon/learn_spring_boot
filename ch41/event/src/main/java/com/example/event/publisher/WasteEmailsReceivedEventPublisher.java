package com.example.event.publisher;

import com.example.event.entity.Email;
import com.example.event.event.WasteEmailsReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event
 * @ClassName : .java
 * @createTime : 2023/6/15 13:08
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class WasteEmailsReceivedEventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish(@NonNull List<Email> emails){
        WasteEmailsReceivedEvent event = new WasteEmailsReceivedEvent(this, emails);
        publisher.publishEvent(event);
    }
}
