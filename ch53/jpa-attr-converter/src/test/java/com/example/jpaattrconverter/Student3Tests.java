package com.example.jpaattrconverter;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

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
@SpringJUnitConfig(classes = {JpaAttrConverterApplication.class})
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
    void testAddNewStudent() {
        Student3 newStudent = Student3.builder()
                .address("宁安大街101号")
                .name("icexmoon")
                .contacts(Contacts.builder()
                        .name("lalala")
                        .address("北京东路100号")
                        .phone("123456789")
                        .build())
                .build();
        student3Repository.save(newStudent);
        Assertions.assertNotNull(newStudent.getId());
        var findStudents = student3Repository.findAllById(List.of(newStudent.getId()));
        var findStudent = findStudents.stream().filter(s -> s.getId().equals(newStudent.getId())).findFirst().get();
        Assertions.assertEquals(newStudent.getContacts(), findStudent.getContacts());
    }

    @Test
    void testAddWithNullContacts() {
        Student3 newStudent = Student3.builder()
                .address("宁安大街101号")
                .name("icexmoon")
                .contacts(null)
                .build();
        student3Repository.save(newStudent);
        var findStudents = student3Repository.findAllById(List.of(newStudent.getId()));
        var findStudent = findStudents.stream().filter(s -> s.getId().equals(newStudent.getId())).findFirst().get();
        Assertions.assertNull(findStudent.getContacts());
    }
}
