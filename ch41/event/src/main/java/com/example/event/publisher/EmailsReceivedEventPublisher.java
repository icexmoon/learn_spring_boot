package com.example.event.publisher;

import com.example.event.entity.Email;
import com.example.event.event.EmailsReceivedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

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
 * @createTime : 2023/6/15 11:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EmailsReceivedEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发布多个邮件收到的事件
     * @param emails
     */
    public void publish(@NonNull List<Email> emails){
        this.doPublishEvent(emails);
    }

    /**
     * 发布邮件收到的事件（单个邮件）
     * @param email
     */
    public void publish(@NonNull Email email){
        List<Email> emails = Collections.singletonList(email);
        this.doPublishEvent(emails);
    }

    private void doPublishEvent(List<Email> emails){
        EmailsReceivedEvent event = new EmailsReceivedEvent(this);
        event.setEmails(emails);
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
