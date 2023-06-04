package com.example.lombok.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/5/31 17:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data(staticConstructor = "of")
public class Student<T> {
    private final Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private T something;
}
