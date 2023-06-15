package com.example.event.service;

import com.example.event.entity.Email;
import com.example.event.entity.EmailEntity;
import com.example.event.event.EmailAddEvent;
import com.example.event.mapper.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @createTime : 2023/6/15 14:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class EmailService {
    @Autowired
    private EmailMapper emailMapper;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    /**
     * 将电子邮件批量添加到持久层
     */
    @Transactional
    public void addEmails(List<Email> emails){
        this.addEmailEntities(emails.stream()
                .map(Email::toEmailEntity)
                .collect(Collectors.toList()));
    }

    @Transactional
    public void addEmailEntities(List<EmailEntity> emailEntities){
        emailEntities.forEach(emailEntity -> {
            eventPublisher.publishEvent(new EmailAddEvent(EmailService.this, emailEntity));
        });
        emailEntities.forEach(emailEntity -> emailMapper.insert(emailEntity));
    }
}
