package com.example.jpa;

import com.example.jpa.models.user.Student;
import com.example.jpa.repositories.user.StudentRepository;
import com.example.jpa.services.user.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa
 * @Package : com.example.jpa
 * @ClassName : .java
 * @createTime : 2023/6/25 12:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitWebConfig(classes = {JpaApplication.class})
@TestPropertySource("classpath:application.properties")
@Transactional
public class StudentServiceV2Tests {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    private final List<Student> students = List.of(
            new Student("icexmoon", LocalDate.of(1989, 10, 1), Gender.MALE),
            new Student("JackChen", LocalDate.of(1990, 5, 1), Gender.MALE),
            new Student("HanMeimei", LocalDate.of(1991, 6, 1), Gender.FEMALE));

    @BeforeEach
    void beforeEach() {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void testList() {
        List<Student> students = studentService.list();
        Assertions.assertEquals(this.students, students);
    }
}
