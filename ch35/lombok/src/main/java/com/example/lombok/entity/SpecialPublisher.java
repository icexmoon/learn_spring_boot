package com.example.lombok.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/5/31 15:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Setter
@Getter
@Accessors(chain = true, fluent = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SpecialPublisher extends Publisher {
    @EqualsAndHashCode.Exclude
    private String admin;

    @ToString.Include
    private String hello() {
        return "欢迎来到" + this.name() + "出版社";
    }
}
