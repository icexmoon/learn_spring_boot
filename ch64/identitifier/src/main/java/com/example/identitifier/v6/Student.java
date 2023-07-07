package com.example.identitifier.v6;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : identitifier
 * @Package : com.example.identitifier
 * @ClassName : .java
 * @createTime : 2023/7/7 15:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student6")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "student6-id-generator")
    @TableGenerator(name = "student6-id-generator",
            table = "hibernate_sequences",
            pkColumnName = "sequence_name",
            pkColumnValue = "student6-id",
            valueColumnName = "next_val",
            allocationSize = 1
    )
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;
}
