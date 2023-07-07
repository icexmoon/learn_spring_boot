package com.example.ineritancemapping.v3;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v2
 * @ClassName : .java
 * @createTime : 2023/7/7 10:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("null")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Person3")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "person3")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
