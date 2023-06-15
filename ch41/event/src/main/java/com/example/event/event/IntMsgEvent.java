package com.example.event.event;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.event
 * @ClassName : .java
 * @createTime : 2023/6/15 16:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class IntMsgEvent extends GenericMsgEvent<Integer>{
    public IntMsgEvent(Object source, Integer msg) {
        super(source, msg);
    }
}
