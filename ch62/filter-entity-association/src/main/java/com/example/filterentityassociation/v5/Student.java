package com.example.filterentityassociation.v5;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v5
 * @ClassName : .java
 * @createTime : 2023/7/6 19:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FilterDef(name = "accountRoleFilter",
        parameters = @ParamDef(name = "role", type = String.class),
        defaultCondition = "role = :role")
@Entity(name = "Student5")
@Table(name = "student5")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String name;


    @Filter(name = "accountRoleFilter")
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @Builder.Default
    private List<Account> accounts = new ArrayList<>();

    public Student addAccount(@NonNull Account account){
        this.accounts.add(account);
        account.setStudent(this);
        return this;
    }
}
