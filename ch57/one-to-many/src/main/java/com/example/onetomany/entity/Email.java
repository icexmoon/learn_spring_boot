package com.example.onetomany.entity;

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
 * @Project : one-to-many
 * @Package : com.example.onetomany
 * @ClassName : .java
 * @createTime : 2023/7/3 10:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"student"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "user_email")
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
    @Setter(AccessLevel.PROTECTED)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    public String toEmailAddress() {
        return "%s@%s".formatted(this.getAccount(), this.getDomain());
    }
}
