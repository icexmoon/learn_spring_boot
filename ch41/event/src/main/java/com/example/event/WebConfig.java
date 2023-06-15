package com.example.event;

import com.example.event.entity.Email;
import com.example.event.event.EntityCreatedEvent;
import com.example.event.event.GenericMsgEvent;
import com.example.event.event.IntMsgEvent;
import com.example.event.event.StringMsgEvent;
import com.example.event.publisher.EmailsReceivedEventPublisher;
import com.example.event.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
 * @createTime : 2023/6/15 11:57
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
public class WebConfig {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailsReceivedEventPublisher emailsReceivedEventPublisher;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Email> emails = List.of(
                    new Email("tom@qq.com", "123"),
                    new Email("lilei@qq.com", "hello"),
                    new Email("hanmeimei@qq.com", "good day"),
                    new Email("123@qq.com", "sdfsfs"),
                    new Email("ddd@qq.com", "sdfd"));
            emailsReceivedEventPublisher.publish(emails);
            emailsReceivedEventPublisher.publish(Collections.emptyList());
//            emailService.addEmails(emails);
            eventPublisher.publishEvent(new GenericMsgEvent<String>(this, "hello"));
            eventPublisher.publishEvent(new StringMsgEvent(this, "hello"));
            eventPublisher.publishEvent(new IntMsgEvent(this, 11));
            eventPublisher.publishEvent(new EntityCreatedEvent<>(this, new Email("123@tomcom","sdfdsf")));
        };
    }

//    @Bean(name = "applicationEventMulticaster")
//    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
//        SimpleApplicationEventMulticaster eventMulticaster =
//                new SimpleApplicationEventMulticaster();
//        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
//        return eventMulticaster;
//    }
}
