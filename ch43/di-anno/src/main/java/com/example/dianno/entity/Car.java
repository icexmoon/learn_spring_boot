package com.example.dianno.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-anno
 * @Package : com.example.dianno
 * @ClassName : .java
 * @createTime : 2023/6/18 19:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Car extends Carrier {
    public Car(final String maker, final String model) {
        super(maker, model);
    }
}
