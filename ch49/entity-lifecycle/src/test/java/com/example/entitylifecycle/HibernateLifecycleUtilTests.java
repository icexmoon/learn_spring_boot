package com.example.entitylifecycle;

import com.example.entitylifecycle.models.user.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @createTime : 2023/6/27 17:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {EntityLifecycleApplication.class})
@TestPropertySource("classpath:application.properties")
public class HibernateLifecycleUtilTests {
    @Autowired
    private HibernateLifecycleUtil hibernateLifecycleUtil;
    @Autowired
    private SessionFactory sessionFactory;
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
    void testGetManagedEntities() {
        var session = sessionFactory
                .withOptions()
                .interceptor(new DirtyDataRecorderInterceptor())
                .openSession();
        var students = session.createQuery("from user_student", Student.class).getResultList();
        Assertions.assertEquals(this.students, students);
        var entities = hibernateLifecycleUtil.getManagedEntities(session);
        Assertions.assertEquals(3, entities.size());
        session.close();
    }
}
