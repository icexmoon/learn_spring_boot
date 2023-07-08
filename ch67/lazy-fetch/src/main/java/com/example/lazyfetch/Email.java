package com.example.lazyfetch;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lazy-fetch
 * @Package : com.example.lazyfetch
 * @ClassName : .java
 * @createTime : 2023/7/8 15:19
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"student"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"account", "domain"}))
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String account;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String domain;

    @Setter
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
