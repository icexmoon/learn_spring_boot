package com.example.manytomany.v1;

import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany
 * @ClassName : .java
 * @createTime : 2023/7/3 15:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@Import(ExampleDataConfig.class)
@Transactional
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        courseRepository.deleteAll();
        studentRepository.saveAll(students);
        log.info("all test initialization is done.");
    }

    @Test
    void test() {
        var students = studentRepository.findAll();
        students.forEach(System.out::println);
    }

    @Test
    @Commit
    void testDeleteCourse(@Autowired @Qualifier("student1") Student student) {
        if (TestTransaction.isActive()){
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
        TestTransaction.start();
        TestTransaction.flagForCommit();
        var course = student.getCourses().get(0);
        log.debug(course);
        student.getCourses().remove(course);
        studentRepository.save(student);
        TestTransaction.end();
    }
}
