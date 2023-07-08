package com.example.query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : query
 * @Package : com.example.query
 * @ClassName : .java
 * @createTime : 2023/7/8 10:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void testCreateQuery() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Student> query = session.createQuery("select s from Student s where s.name=:name", Student.class);
        query.setParameter("name", "icexmoon");
        Student student = query.getSingleResult();
        Assertions.assertEquals("icexmoon", student.getName());
        transaction.commit();
        session.close();
    }

    @Test
    void testCreateNamedQuery() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.createNamedQuery("Student.findByName", Student.class)
                .setParameter("name", "icexmoon")
                .getSingleResult();
        Assertions.assertEquals("icexmoon", student.getName());
        List<Student> students = session.createNamedQuery("Student.findByBirthDay", Student.class)
                .setParameter("birthDay", LocalDate.of(2000, 1, 1))
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
        transaction.commit();
        session.close();
    }

    @Test
    void testCreateNativeQuery() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String targetName = "icexmoon";
        NativeQuery<Student> nativeQuery = session.createNativeQuery("select * from student where name=:name", Student.class);
        nativeQuery.setParameter("name", targetName);
        Student student = nativeQuery.getSingleResult();
        Assertions.assertEquals(targetName, student.getName());
        transaction.commit();
        session.close();
    }

    @Test
    void testCriteriaAPIQuery() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        JpaRoot<Student> from = query.from(Student.class);
        String targetName = "icexmoon";
        query = query.select(from)
                .where(criteriaBuilder.equal(from.get("name"), targetName));
        Student student = session.createQuery(query)
                .getSingleResult();
        Assertions.assertEquals(targetName, student.getName());
        transaction.commit();
        session.close();
    }
}
