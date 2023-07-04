package com.example.manytomany.v2;

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
 * @Package : com.example.manytomany.v2
 * @ClassName : .java
 * @createTime : 2023/7/3 20:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@EqualsAndHashCode
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Course2")
@Table(name = "course2")
public class Course {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 45)
    @NotBlank
    @NotNull
    private String name;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    private List<StudentCourse> studentCourses = new ArrayList<>();

    /**
     * 添加课程与学生实体的关联关系
     *
     * @param student 学生实体实例
     * @return
     */
    public Course addStudent(Student student, int rate) {
        var sc = StudentCourse.builder()
                .rate(rate)
                .student(student)
                .course(this)
                .build();
        this.studentCourses.add(sc);
        student.getStudentCourses().add(sc);
        return this;
    }
}
