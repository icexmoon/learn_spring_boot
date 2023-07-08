package com.example.query;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : query
 * @Package : com.example.query
 * @ClassName : .java
 * @createTime : 2023/7/8 10:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Student.findByName",
        query = "select s from Student s where s.name=:name")
@NamedQuery(name = "Student.findAll",
        query = "select s from Student s")
@NamedQuery(name = "Student.findByBirthDay",
        query = "select s from Student s where s.birthDay>:birthDay")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;

    @NotNull
    private LocalDate birthDay;

    @NotNull
    @NotBlank
    @Length(max = 255)
    private String address;
}
