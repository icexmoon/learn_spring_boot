package com.example.entitylifecycle;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle
 * @Package : com.example.entitylifecycle
 * @ClassName : .java
 * @createTime : 2023/6/27 13:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class HibernateLifecycleUtil {
    @SneakyThrows
    public List<EntityEntry> getManagedEntities(Session session) {
        // 传入的参数 session 不能是一个代理对象，否则会报类型转换错误
        Map.Entry<Object, EntityEntry>[] entries = ((SessionImplementor) session).getPersistenceContext().reentrantSafeEntityEntries();
        return Arrays.stream(entries).map(e -> e.getValue()).collect(Collectors.toList());
    }
}
