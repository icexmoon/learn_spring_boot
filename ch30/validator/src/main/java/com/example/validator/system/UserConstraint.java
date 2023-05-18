package com.example.validator.system;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.system
 * @ClassName : .java
 * @createTime : 2023/5/17 19:42
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserConstraintValidator.class)
public @interface UserConstraint {
    //这里可以根据需要添加一些属性用于丰富验证手段
    Pattern value() default Pattern.CHECK_ALL;
    String message() default "用户信息有错，无法通过验证";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    enum Pattern {
        CHECK_ALL, ONLY_NAME
    }
}
