package com.example.notnull;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : embed
 * @Package : com.example.embed
 * @ClassName : .java
 * @createTime : 2023/6/30 9:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {NotNullApplication.class})
@TestPropertySource("classpath:application.properties")
public class Student3Tests {
    @Autowired
    private Student3Repository student3Repository;

    @BeforeEach
    void beforeEach() {
        student3Repository.deleteAll();
    }

    @Test
    @SneakyThrows
    void testAddNewStudentWithNull() {
        Student3 newStudent = Student3.builder()
                .address("宁安大街101号")
                .contacts(Contacts.builder()
                        .name("lalala")
                        .address("北京东路100号")
                        .phone("123456789")
                        .build())
                .build();
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            student3Repository.save(newStudent);
        });
    }
}
