package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 15:42
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class CacheUtil {
    @Autowired
    private CacheManager cacheManager;

    /**
     * 打印 CacheManager 中的所有缓存
     */
    public void printCacheManager() {
        var names = cacheManager.getCacheNames();
        names.forEach(this::printCache);
    }

    /**
     * 打印 CacheManager 中的指定缓存（必须是 ConcurrentMapCache 实现）
     *
     * @param cacheName 缓存名称
     */
    public void printCache(String cacheName) {
        var cache = cacheManager.getCache(cacheName);
        System.out.println("cache:%s".formatted(cacheName));
        if (cache instanceof ConcurrentMapCache) {
            var cmCache = (ConcurrentMapCache) cache;
            var nCache = cmCache.getNativeCache();
            nCache.forEach((key, value) -> {
                System.out.println("key=%s,value=%s".formatted(key, value));
            });
        }
    }
}
