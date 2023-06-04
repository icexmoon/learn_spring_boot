package com.example.lombok.entity;

import lombok.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/5/31 17:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(includeFieldNames = false)
public class Employee {
    @EqualsAndHashCode.Include
    private final Long id;
    @NonNull
    private String name;
    @NonNull
    @ToString.Exclude
    private Boolean delFlag;
}
