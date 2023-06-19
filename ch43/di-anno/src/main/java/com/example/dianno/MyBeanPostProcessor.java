package com.example.dianno;

import com.example.dianno.entity.Carrier;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-anno
 * @Package : com.example.dianno
 * @ClassName : .java
 * @createTime : 2023/6/19 11:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
public class MyBeanPostProcessor implements BeanPostProcessor {
    private final Carrier defaultCarrier;

    public MyBeanPostProcessor(Carrier defaultCarrier) {
        this.defaultCarrier = defaultCarrier;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CarrierService) {
            var cs = (CarrierService) bean;
            var defaultCarField = cs.getClass().getDeclaredField("defaultCar");
            defaultCarField.setAccessible(true);
            defaultCarField.set(bean, defaultCarrier);
            log.info("CarrierService's defaultCarrier field is set: %s".formatted(defaultCarrier));
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
