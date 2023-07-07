package com.example.identitifier.v8;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : identitifier
 * @Package : com.example.identitifier.v8
 * @ClassName : .java
 * @createTime : 2023/7/7 16:53
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyGenerator implements IdentifierGenerator, Configurable {
    private String prefix;

    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) {
        IdentifierGenerator.super.configure(type, parameters, serviceRegistry);
        prefix = parameters.getProperty("prefix");
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object obj) {
        EntityPersister entityPersister = session.getEntityPersister(obj.getClass().getName(), obj);
        String query = String.format("select %s from %s",
                entityPersister.getIdentifierPropertyName(),
                entityPersister.getEntityName());

        Stream<String> ids = session.createQuery(query, String.class).stream();

        Long max = ids.map(o -> o.replace(prefix + "-", ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return prefix + "-" + (max + 1);
    }
}
