package com.example.onetomany;

import com.example.onetomany.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-many
 * @Package : com.example.onetomany
 * @ClassName : .java
 * @createTime : 2023/7/3 10:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {OneToManyApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void testAddStudents() {
        var students = studentRepository.findAll();
        students.forEach(s->{
            System.out.println(s);
        });
    }
}
