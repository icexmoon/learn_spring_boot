package com.example.validator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.controller
 * @ClassName : .java
 * @createTime : 2023/5/17 18:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class UserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;
    @Min(1)
    private Integer age;
}
