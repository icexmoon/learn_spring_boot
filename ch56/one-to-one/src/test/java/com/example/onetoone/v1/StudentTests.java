package com.example.onetoone.v1;

import com.example.onetoone.OneToOneApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone
 * @ClassName : .java
 * @createTime : 2023/7/2 10:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {OneToOneApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students,
                    @Autowired List<StudentInfo> studentInfos) {
        studentRepository.deleteAll();
        studentInfoRepository.deleteAll();
        studentInfoRepository.saveAll(studentInfos);
        studentRepository.saveAll(students);
    }

    @Test
    void testAddStudent(@Qualifier("studentInfo2") @Autowired StudentInfo studentInfo) {
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            studentRepository.save(Student.builder()
                    .name("test")
                    .birthDay(LocalDate.of(1999, 1, 1))
                    .studentInfo(studentInfo)
                    .build());
        });
        var students = studentRepository.findAll();
        students.forEach(s->{
            System.out.println(s.getStudentInfo());
        });
    }
}
