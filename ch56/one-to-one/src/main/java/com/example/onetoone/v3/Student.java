package com.example.onetoone.v3;

import jakarta.persistence.*;
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
 * @Package : com.example.onetoone.v2
 * @ClassName : .java
 * @createTime : 2023/7/2 12:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Student3")
@Table(name = "user_student3")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(max = 45)
    private String name;
    @NotNull
    private LocalDate birthDay;
    @Setter
    @OneToOne(mappedBy = "student",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private StudentInfo studentInfo;

    /**
     * 添加学生信息的关联关系（会处理双向关联）
     * @param studentInfo
     * @return
     */
    public Student addStudentInfoAssociation(StudentInfo studentInfo){
        this.setStudentInfo(studentInfo);
        studentInfo.setStudent(this);
        return this;
    }
}
