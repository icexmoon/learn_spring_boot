package com.example.validator.service.impl;

import com.example.validator.dto.UserDTO;
import com.example.validator.service.UserService;
import com.example.validator.system.UserValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.service
 * @ClassName : .java
 * @createTime : 2023/5/17 18:10
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Validator validator;
    @Autowired
    private org.springframework.validation.Validator springValidator;

    public void addUser(UserDTO userDTO) {
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        if (!violations.isEmpty()) {
            //没有通过验证
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserDTO> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("没有通过验证：" + sb.toString(), violations);
        }
        //通过验证
        //这里可以添加向持久层添加用户的操作
    }

    @Override
    public void addUserWithSpringValidator(UserDTO userDTO) {
        DataBinder dataBinder = new DataBinder(userDTO);
        dataBinder.addValidators(springValidator, new UserValidator());
        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (!allErrors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : allErrors) {
                String objectName = error.getObjectName();
                if (error instanceof FieldError){
                    FieldError fieldError = (FieldError)error;
                    objectName = fieldError.getField();
                }
                String errorMsg = error.getDefaultMessage();
                if (ObjectUtils.isEmpty(errorMsg)) {
                    errorMsg = error.getCode();
                }
                sb.append(objectName).append(" ").append(errorMsg);
                sb.append(",");
            }
            throw new ValidationException(sb.toString());
        }
        //通过验证
        //这里可以添加向持久层添加用户的操作
    }
}
