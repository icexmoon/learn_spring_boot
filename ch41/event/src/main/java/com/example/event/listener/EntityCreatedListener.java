package com.example.event.listener;

import com.example.event.entity.Email;
import com.example.event.event.EntityCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.listener
 * @ClassName : .java
 * @createTime : 2023/6/15 17:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EntityCreatedListener {
    @EventListener
    public void EmailCreatedListener(EntityCreatedEvent<Email> entityCreatedEvent){
        System.out.printf("email is created, email: %s%n", entityCreatedEvent.getEntity());
    }
}
