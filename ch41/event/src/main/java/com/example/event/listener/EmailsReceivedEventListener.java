package com.example.event.listener;

import com.example.event.EmailBlacklist;
import com.example.event.event.WasteEmailsReceivedEvent;
import com.example.event.entity.Email;
import com.example.event.event.EmailsReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event
 * @ClassName : .java
 * @createTime : 2023/6/15 11:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EmailsReceivedEventListener {
    @Autowired
    private EmailBlacklist emailBlacklist;

    @Order(2)
    @EventListener(condition = "!#erEvent.getEmails().isEmpty()")
    public List<WasteEmailsReceivedEvent> handleEvent(EmailsReceivedEvent erEvent) {
        List<String> addresses = erEvent.getEmails().stream()
                .map(Email::address)
                .collect(Collectors.toList());
        System.out.printf("收到多个电子邮件：%s%n", addresses);
        List<Email> wasteEmails = erEvent.getEmails().stream()
                .filter(email -> emailBlacklist.inBlackList(email.address()))
                .toList();
        return wasteEmails.stream()
                .map(email -> new WasteEmailsReceivedEvent(EmailsReceivedEventListener.this, List.of(email)))
                .collect(Collectors.toList());
    }

    @Order(1)
    @EventListener({EmailsReceivedEvent.class, ContextRefreshedEvent.class})
    public void receivedTip(Object event) {
        if (event instanceof EmailsReceivedEvent) {
            System.out.println("some emails get.");
        } else if (event instanceof ContextRefreshedEvent) {
            System.out.println("ApplicationContext is refreshed.");
        } else {
            ;
        }
    }
}
