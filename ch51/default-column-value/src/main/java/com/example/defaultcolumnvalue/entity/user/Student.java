package com.example.defaultcolumnvalue.entity.user;

import com.example.defaultcolumnvalue.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    public static final String DEFAULT_NAME = "icexmoon";
    @Column(name = "NAME", columnDefinition = "varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'icexmoon'")
    private String name = DEFAULT_NAME;

    public static final LocalDate DEFAULT_BIRTH_DAY = LocalDate.of(2022, 1, 1);
    @Setter(AccessLevel.NONE)
    @Column(name = "BIRTH_DAY", columnDefinition = "date DEFAULT '2002-01-01'")
    private LocalDate birthDay = DEFAULT_BIRTH_DAY;

    @Transient
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @Nullable
    private Integer age;

    public static final Gender DEFAULT_GENDER = Gender.MALE;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender", columnDefinition = "tinyint DEFAULT '0'")
    private Gender gender = DEFAULT_GENDER;

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
