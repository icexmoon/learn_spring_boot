package com.example.keyuniqindex.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 10:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 班级实体
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_class")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * 班级名称，如一年级二班
     */
    @NotNull
    @Length(min = 5, max = 25)
    @Column(unique = true)
    private String name;
}
