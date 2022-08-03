package cn.icexmoon.demo.books.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    private Integer UserId;
    private Integer RoleId;
}
