package com.example.entitytomultipletable.v4;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-to-multiple-table
 * @Package : com.example.entitytomultipletable.v4
 * @ClassName : .java
 * @createTime : 2023/7/4 18:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student4")
@Table(name = "student4")
@SecondaryTable(name = "student_hobbies4",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id"))
@SecondaryTable(name = "student_detail4",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id"))
public class Student {
    @ToString
    @Embeddable
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Hobbies {
        @NotNull
        @Builder.Default
        @Column(table = "student_hobbies4")
        private Boolean loveMusic = false;
        @NotNull
        @Builder.Default
        @Column(table = "student_hobbies4")
        private Boolean loveDraw = false;
    }

    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Details {
        @Column(table = "student_detail4")
        private String address;
        @Column(table = "student_detail4")
        private String email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;
    @NotNull
    @Embedded
    @Builder.Default
    private Hobbies hobbies = new Hobbies();
    @NotNull
    @Embedded
    @Builder.Default
    private Details details = new Details();
}
