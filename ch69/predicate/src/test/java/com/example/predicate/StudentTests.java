package com.example.predicate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : predicate
 * @Package : com.example.predicate
 * @ClassName : .java
 * @createTime : 2023/7/10 13:27
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
    private Session session;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
        session = sessionFactory.openSession();
    }

    @AfterEach
    void afterEach() {
        session.close();
    }

    @Test
    void test() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        JpaPredicate level = cb.equal(root.get("level"), Student.Level.FRESH_MAN);
        query = query.where(level);
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void test2() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        JpaPredicate level = cb.equal(root.get("level"), Student.Level.FRESH_MAN);
        JpaPredicate averageScore = cb.ge(root.get("averageScore"), 60);
        JpaPredicate and = cb.and(level, averageScore);
        query = query.where(and);
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void test3() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.and(
                cb.in(root.get("level"), List.of(Student.Level.FRESH_MAN, Student.Level.SOPHOMORE)),
                cb.ge(root.get("averageScore"), 60))
        );
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void test4() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.and(
                cb.or(
                        cb.equal(root.get("level"), Student.Level.FRESH_MAN),
                        cb.equal(root.get("level"), Student.Level.SOPHOMORE)),
                cb.ge(root.get("averageScore"), 60))
        );
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }
}
