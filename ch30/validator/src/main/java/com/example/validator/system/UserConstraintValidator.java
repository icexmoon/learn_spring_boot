package com.example.validator.system;

import com.example.validator.dto.UserDTO;
import com.example.validator.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.system
 * @ClassName : .java
 * @createTime : 2023/5/17 19:41
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class UserConstraintValidator implements ConstraintValidator<UserConstraint, UserDTO> {
    private UserConstraint.Pattern pattern;
    @Autowired
    private UserService userService;

    @Override
    public void initialize(UserConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        pattern = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (pattern == UserConstraint.Pattern.CHECK_ALL) {
            if (userDTO.getAge() == null || userDTO.getAge() <= 0) {
                return false;
            }
            if (userDTO.getName() == null || userDTO.getName().isEmpty()) {
                return false;
            }
            if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
                return false;
            }
            if (userDTO.getPhone() == null || userDTO.getPhone().isEmpty()) {
                return false;
            }
        }
        if (pattern == UserConstraint.Pattern.ONLY_NAME) {
            if (userDTO.getName() == null || userDTO.getName().isEmpty()) {
                return false;
            }
        } else {
            ;
        }
        return true;
    }
}
