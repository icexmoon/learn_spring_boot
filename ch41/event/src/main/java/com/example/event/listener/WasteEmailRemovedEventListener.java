package com.example.event.listener;

import com.example.event.event.WasteEmailRemovedEvent;
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
 * @createTime : 2023/6/15 16:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class WasteEmailRemovedEventListener {
    @EventListener
    public void eventHandler(WasteEmailRemovedEvent werEvent){
        System.out.printf("Email %s is already removed.%n", werEvent.getEmail());
    }
}
