package com.example.manytomany.v1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany
 * @ClassName : .java
 * @createTime : 2023/7/3 15:22
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"students"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    @Length(max = 45)
    private String name;

    @Getter(AccessLevel.PROTECTED)
    @ManyToMany(mappedBy = "courses")
    @Builder.Default
    private List<Student> students = new ArrayList<>();
}
