package com.example.entitytomultipletable.v1;

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
 * @Package : com.example.entitytomultipletable
 * @ClassName : .java
 * @createTime : 2023/7/4 17:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
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
    private Boolean loveMusic = false;
    @NotNull
    @Builder.Default
    private Boolean loveDraw = false;
    private String address;
    private String email;
}
