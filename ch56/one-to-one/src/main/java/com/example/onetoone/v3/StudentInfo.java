package com.example.onetoone.v3;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v2
 * @ClassName : .java
 * @createTime : 2023/7/2 12:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "StudentInfo3")
@Table(name = "user_student_info3")
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Boolean loveMusic;
    @NotNull
    private Boolean loveDraw;
    @NotNull
    @Column(name = "description")
    private String desc;
    @Setter
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
