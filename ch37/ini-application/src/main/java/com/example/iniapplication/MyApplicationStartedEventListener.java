package com.example.iniapplication;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ini-application
 * @Package : com.example.iniapplication
 * @ClassName : .java
 * @createTime : 2023/6/12 18:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
@Log4j2
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    private final ApplicationContext applicationContext;

    public MyApplicationStartedEventListener(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ApplicationContext eventCtx = event.getApplicationContext();
        if (eventCtx == applicationContext){
            //当前 ApplicationContext 发送的事件
            log.debug("Current ctx's ApplicationStartedEvent is called.");
        }
        else{
            log.debug("Sub ctx's ApplicationStartedEvent is called.");
        }
    }
}
