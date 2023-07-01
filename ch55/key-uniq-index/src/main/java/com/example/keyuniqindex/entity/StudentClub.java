package com.example.keyuniqindex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex.entity
 * @ClassName : .java
 * @createTime : 2023/7/1 14:55
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 学生-社团对应关系（多对多）
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_student_club", uniqueConstraints = {
        @UniqueConstraint(name = "student_club_idx", columnNames = {"studentNumber", "clubId"})
})
public class StudentClub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentNumber;
    private Long clubId;
}
