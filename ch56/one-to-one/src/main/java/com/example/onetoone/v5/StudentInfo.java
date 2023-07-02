package com.example.onetoone.v5;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v5
 * @ClassName : .java
 * @createTime : 2023/7/2 16:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"student"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "StudentInfo5")
@Table(name = "user_student_info5")
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean loveMusic;
    @NotNull
    private Boolean loveDraw;
    @NotNull
    @Length(max = 255)
    @Column(name = "description")
    private String desc;
    @Setter(AccessLevel.PACKAGE)
    @NotNull
    @OneToOne(mappedBy = "studentInfo")
    private Student student;
}
