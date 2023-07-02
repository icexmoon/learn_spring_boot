package com.example.onetoone.v5;

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
 * @Package : com.example.onetoone.v5
 * @ClassName : .java
 * @createTime : 2023/7/2 16:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student5")
@Table(name = "user_student5")
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

    @Setter(AccessLevel.PRIVATE)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "user_student_info_relationship",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "student_info_id", referencedColumnName = "id")
            }
    )
    private StudentInfo studentInfo;

    public Student addStudentInfoAssociation(StudentInfo studentInfo){
        this.setStudentInfo(studentInfo);
        studentInfo.setStudent(this);
        return this;
    }
}
