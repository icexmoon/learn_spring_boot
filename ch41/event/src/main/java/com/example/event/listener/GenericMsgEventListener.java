package com.example.event.listener;

import com.example.event.event.GenericMsgEvent;
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
 * @createTime : 2023/6/15 16:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class GenericMsgEventListener {
    @EventListener
    public void strEventHandler(GenericMsgEvent<String> gmEvent){
        System.out.printf("String msg event is get, msg:%s.%n", gmEvent.getMsg());
    }

    @EventListener
    public void intEventHandler(GenericMsgEvent<Integer> gmEvent){
        System.out.printf("Int msg event is get, msg:%s.%n", gmEvent.getMsg());
    }
}
