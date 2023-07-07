package com.example.identitifier.v8;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
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
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student8")
public class Student {
    @Id
    @GeneratedValue(generator = "student8-id-generator")
    @GenericGenerator(name = "student8-id-generator",
            parameters = @Parameter(name = "prefix", value = "student8-id"),
            type = MyGenerator.class)
    private String id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;
}
