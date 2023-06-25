package com.example.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 14:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = CacheApplication.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class UserServiceTests {
    @Autowired
    private UserService userService;
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CacheUtil cacheUtil;

    @BeforeEach
    void beforeEach(){
        cacheUtil.clearAllCache();
        ConcurrentHashMap<String, String> longNameAddresses = new ConcurrentHashMap<>();
        userService.setLongNameAddresses(longNameAddresses);
        ConcurrentHashMap<String, String> shortNameAddresses = new ConcurrentHashMap<>();
        userService.setShortNameAddresses(shortNameAddresses);
        longNameAddresses.put("DavisMiller", "上海南京路15号");
        longNameAddresses.put("RodriguezSmith", "马德里圣玛利亚街101号");
        shortNameAddresses.put("LiLei", "北京王府井115号");
        shortNameAddresses.put("XiaoMin", "纽约大十字街11号");
    }

    @Test
    void testUserService() {
        var address1 = userService.getAddress("DavisMiller");
        var address2 = userService.getAddress("DavisMiller");
        var address3 = userService.getLongNameAddress("DavisMiller");
        Assertions.assertEquals("上海南京路15号", address1);
        Assertions.assertEquals(address1, address2);
        Assertions.assertEquals(address2, address3);
        var address4 = userService.getShortNameAddress("DavisMiller");
        Assertions.assertEquals(address1, address4);
        var address5 = userService.getLongNameAddress("RodriguezSmith");
        Assertions.assertEquals("马德里圣玛利亚街101号", address5);
        var address6 = userService.getShortNameAddress("RodriguezSmith");
        Assertions.assertNull(address6);
        var address7 = userService.getAddress("RodriguezSmith");
        Assertions.assertEquals(address5, address7);
        var address8 = userService.clearCacheAndGetAddress("RodriguezSmith");
        Assertions.assertEquals(address8, address7);
        userService.getAddress("RodriguezSmith");
        userService.getAddress("DavisMiller");
    }

    @Test
    void testCachePut() {
        var address1 = userService.getAddress("DavisMiller");
        Assertions.assertEquals("上海南京路15号", address1);
        var newAddress = "佛罗伦萨香榭丽舍大街255号";
        userService.getLongNameAddresses().put("DavisMiller", newAddress);
        var address2 = userService.updateCacheAndGetAddress("DavisMiller");
        Assertions.assertEquals(address2, newAddress);
        var address3 = userService.getAddress("DavisMiller");
        Assertions.assertEquals(address3, newAddress);
    }

    @Test
    void testGetAddressWithConditionCache(){
        var name = "DavisMiller";
        var name2 = "RodriguezSmith";
        userService.getAddressWithConditionCache(name);
        userService.getAddressWithConditionCache(name2);
        cacheUtil.printCacheManager();
    }

    @Test
    void testGetAddressWithConditionCache2(){
        var name = "DavisMiller";
        var name2 = "RodriguezSmith";
        userService.getAddressWithConditionCache2(name);
        userService.getAddressWithConditionCache2(name2);
        cacheUtil.printCacheManager();
    }

    @Test
    void testGetAddressWithUser(){
        User user = new User("DavisMiller");
        userService.getAddress(user);
        Assertions.assertTrue(cacheUtil.containMethodCache("addresses3", user.getName()));
    }
}