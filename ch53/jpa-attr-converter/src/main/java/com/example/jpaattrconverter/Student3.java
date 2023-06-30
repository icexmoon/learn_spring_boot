package com.example.jpaattrconverter;

import jakarta.persistence.*;
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
@Table(name = "user_student3")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String address;

    @Convert(converter = ContactsConverter.class)
    @Column(columnDefinition = "text")
    private Contacts contacts;

    public Student3() {

    }
}
