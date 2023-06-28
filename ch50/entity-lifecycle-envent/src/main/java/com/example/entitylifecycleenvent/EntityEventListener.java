package com.example.entitylifecycleenvent;

import jakarta.persistence.*;
import lombok.extern.log4j.Log4j2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle-envent
 * @Package : com.example.entitylifecycleenvent
 * @ClassName : .java
 * @createTime : 2023/6/28 19:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
public class EntityEventListener {
    @PrePersist
    public void prePersist(Object entity) {
        log.info("New Entity %s will be add.".formatted(entity));
    }

    @PostPersist
    public void postPersist(Object entity) {
        log.info("New Entity %s is already added.".formatted(entity));
    }

    @PreRemove
    public void preRemove(Object entity) {
        log.info("Entity %s will be removed.".formatted(entity));
    }

    @PostRemove
    public void postRemove(Object entity) {
        log.info("Entity %s is already removed.".formatted(entity));
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        log.info("Entity %s is will be updated.".formatted(entity));
    }

    @PostUpdate
    public void postUpdate(Object entity) {
        log.info("Entity %s is already updated.".formatted(entity));
    }

    @PostLoad
    public void postLoad(Object entity) {
        log.info("Entity %s is loaded.".formatted(entity));
    }
}
