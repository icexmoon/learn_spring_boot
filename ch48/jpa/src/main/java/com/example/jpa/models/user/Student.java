package com.example.jpa.models.user;

import com.example.jpa.Gender;
import jakarta.persistence.*;
import lombok.*;
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
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "USER_STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false, unique = false)
    private String name;

    @Setter(AccessLevel.NONE)
    @Column(name = "BIRTH_DAY", nullable = false)
    private LocalDate birthDay;

    @Transient
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @Nullable
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    public Student() {
    }

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
