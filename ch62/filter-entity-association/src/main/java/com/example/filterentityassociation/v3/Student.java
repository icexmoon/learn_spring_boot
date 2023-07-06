package com.example.filterentityassociation.v3;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.WhereJoinTable;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v3
 * @ClassName : .java
 * @createTime : 2023/7/6 13:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student3")
@Table(name = "student3")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_address3",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @WhereJoinTable(clause = "type = 'LONG'")
    @JoinTable(name = "student_address3",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    @Builder.Default
    private List<Address> longAddresses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @WhereJoinTable(clause = "type = 'TEMPORARY'")
    @JoinTable(name = "student_address3",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    @Builder.Default
    private List<Address> temporaryAddresses = new ArrayList<>();
}
