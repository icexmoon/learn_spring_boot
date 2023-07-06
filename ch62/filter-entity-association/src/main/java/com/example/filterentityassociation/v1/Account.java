package com.example.filterentityassociation.v1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation
 * @ClassName : .java
 * @createTime : 2023/7/6 9:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"student"})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
@Where(clause = "del_flag = false")
public class Account {
    public enum Role {
        ADMIN, MEMBER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String name;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 45)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Builder.Default
    private Boolean delFlag = false;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
