package com.example.embed;

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
@Table(name = "user_student2")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "contacts_name", length = 25)),
            @AttributeOverride(name = "address", column = @Column(name = "contacts_address", length = 50)),
            @AttributeOverride(name = "phone", column = @Column(name = "contacts_phone", length = 15))
    })
    private Contacts contacts;

    public Student2() {

    }
}
