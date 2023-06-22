package com.example.cache;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 14:26
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
@Log4j2
@CacheConfig(cacheNames = {"addresses1", "addresses2"})
public class UserService {
    @Getter
    private final Map<String, String> longNameAddresses = new ConcurrentHashMap<>();

    {
        longNameAddresses.put("DavisMiller", "上海南京路15号");
        longNameAddresses.put("RodriguezSmith", "马德里圣玛利亚街101号");
    }

    @Getter
    private final Map<String, String> shortNameAddresses = new ConcurrentHashMap<>();

    {
        shortNameAddresses.put("LiLei", "北京王府井115号");
        shortNameAddresses.put("XiaoMin", "纽约大十字街11号");
    }

    @Cacheable()
    public String getAddress(@NonNull String name) {
        log.info("query name: %s".formatted(name));
        var proxy = (UserService) AopContext.currentProxy();
        if (name.length() <= 8) {
            return proxy.getShortNameAddress(name);
        }
        return proxy.getLongNameAddress(name);
    }

    private String getAddressWithNoCache(@NonNull String name) {
        log.info("query name: %s".formatted(name));
        if (name.length() <= 8) {
            return this.getShortNameAddress(name);
        }
        return this.getLongNameAddress(name);
    }

    @Cacheable("addresses1")
    protected String getLongNameAddress(String name) {
        log.info("query long name: %s".formatted(name));
        if (longNameAddresses.containsKey(name)) {
            return longNameAddresses.get(name);
        }
        return null;
    }

    @Cacheable("addresses2")
    protected String getShortNameAddress(String name) {
        log.info("query short name: %s".formatted(name));
        if (shortNameAddresses.containsKey(name)) {
            return shortNameAddresses.get(name);
        }
        return null;
    }

    @Caching(evict = {
            @CacheEvict(value = "addresses1", allEntries = true),
            @CacheEvict(value = "addresses2", allEntries = true)
    })
    public String clearCacheAndGetAddress(String name) {
        log.info("clear cache and query name: %s".formatted(name));
        return getAddress(name);
    }

    @CachePut()
    public String updateCacheAndGetAddress(String name) {
        log.info("update cache and query name: %s".formatted(name));
        return getAddressWithNoCache(name);
    }

    @Cacheable(condition = "#name.equals('DavisMiller')")
    public String getAddressWithConditionCache(@NonNull String name){
        return getAddressWithNoCache(name);
    }

    @Cacheable(unless = "#result.equals('上海南京路15号')")
    public String getAddressWithConditionCache2(@NonNull String name){
        return getAddressWithNoCache(name);
    }
}
