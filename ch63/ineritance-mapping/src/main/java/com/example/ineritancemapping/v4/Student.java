package com.example.ineritancemapping.v4;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Entity(name = "Student4")
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person {
    @Min(0)
    @Max(100)
    @NotNull
    private Integer averageScore;

    public Student(String name, Integer averageScore) {
        super(name);
        this.averageScore = averageScore;
    }
}
