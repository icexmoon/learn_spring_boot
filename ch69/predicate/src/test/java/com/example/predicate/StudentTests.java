package com.example.predicate;

import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.*;
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

    @Test
    void test5() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.and(cb.ge(root.get("averageScore"), 20),
                cb.le(root.get("averageScore"), 80)));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testWithBetween() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.between(root.get("averageScore"), 20, 80));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testWithLike() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.like(root.get("name"), "B%"));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testWithIn() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.in(root.get("level"), List.of(Student.Level.FRESH_MAN, Student.Level.SOPHOMORE)));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testWithIn2() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(root.get("level").in(Student.Level.FRESH_MAN, Student.Level.SOPHOMORE));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testIsNull() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(cb.isNull(root.get("name")));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testIsNull2() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.where(root.get("name").isNull());
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testSort() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Student> query = cb.createQuery(Student.class);
        JpaRoot<Student> root = query.from(Student.class);
        query = query.orderBy(cb.desc(root.get("averageScore")),
                cb.asc(root.get("name")));
        var students = session.createQuery(query).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testCount() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Long> query = cb.createQuery(Long.class);
        JpaRoot<Student> root = query.from(Student.class);
        query.select(cb.count(root));
        Long count = session.createQuery(query).getSingleResult();
        System.out.println(count);
    }

    @Test
    void testSum() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        JpaRoot<Student> root = query.from(Student.class);
        query.select(cb.sum(root.get("averageScore")));
        Integer sum = session.createQuery(query).getSingleResult();
        System.out.println(sum);
    }

    @Test
    void testUpdate() {
        HibernateCriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaUpdate<Student> criteriaUpdate = cb.createCriteriaUpdate(Student.class);
        Root<Student> root = criteriaUpdate.from(Student.class);
        criteriaUpdate.set("averageScore", 99);
        criteriaUpdate.where(cb.equal(root.get("name"), "icexmoon"));
        Transaction transaction = session.beginTransaction();
        session.createMutationQuery(criteriaUpdate).executeUpdate();
        transaction.commit();
    }

    @Test
    void testDelete(){
        HibernateCriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaDelete<Student> criteriaDelete = cb.createCriteriaDelete(Student.class);
        Root<Student> root = criteriaDelete.from(Student.class);
        criteriaDelete.where(cb.le(root.get("averageScore"), 60));
        Transaction transaction = session.beginTransaction();
        session.createMutationQuery(criteriaDelete).executeUpdate();
        transaction.commit();
    }
}
