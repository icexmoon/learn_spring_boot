package com.example.notnull;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : embed
 * @Package : com.example.embed
 * @ClassName : .java
 * @createTime : 2023/6/30 9:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user_student4")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student4 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column(length = 25)
    private String name;

    @NotNull
    @Column(length = 50)
    private String address;

    @Convert(converter = ContactsConverter.class)
    @Column(columnDefinition = "text")
    private Contacts contacts;

    public Student4() {

    }
}
