package com.example.notnull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.TransactionSystemException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : not-null
 * @Package : com.example.notnull
 * @ClassName : .java
 * @createTime : 2023/6/30 20:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {NotNullApplication.class})
@TestPropertySource("classpath:application.properties")
public class Student4Tests {
    @Autowired
    private Student4Repository student4Repository;

    @BeforeEach
    void beforeEach() {
        student4Repository.deleteAll();
    }

    @Test
    void addStudentWithValidation() {
        Student4 s = new Student4.Student4Builder()
                .build();
        Assertions.assertThrows(TransactionSystemException.class, () -> {
            student4Repository.save(s);
        });
    }
}
