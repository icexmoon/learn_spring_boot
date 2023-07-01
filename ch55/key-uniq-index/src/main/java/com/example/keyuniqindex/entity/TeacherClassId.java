package com.example.keyuniqindex.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex.entity
 * @ClassName : .java
 * @createTime : 2023/7/1 13:19
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TeacherClassId implements Serializable {
    private long teacherId;
    private long classRoomId;
}
