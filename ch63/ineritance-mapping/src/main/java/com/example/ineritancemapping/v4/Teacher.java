package com.example.ineritancemapping.v4;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v2
 * @ClassName : .java
 * @createTime : 2023/7/7 10:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(callSuper = true)
@NoArgsConstructor
@Entity(name = "Teacher4")
@PrimaryKeyJoinColumn(name = "person_id")
public class Teacher extends Person {
    public enum Course {
        DRAW, MATH, PHYSICS, CHEMISTRY, MUSIC
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    private Course course;

    public Teacher(String name, Course course) {
        super(name);
        this.course = course;
    }
}
