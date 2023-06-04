package com.example.lombok.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/5/31 11:22
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Setter
@Getter
@Accessors(chain = true)
public class BookStore {
    private Long id;
    private String name;
    private String address;
    private boolean delFlag;
}
