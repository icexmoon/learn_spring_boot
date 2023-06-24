package com.example.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/23 15:41
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {CacheApplication.class})
public class CacheUtilTests {
    @Autowired
    private CacheUtil cacheUtil;
    @Autowired
    private UserService userService;

    @BeforeEach
    void beforeEach() {
        cacheUtil.clearAllCache();
    }

    @Test
    void testGetKey() {
        var key = cacheUtil.getKey("icexmoon");
        Assertions.assertEquals(key, "icexmoon");
        String[] params = {"param1", "param2"};
        var key2 = cacheUtil.getKey((Object[]) params);
        Assertions.assertEquals(new SimpleKey((Object[]) params), key2);
        var key3 = cacheUtil.getKey();
        Assertions.assertSame(SimpleKey.EMPTY, key3);
    }

    @Test
    void testContainMethodCache() {
        String name = "DavisMiller";
        userService.getAddress(name);
        var contained = cacheUtil.containMethodCache("addresses1", name);
        Assertions.assertTrue(contained);
        contained = cacheUtil.containMethodCache("addresses2", name);
        Assertions.assertTrue(contained);
    }

    @Test
    void testGetMethodCachedReturn() {
        var addresses = userService.getShortNameAddresses();
        var cacheName1 = "addresses1";
        var cacheName2 = "addresses2";
        addresses.forEach((key, val) -> {
            Assertions.assertNull(cacheUtil.getMethodCachedReturn(cacheName1, key));
            Assertions.assertNull(cacheUtil.getMethodCachedReturn(cacheName2, key));
        });
        addresses.forEach((key, val) -> {
            userService.getAddress(key);
            var address1 = cacheUtil.getMethodCachedReturn(cacheName1, key);
            var address2 = cacheUtil.getMethodCachedReturn(cacheName2, key);
            Assertions.assertEquals(val, address1.get());
            Assertions.assertEquals(val, address2.get());
        });
    }

    @Test
    void testContainMethodCacheBoth() {
        List<String> cacheNames = List.of("addresses1", "addresses2");
        var shortAddresses = userService.getShortNameAddresses();
        for (var entry : shortAddresses.entrySet()) {
            var key = entry.getKey();
            userService.getShortNameAddress(key);
            Assertions.assertFalse(cacheUtil.containMethodCacheBoth(cacheNames, key));
        }
        userService.clearCacheAndGetAddress("");
        for (var entry : shortAddresses.entrySet()) {
            var key = entry.getKey();
            userService.getAddress(key);
            Assertions.assertTrue(cacheUtil.containMethodCacheBoth(cacheNames, key));
        }
    }
}
