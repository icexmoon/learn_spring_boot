package com.example.cascade.v1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cascade
 * @Package : com.example.cascade
 * @ClassName : .java
 * @createTime : 2023/7/5 10:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "student",
            cascade = {CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REMOVE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @Builder.Default
    private List<Email> emails = new ArrayList<>();

    public Student addEmail(Email email) {
        if (this.emails.contains(email)) {
            return this;
        }
        this.emails.add(email);
        email.setStudent(this);
        return this;
    }
}
