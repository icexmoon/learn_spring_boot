package com.example.aop.system;

import com.example.aop.aspect.AnalysisAspect;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.system.util
 * @ClassName : .java
 * @createTime : 2023/5/19 17:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
public class AppConfig {
    @Bean
    AnalysisAspect analysisAspect() {
        return new AnalysisAspect();
    }

    @Bean
    static BeanFactoryPostProcessor forceAutoProxyCreatorToExposeProxy() {
        return (beanFactory) -> {
            if (beanFactory instanceof BeanDefinitionRegistry) {
                BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
                AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
            }
        };
    }
}
