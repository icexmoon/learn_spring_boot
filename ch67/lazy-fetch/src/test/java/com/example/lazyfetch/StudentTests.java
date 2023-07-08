package com.example.lazyfetch;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lazy-fetch
 * @Package : com.example.lazyfetch
 * @ClassName : .java
 * @createTime : 2023/7/8 15:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringBootTest
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void test() {
        var student = studentService.findStudentByName("icexmoon");
        Assertions.assertEquals("icexmoon", student.getName());
        Assertions.assertThrows(LazyInitializationException.class, () -> {
            student.getEmails().size();
        });
    }

    @Test
    void test2(){
        var student = studentService.findStudentByName2("icexmoon");
        Assertions.assertEquals("icexmoon", student.getName());
        Assertions.assertEquals(2, student.getEmails().size());
    }

    @Test
    void test3(){
        var student = studentService.findStudentByName3("icexmoon");
        Assertions.assertEquals("icexmoon", student.getName());
        Assertions.assertEquals(2, student.getEmails().size());
    }

    @Test
    @Transactional
    @Commit
    void test4(){
        var student = studentService.findStudentByName("icexmoon");
        Assertions.assertEquals("icexmoon", student.getName());
        Assertions.assertEquals(2, student.getEmails().size());
    }
}
