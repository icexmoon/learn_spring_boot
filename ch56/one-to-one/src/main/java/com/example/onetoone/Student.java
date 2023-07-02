package com.example.onetoone;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone
 * @ClassName : .java
 * @createTime : 2023/7/2 9:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(max = 45)
    private String name;
    @NotNull
    private LocalDate birthDay;
    @OneToOne
    @JoinColumn(name = "student_info_id", referencedColumnName = "id")
    private StudentInfo studentInfo;
}
