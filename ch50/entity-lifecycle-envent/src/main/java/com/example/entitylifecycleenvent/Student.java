package com.example.entitylifecycleenvent;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle-envent
 * @Package : com.example.entitylifecycleenvent
 * @ClassName : .java
 * @createTime : 2023/6/28 18:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Setter
@Entity(name = "user_student")
@ToString
@EqualsAndHashCode
@Table(name = "user_student")
@Log4j2
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private Long id;

    @Nullable
    @Column(name = "NAME", length = 50, nullable = false, unique = false)
    private String name;

    @Nullable
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
    @Nullable
    private Gender gender;

    public Student() {
    }

    public Student(@Nullable String name, @Nullable LocalDate birthDay, @Nullable Gender gender) {
        this.name = name;
        if (birthDay != null) {
            this.setBirthDay(birthDay);
        }
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

    @PrePersist
    public void prePersist() {
        log.info("New student %s will be add.".formatted(this));
    }

    @PostPersist
    public void postPersist() {
        log.info("New student %s is already added.".formatted(this));
    }

    @PreRemove
    public void preRemove() {
        log.info("Student %s will be removed.".formatted(this));
    }

    @PostRemove
    public void postRemove() {
        log.info("Student %s is already removed.".formatted(this));
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Student %s is will be updated.".formatted(this));
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Student %s is already updated.".formatted(this));
    }

    @PostLoad
    public void postLoad() {
        log.info("Student %s is loaded.".formatted(this));
    }
}
