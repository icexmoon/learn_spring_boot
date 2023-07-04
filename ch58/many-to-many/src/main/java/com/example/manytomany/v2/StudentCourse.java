package com.example.manytomany.v2;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany.v2
 * @ClassName : .java
 * @createTime : 2023/7/3 20:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "StudentCourse2")
@Table(name = "student_course2")
public class StudentCourse {
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class StudentCourseId implements Serializable {
        private Long studentId;
        private Long courseId;
    }

    @EmbeddedId
    @Builder.Default
    @EqualsAndHashCode.Include
    private StudentCourseId id = new StudentCourseId();

    @NotNull
    @Min(0)
    @Max(100)
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;
}
