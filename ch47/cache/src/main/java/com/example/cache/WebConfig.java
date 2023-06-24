package com.example.cache;

import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/22 9:47
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@EnableCaching
public class WebConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(
                new ConcurrentMapCache("fibonacci"),
                new ConcurrentMapCache("addresses1"),
                new ConcurrentMapCache("addresses2"),
                new ConcurrentMapCache("tmp")));
        return cacheManager;
    }

//    @Bean
//    public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
//        return cacheManager -> {
//            cacheManager.setCacheNames(List.of("fibonacci", "addresses1", "addresses2"));
//        };
//    }

    @Bean
    static BeanFactoryPostProcessor forceAutoProxyCreatorToExposeProxy() {
        return (beanFactory) -> {
            if (beanFactory instanceof BeanDefinitionRegistry) {
                BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
                AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
            }
        };
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    KeyGenerator keyGenerator(){
        return new SimpleKeyGenerator();
    }

    @Bean
    MethodKeyGenerator methodKeyGenerator(){
        return new MethodKeyGenerator();
    }
}
