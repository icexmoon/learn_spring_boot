package com.example.entitytomultipletable.v2;

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
 * @Package : com.example.entitytomultipletable.v2
 * @ClassName : .java
 * @createTime : 2023/7/4 17:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student2")
@Table(name = "student2")
@SecondaryTable(name = "student_hobbies2",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id"))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 45)
    private String name;
    @NotNull
    @Builder.Default
    @Column(table = "student_hobbies2")
    private Boolean loveMusic = false;
    @NotNull
    @Builder.Default
    @Column(table = "student_hobbies2")
    private Boolean loveDraw = false;
    private String address;
    private String email;
}
