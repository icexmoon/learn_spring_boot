package com.example.filterentityassociation.v2;

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
 * @Package : com.example.filterentityassociation.v2
 * @ClassName : .java
 * @createTime : 2023/7/6 11:41
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
@Entity(name = "Student2")
@Table(name = "student2")
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

    @Where(clause = "role = 'ADMIN'")
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @Builder.Default
    private List<Account> adminAccounts = new ArrayList<>();

    @Where(clause = "role = 'MEMBER'")
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @Builder.Default
    private List<Account> memberAccounts = new ArrayList<>();


    public Student addAccount(@NonNull Account account){
        switch (account.getRole()){
            case ADMIN -> this.adminAccounts.add(account);
            case MEMBER -> this.memberAccounts.add(account);
        }
        account.setStudent(this);
        return this;
    }
}
