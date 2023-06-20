package com.example.factorybean;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 15:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Setter
@Accessors(chain = true)
public class TankFactory2 implements FactoryBean<Tank> {
    @Setter(AccessLevel.NONE)
    private Map<Tank.Model, Integer> motorizedHours = new HashMap<>();

    {
        motorizedHours.put(Tank.Model.T99A, 100);
        motorizedHours.put(Tank.Model.T95, 300);
        motorizedHours.put(Tank.Model.T88, 400);
        motorizedHours.put(Tank.Model.T69, 500);
    }

    private String factoryName;
    private Tank.Model model;

    @PostConstruct
    public void checkFactory() {
        if (ObjectUtils.isEmpty(factoryName) || model == null) {
            throw new RuntimeException("工厂名称或坦克型号不能为空");
        }
        if (!motorizedHours.containsKey(model)) {
            throw new RuntimeException("缺少型号%s的摩托化小时数据".formatted(model));
        }
    }

    @Override
    public Tank getObject() throws Exception {
        Integer motorizedHours = this.motorizedHours.get(model);
        if (motorizedHours == null) {
            throw new RuntimeException("缺少型号%s对应的摩托化小时数据".formatted(model));
        }
        return new Tank(model, factoryName, motorizedHours, Tank.Status.TRAINING);
    }

    @Override
    public Class<?> getObjectType() {
        return Tank.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
