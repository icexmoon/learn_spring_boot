package com.example.filterentityassociation.v3;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v3
 * @ClassName : .java
 * @createTime : 2023/7/6 13:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "StudentAddress3")
@Table(name = "student_address3")
public class StudentAddress {
    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StudentAdressId implements Serializable {
        @Column(name = "student_id")
        private Long studentId;
        @Column(name = "address_id")
        private Long addressId;
    }

    public enum Type {
        TEMPORARY, LONG
    }

    @EmbeddedId
    private StudentAdressId id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
}
