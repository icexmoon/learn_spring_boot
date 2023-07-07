package com.example.ineritancemapping.v1;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
 * @createTime : 2023/7/7 9:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "student")
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
