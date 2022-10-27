package cn.icexmoon.books2.system;

import org.apache.ibatis.cache.Cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system
 * @ClassName : .java
 * @createTime : 2022/10/22 13:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyCache implements Cache {
    private String id;

    private static Map<String, Map<Object, Object>> cachePool = Collections.synchronizedMap(new HashMap<>());

    public MyCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        this.getCurrentCachePool().put(o, o1);
    }

    @Override
    public Object getObject(Object o) {
        return this.getCurrentCachePool().get(o);
    }

    @Override
    public Object removeObject(Object o) {
        return this.getCurrentCachePool().remove(o);
    }

    @Override
    public void clear() {
        this.getCurrentCachePool().clear();
    }

    @Override
    public int getSize() {
        return this.getCurrentCachePool().size();
    }

    private Map<Object, Object> getCurrentCachePool() {
        if (!cachePool.containsKey(id)) {
            cachePool.put(id, Collections.synchronizedMap(new HashMap<>()));
        }
        return cachePool.get(id);
    }
}
