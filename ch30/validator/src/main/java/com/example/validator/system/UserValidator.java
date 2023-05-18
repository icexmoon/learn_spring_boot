package com.example.validator.system;

import com.example.validator.dto.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.system
 * @ClassName : .java
 * @createTime : 2023/5/17 20:52
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        UserDTO user = (UserDTO) target;
        if (user.getAge() < 0 || user.getAge() > 150) {
            errors.rejectValue("age", "too.low.or.too.big");
        }
    }
}
