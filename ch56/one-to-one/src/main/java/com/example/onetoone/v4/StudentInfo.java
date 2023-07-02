package com.example.onetoone.v4;

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
 * @Package : com.example.onetoone.v4
 * @ClassName : .java
 * @createTime : 2023/7/2 15:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"student"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "StudentInfo4")
@Table(name = "user_student_info4")
public class StudentInfo {
    @Id
    @Column(name = "student_id")
    private Long id;
    @NotNull
    private Boolean loveMusic;
    @NotNull
    private Boolean loveDraw;
    @NotNull
    @Length(max = 255)
    @Column(name = "description")
    private String desc;
    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    @Setter(AccessLevel.PROTECTED)
    private Student student;
}
