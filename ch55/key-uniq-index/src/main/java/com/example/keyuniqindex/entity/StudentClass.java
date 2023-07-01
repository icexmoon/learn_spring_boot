package com.example.keyuniqindex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 10:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 学生和班级的关系实体，班级-学生 1对多的关系
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_student_class")
@IdClass(StudentClassId.class)
public class StudentClass {
    /**
     * 班级 id
     */
    @Id
    private Long classRoomId;
    /**
     * 学号
     */
    @Id
    private String studentNumber;

    /**
     * 座位号
     */
    @Nullable
    private int seatNumber;
}
