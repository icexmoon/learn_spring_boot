package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * 获取方法缓存对应的key
     *
     * @param params 方法实参
     * @return 缓存key
     */
    public Object getKey(Object... params) {
        return SimpleKeyGenerator.generateKey(params);
    }

    /**
     * 返回对应名称的缓存
     *
     * @param name 缓存名称
     * @return 缓存对象
     */
    public Cache getCache(String name) {
        return cacheManager.getCache(name);
    }

    /**
     * 判断指定缓存中是否有某个方法调用的缓存
     *
     * @param cacheName 缓存名称
     * @param params    方法调用实参
     * @return 是否包含该方法调用的缓存
     */
    public boolean containMethodCache(String cacheName, Object... params) {
        return this.getMethodCachedReturn(cacheName, params) != null;
    }

    /**
     * 获取指定缓存对象中的方法缓存的返回结果
     *
     * @param cacheName 缓存名称
     * @param params    方法调用实参
     * @return 如果没有缓存，返回null，否则返回ValueWrapper对象（包含缓存结果本身为null的情况）
     */
    public Cache.ValueWrapper getMethodCachedReturn(String cacheName, Object... params) {
        var cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            throw new IllegalArgumentException("没有名称为%s的缓存对象".formatted(cacheName));
        }
        return cache.get(getKey(params));
    }

    /**
     * 是否CacheManager中的指定缓存（多个）都有某个方法缓存
     *
     * @param cacheNames 缓存名称（多个）
     * @param params     方法调用实参
     * @return 是否全部拥有对应方法调用的缓存
     */
    public boolean containMethodCacheBoth(List<String> cacheNames, Object... params) {
        for (var cacheName : cacheNames) {
            if (!this.containMethodCache(cacheName, params)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 清空指定缓存
     * @param cacheName 缓存名称
     */
    public void clearCache(@NonNull String cacheName){
        Cache cache = this.cacheManager.getCache(cacheName);
        if (cache == null){
            throw new IllegalArgumentException("没有名称为%s的缓存".formatted(cacheName));
        }
        cache.clear();
    }

    /**
     * 清空 CacheManager 的所有缓存
     */
    public void clearAllCache(){
        cacheManager.getCacheNames().forEach(this::clearCache);
    }
}
