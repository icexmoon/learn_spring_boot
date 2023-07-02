package com.example.onetoone.v4;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

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
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student4")
@Table(name = "user_student4")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String name;
    @NotNull
    private LocalDate birthDay;
    @OneToOne(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @PrimaryKeyJoinColumn
    @Setter(AccessLevel.PRIVATE)
    private StudentInfo studentInfo;

    public Student addStudentInfoAssociation(StudentInfo studentInfo) {
        this.setStudentInfo(studentInfo);
        studentInfo.setStudent(this);
        return this;
    }
}
