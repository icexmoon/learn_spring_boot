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
 * @createTime : 2023/7/3 20:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@EqualsAndHashCode
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student2")
@Table(name = "student2")
public class Student {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 45)
    @NotBlank
    @NotNull
    private String name;

    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    private List<StudentCourse> studentCourses = new ArrayList<>();

    /**
     * 添加学生与课程实体的的关联关系
     *
     * @param course 课程实体实例
     * @param rate   课程评分
     * @return
     */
    public Student addCourse(Course course, int rate) {
        var studentCourse = StudentCourse.builder()
                .student(this)
                .course(course)
                .rate(rate)
                .build();
        this.studentCourses.add(studentCourse);
        course.getStudentCourses().add(studentCourse);
        return this;
    }

    /**
     * 删除与课程的关联关系
     *
     * @param course
     * @return
     */
    public Student removeCourse(Course course) {
        if (course.getId() == null || this.getId() == null) {
            return this;
        }
        StudentCourse scExample = StudentCourse.builder()
                .id(new StudentCourse.StudentCourseId(this.getId(), course.getId()))
                .build();
        if (this.studentCourses.contains(scExample)) {
            this.studentCourses.remove(scExample);
        }
        course.getStudentCourses().remove(scExample);
        return this;
    }
}
