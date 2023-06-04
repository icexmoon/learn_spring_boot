package com.example.lombok.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok
 * @ClassName : .java
 * @createTime : 2023/5/31 11:03
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Setter
@Accessors(fluent = true, chain = true)
@ToString
@EqualsAndHashCode
public class Publisher {
    @ToString.Include(name = "编号")
    private Long id;
    @ToString.Include(name = "出版社名称", rank = 100)
    @EqualsAndHashCode.Exclude
    private String name;
    @ToString.Include(name = "创建时间", rank = 99)
    @EqualsAndHashCode.Exclude
    private LocalDate createDate;
}
