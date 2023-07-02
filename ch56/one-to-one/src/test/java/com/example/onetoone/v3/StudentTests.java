package com.example.onetoone.v3;

import com.example.onetoone.OneToOneApplication;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
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
 * @Package : com.example.onetoone.v3
 * @ClassName : .java
 * @createTime : 2023/7/2 13:35
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
    private StudentRepository3 studentRepository;
    @Autowired
    private StudentInfoRepository3 studentInfoRepository;

    @BeforeEach
    void beforeEach() {
        studentRepository.deleteAll();
    }

    @Test
    void testAddWithAssociation(@Autowired List<Student> students) {
        Assertions.assertEquals(0, studentInfoRepository.count());
        Assertions.assertEquals(0, studentRepository.count());
        studentRepository.saveAll(students);
        Assertions.assertEquals(students.size(), studentRepository.count());
        Assertions.assertNotEquals(0, studentInfoRepository.count());
    }

    @Test
    void testAddOneError() {
        var s = Student.builder()
                .name("icexmoon")
                .birthDay(LocalDate.of(1998, 10, 1))
                .studentInfo(StudentInfo.builder()
                        .loveMusic(true)
                        .loveDraw(false)
                        .desc("")
                        .build())
                .build();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            studentRepository.save(s);
        });
    }

    @Test
    void testAddOneCorrect() {
        StudentInfo studentInfo = StudentInfo.builder()
                .loveMusic(true)
                .loveDraw(false)
                .desc("")
                .build();
        var s = Student.builder()
                .name("icexmoon")
                .birthDay(LocalDate.of(1998, 10, 1))
                .studentInfo(studentInfo)
                .build();
        s.setStudentInfo(studentInfo);
        studentInfo.setStudent(s);
        studentRepository.save(s);
    }

    @Test
    void testAddOneCorrectWithConvenientMethod() {
        StudentInfo studentInfo = StudentInfo.builder()
                .loveMusic(true)
                .loveDraw(false)
                .desc("")
                .build();
        var s = Student.builder()
                .name("icexmoon")
                .birthDay(LocalDate.of(1998, 10, 1))
                .studentInfo(studentInfo)
                .build();
        s.addStudentInfoAssociation(studentInfo);
        studentRepository.save(s);
    }
}
