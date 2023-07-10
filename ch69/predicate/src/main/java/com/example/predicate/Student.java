package com.example.predicate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
 * @Project : predicate
 * @Package : com.example.predicate
 * @ClassName : .java
 * @createTime : 2023/7/10 13:03
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    public enum Level {
        FRESH_MAN, SOPHOMORE, JUNIOR, SENIOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Length(max = 45)
    @Column(unique = true)
    private String name;

    @Min(0)
    @Max(100)
    @NotNull
    private Integer averageScore;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Level level;
}
