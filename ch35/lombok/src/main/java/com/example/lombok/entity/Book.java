package com.example.lombok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok
 * @ClassName : .java
 * @createTime : 2023/5/30 15:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@NoArgsConstructor
@Setter
@Getter
public class Book {

    private Long id;
    private String name;
    @NonNull
    private Long userId;
    private Long publisherId;

    public Book(@NonNull String name, Long userId, Long publisherId) {
        this.name = name;
        this.userId = userId;
        this.publisherId = publisherId;
    }
}
