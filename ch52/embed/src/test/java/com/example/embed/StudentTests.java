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
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void beforeEach() {
        studentRepository.deleteAll();
    }

    @Test
    @SneakyThrows
    void testAddNewStudent() {
        Student newStudent = Student.builder()
                .address("宁安大街101号")
                .name("icexmoon")
                .contactsName("lalala")
                .contactsAddress("北京大街100号")
                .contactsPhone("123456789")
                .build();
        studentRepository.save(newStudent);
        Assertions.assertNotNull(newStudent.getId());
        ObjectMapper om = new ObjectMapper();
        var json = om.writeValueAsString(newStudent);
        System.out.println(json);
    }
}
