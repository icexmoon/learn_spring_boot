package com.example.entitylifecycle;

import com.example.entitylifecycle.models.user.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
 * @Project : entity-lifecycle
 * @Package : com.example.entitylifecycle
 * @ClassName : .java
 * @createTime : 2023/6/27 18:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {EntityLifecycleApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(StudentsConfig.class)
public class DirtyDataRecorderInterceptorTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private List<Student> students;
    @Autowired
    private SessionFactory sessionFactory;

    @BeforeEach
    void beforeEach() {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void testDirtyDataRecorder() {
        var session = sessionFactory
                .withOptions()
                .interceptor(new DirtyDataRecorderInterceptor())
                .openSession();
        List<Student> students = session.createQuery("from user_student", Student.class).getResultList();
        Assertions.assertEquals(this.students, students);
        Transaction transaction = session.beginTransaction();
        var icexmoon = students.stream().filter(student -> student.getName().equals("icexmoon")).findFirst().get();
        icexmoon.setBirthDay(LocalDate.of(2000, 10, 1));
        transaction.commit();
        session.close();
        List<Object> dirtyEntities = DirtyDataRecorderInterceptor.getDirtyEntities();
        Assertions.assertEquals(1, dirtyEntities.size());
        System.out.println(dirtyEntities.get(0));
    }
}
