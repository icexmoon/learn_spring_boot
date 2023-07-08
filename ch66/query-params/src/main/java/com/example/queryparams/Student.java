package com.example.queryparams;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : query-params
 * @Package : com.example.queryparams
 * @ClassName : .java
 * @createTime : 2023/7/8 12:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    private static final int MAX_SCORE = 100;
    private static final int MIN_SCORE = 0;

    public enum Type {
        MIDDLE_SCHOOL_STUDENT,
        HIGH_SCHOOL_STUDENT,
        COLLEGE_STUDENT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 45)
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private Type type;

    @NotNull
    @Min(MIN_SCORE)
    @Max(MAX_SCORE)
    private Integer mathScore;

    @NotNull
    @Min(MIN_SCORE)
    @Max(MAX_SCORE)
    private Integer englishScore;

    @NotNull
    @Min(MIN_SCORE)
    @Max(MAX_SCORE)
    private Integer chineseScore;
}
