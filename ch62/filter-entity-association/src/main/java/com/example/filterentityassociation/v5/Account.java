package com.example.filterentityassociation.v5;

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
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v5
 * @ClassName : .java
 * @createTime : 2023/7/6 19:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"student"})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Account5")
@Table(name = "account5")
public class Account {
    public enum Role{
        ADMIN, MEMBER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Length(max = 45)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Setter
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
