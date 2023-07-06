package com.example.filterentityassociation.v4;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v4
 * @ClassName : .java
 * @createTime : 2023/7/6 18:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student4")
@Table(name = "student4")
@FilterDef(
        name = "scoreFilter",
        parameters = @ParamDef(name = "minScore", type = Integer.class)
)
@Filter(
        name = "scoreFilter",
        condition = "average_score > :minScore"
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String name;

    @NotNull
    private Integer averageScore;
}
