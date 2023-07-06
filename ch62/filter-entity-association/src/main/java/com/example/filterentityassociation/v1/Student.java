package com.example.filterentityassociation.v1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation
 * @ClassName : .java
 * @createTime : 2023/7/6 9:37
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
@Where(clause = "del_flag = false")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 45)
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Builder.Default
    private Boolean delFlag = false;

    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @Builder.Default
    private List<Account> accounts = new ArrayList<>();

    public Student addAccount(Account account){
        this.accounts.add(account);
        account.setStudent(this);
        return this;
    }
}
