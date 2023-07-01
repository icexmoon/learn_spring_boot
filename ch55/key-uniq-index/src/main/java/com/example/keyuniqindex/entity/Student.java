package com.example.keyuniqindex.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import java.time.LocalDate;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa
 * @Package : com.example.jpa
 * @ClassName : .java
 * @createTime : 2023/6/25 10:41
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER_STUDENT")
public class Student {
    @Id
    @EqualsAndHashCode.Exclude
    @Length(min = 10, max = 10)
    @NotNull
    private String number;

    @NotNull
    @Length(min = 5, max = 50)
    private String name;

    @NotNull
    @Setter(AccessLevel.NONE)
    private LocalDate birthDay;

    @Transient
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @Nullable
    private Integer age;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    public Student(String name, LocalDate birthDay, Gender gender) {
        this.name = name;
        this.setBirthDay(birthDay);
        this.gender = gender;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        this.age = getAgeByBirthDay(birthDay);
    }

    private static int getAgeByBirthDay(LocalDate birthDay) {
        int age = LocalDate.now().getYear() - birthDay.getYear();
        if (age < 0) {
            throw new IllegalArgumentException("出生年月日错误");
        }
        return age;
    }

    public Integer getAge() {
        if (age == null) {
            age = getAgeByBirthDay(this.birthDay);
        }
        return age;
    }
}
