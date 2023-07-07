package com.example.ineritancemapping.v5;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Entity(name = "Teacher5")
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
