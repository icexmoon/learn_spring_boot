package com.example.filterentityassociation.v3;

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
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v3
 * @ClassName : .java
 * @createTime : 2023/7/6 13:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString(exclude = {"students"})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Adress3")
@Table(name = "address3")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 100)
    private String name;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Student> students = new ArrayList<>();
}
