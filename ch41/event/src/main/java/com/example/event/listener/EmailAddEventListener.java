package com.example.event.listener;

import com.example.event.event.EmailAddEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.listener
 * @ClassName : .java
 * @createTime : 2023/6/15 15:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class EmailAddEventListener {
    @TransactionalEventListener
    public void addSuccess(EmailAddEvent eaEvent){
        System.out.printf("Email %s is already add to db.%n", eaEvent.getEmail());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void addFail(EmailAddEvent eaEvent){
        System.out.printf("Email %s add to db failed.%n", eaEvent.getEmail());
    }
}
