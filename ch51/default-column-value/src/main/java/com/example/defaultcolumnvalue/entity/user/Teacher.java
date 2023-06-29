package com.example.defaultcolumnvalue.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : default-column-value
 * @Package : com.example.defaultcolumnvalue
 * @ClassName : .java
 * @createTime : 2023/6/29 17:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@DynamicInsert
@Data
@Table(name = "USER_TEACHER")
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'icexmoon'")
    private String name;
}
