package com.example.event.listener;

import com.example.event.event.WasteEmailRemovedEvent;
import com.example.event.event.WasteEmailsReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event
 * @ClassName : .java
 * @createTime : 2023/6/15 13:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class WasteEmailsReceivedEventListener {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @EventListener(condition = "!#werEvent.getEmails().isEmpty()")
    public void handleEvent(WasteEmailsReceivedEvent werEvent) throws InterruptedException {
        Thread.sleep(1000);
        werEvent.getEmails().forEach(email -> System.out.printf("将邮件%s移入垃圾邮件%n", email));
        werEvent.getEmails().forEach(email -> {
            this.eventPublisher.publishEvent(new WasteEmailRemovedEvent(WasteEmailsReceivedEventListener.this, email));
        });
    }
}
