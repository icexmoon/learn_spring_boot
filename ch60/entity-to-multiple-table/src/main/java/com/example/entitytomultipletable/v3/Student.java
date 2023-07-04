package com.example.entitytomultipletable.v3;

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
 * @Package : com.example.entitytomultipletable.v3
 * @ClassName : .java
 * @createTime : 2023/7/4 18:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student3")
@Table(name = "student3")
@SecondaryTable(name = "student_hobbies3",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id"))
@SecondaryTable(name = "student_detail3",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id"))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    @Column(unique = true)
    private String name;
    @NotNull
    @Builder.Default
    @Column(table = "student_hobbies3")
    private Boolean loveMusic = false;
    @NotNull
    @Builder.Default
    @Column(table = "student_hobbies3")
    private Boolean loveDraw = false;
    @Column(table = "student_detail3")
    private String address;
    @Column(table = "student_detail3")
    private String email;
}
