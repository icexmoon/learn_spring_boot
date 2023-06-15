package com.example.event.event;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.event
 * @ClassName : .java
 * @createTime : 2023/6/15 16:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class StringMsgEvent extends GenericMsgEvent<String> {
    public StringMsgEvent(Object source, String msg) {
        super(source, msg);
    }
}
