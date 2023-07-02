package com.example.onetoone.v2;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v2
 * @ClassName : .java
 * @createTime : 2023/7/2 12:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Student2")
@Table(name = "user_student2")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(max = 45)
    private String name;
    @NotNull
    private LocalDate birthDay;
}
