package com.example.embed;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
@SpringJUnitConfig(classes = {EmbedApplication.class})
@TestPropertySource("classpath:application.properties")
public class Student2Tests {
    @Autowired
    private Student2Repository student2Repository;

    @BeforeEach
    void beforeEach() {
        student2Repository.deleteAll();
    }

    @Test
    @SneakyThrows
    void testAddNewStudent() {
        Student2 newStudent = Student2.builder()
                .address("宁安大街101号")
                .name("icexmoon")
                .contacts(Contacts.builder()
                        .name("lalala")
                        .address("北京东路100号")
                        .phone("123456789")
                        .build())
                .build();
        student2Repository.save(newStudent);
        Assertions.assertNotNull(newStudent.getId());
        ObjectMapper om = new ObjectMapper();
        var json = om.writeValueAsString(newStudent);
        System.out.println(json);
    }
}
