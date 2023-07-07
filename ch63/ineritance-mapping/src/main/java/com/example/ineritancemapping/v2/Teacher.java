package com.example.ineritancemapping.v2;

import jakarta.persistence.Entity;
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
@Entity(name = "Teacher2")
public class Teacher extends Person{
    public enum Course {
        DRAW, MATH, PHYSICS, CHEMISTRY, MUSIC
    }

    private Course course;

    public Teacher(String name, Course course) {
        super(name);
        this.course = course;
    }
}
