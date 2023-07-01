package com.example.keyuniqindex.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 10:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StudentClassId implements Serializable {
    private Long classRoomId;
    private String studentNumber;
}
