package com.example.keyuniqindex.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
 * @createTime : 2023/7/1 13:18
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_teacher_class")
public class TeacherClass {
    @EmbeddedId
    private TeacherClassId teacherClassId;
    /**
     * 是否为班主任
     */
    @NotNull
    private Boolean classLeader = false;
}
