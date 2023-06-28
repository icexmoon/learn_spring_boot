package com.example.entitylifecycle;

import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle
 * @Package : com.example.entitylifecycle
 * @ClassName : .java
 * @createTime : 2023/6/27 11:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class DirtyDataRecorderInterceptor implements Interceptor, Serializable {
    private static final List<Object> dirtyEntities = Collections.synchronizedList(new ArrayList<>());

    @Override
    public boolean onFlushDirty(Object entity, Object id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        boolean b = Interceptor.super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
        dirtyEntities.add(entity);
        return b;
    }

    public static List<Object> getDirtyEntities() {
        return dirtyEntities;
    }

    public static void clearDirtyEntitites() {
        dirtyEntities.clear();
    }
}
