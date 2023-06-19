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
 * @createTime : 2023/6/18 19:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@EqualsAndHashCode
public abstract class Carrier {
    protected final String maker;
    protected final String model;

    protected Carrier(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }
}
