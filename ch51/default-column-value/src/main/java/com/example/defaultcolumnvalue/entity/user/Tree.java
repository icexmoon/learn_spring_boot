package com.example.defaultcolumnvalue.entity.user;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : default-column-value
 * @Package : com.example.defaultcolumnvalue.entity.user
 * @ClassName : .java
 * @createTime : 2023/6/29 17:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@Table(name = "USER_TREE")
@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer age = 5;
}
