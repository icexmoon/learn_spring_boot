package com.example.manytomany.v2;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany.v2
 * @ClassName : .java
 * @createTime : 2023/7/3 21:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
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
    private EntityManager entityManager;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students,
                    @Autowired List<Course> courses,
                    @Autowired @Qualifier("student1") Student student1,
                    @Autowired @Qualifier("student2") Student student2,
                    @Autowired @Qualifier("student3") Student student3,
                    @Autowired @Qualifier("art") Course art,
                    @Autowired @Qualifier("math") Course math,
                    @Autowired @Qualifier("physics") Course physics,
                    @Autowired @Qualifier("chemistry") Course chemistry) {
        if (!TestTransaction.isActive()) {
            TestTransaction.start();
        }
        studentRepository.deleteAll();
        courseRepository.deleteAll();
        studentRepository.saveAll(students);
        courseRepository.saveAll(courses);
        TestTransaction.flagForCommit();
        TestTransaction.end();
        TestTransaction.start();
        student1.addCourse(math, 99);
        student1.addCourse(physics, 90);
        student1.addCourse(chemistry, 88);
        student2.addCourse(art, 100);
        student2.addCourse(math, 90);
        student3.addCourse(chemistry, 90);
        student3.addCourse(art, 95);
        studentRepository.saveAll(students);
        TestTransaction.flagForCommit();
        TestTransaction.end();
        TestTransaction.start();
    }

    @Test
    void test() {
        if (!TestTransaction.isActive()) {
            TestTransaction.start();
            TestTransaction.flagForCommit();
        }
        this.printStudentCourse();
        TestTransaction.end();
    }

    @Test
    void testDeleteAssociation(@Autowired @Qualifier("student1") Student student,
                               @Autowired @Qualifier("math") Course course) {
        if (!TestTransaction.isActive()) {
            TestTransaction.start();
            TestTransaction.flagForCommit();
        }
        this.printStudentCourse();
        var students = entityManager.createQuery("from Student2", Student.class).getResultList();
        var icexmoon = students.stream().filter(s -> s.getName().equals("icexmoon")).findFirst().get();
        icexmoon.removeCourse(course);
        entityManager.persist(icexmoon);
        entityManager.flush();
        this.printStudentCourse();
        TestTransaction.end();
    }

    private void printStudentCourse() {
        var students = studentRepository.findAll();
        students.forEach(s -> {
            System.out.println("Student: " + s.getName());
            var studentCourses = s.getStudentCourses();
            studentCourses.forEach(sc -> {
                var cName = sc.getCourse().getName();
                System.out.println("Course: %s, Rate: %d".formatted(cName, sc.getRate()));
            });
        });
    }
}
