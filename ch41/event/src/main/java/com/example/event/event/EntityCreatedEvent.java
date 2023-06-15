package com.example.event.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.event
 * @ClassName : .java
 * @createTime : 2023/6/15 17:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class EntityCreatedEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
    @Getter
    private final T entity;

    public EntityCreatedEvent(Object source, T entity) {
        super(source);
        this.entity = entity;
    }

    @Override
    public ResolvableType getResolvableType() {
        ResolvableType resolvableType = ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(entity));
        return resolvableType;
    }
}
