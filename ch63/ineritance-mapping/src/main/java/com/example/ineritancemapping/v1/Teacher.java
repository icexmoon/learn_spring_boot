package com.example.ineritancemapping.v1;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping
 * @ClassName : .java
 * @createTime : 2023/7/7 9:08
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher extends Person {
    public enum Course {
        MATH, PHYSICS, CHEMISTRY, MUSIC, DRAW
    }

    public Teacher(String name, Course course) {
        super(name);
        this.course = course;
    }

    @Enumerated(EnumType.STRING)
    private Course course;
}
