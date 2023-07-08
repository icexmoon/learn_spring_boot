package com.example.queryparams;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaParameterExpression;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.Assertions;
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
 * @Project : query-params
 * @Package : com.example.queryparams
 * @ClassName : .java
 * @createTime : 2023/7/8 12:18
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
    void testNamedParam() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String searchName = "icexmoon";
        var student = session.createQuery("select s from Student s where s.name=:name", Student.class)
                .setParameter("name", searchName)
                .getSingleResult();
        Assertions.assertEquals(searchName, student.getName());
        transaction.commit();
        session.close();
    }

    @Test
    void testNamedParamWithCollectionAsParamValue() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        var students = session.createQuery("select s from Student s where s.type in :types", Student.class)
                .setParameter("types", List.of(Student.Type.HIGH_SCHOOL_STUDENT, Student.Type.COLLEGE_STUDENT))
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
        transaction.commit();
        session.close();
    }

    @Test
    void testNamedParamWithNativeQuery() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String searchName = "icexmoon";
        var student = session.createNativeQuery("select * from student as s where s.name=:name", Student.class)
                .setParameter("name", searchName)
                .getSingleResult();
        Assertions.assertEquals(searchName, student.getName());
        transaction.commit();
        session.close();
    }

    @Test
    void testNamedParamWithRepeated() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String searchName = "icexmoon";
        var students = session.createQuery("select s from Student s where s.mathScore>=:minScore" +
                        " and s.englishScore>=:minScore" +
                        " and s.chineseScore>=:minScore", Student.class)
                .setParameter("minScore", 70)
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
        transaction.commit();
        session.close();
    }

    @Test
    void testPositionParam() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createQuery("select s from Student s where s.chineseScore>=?1" +
                        " and s.mathScore>=?2" +
                        " and s.englishScore>=?3", Student.class)
                .setParameter(1, 50)
                .setParameter(2, 60)
                .setParameter(3, 70)
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
        transaction.commit();
        session.close();
    }

    @Test
    void testPositionParamWithNativeQuery() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createNativeQuery("select * from student as s where s.chinese_score>=?1" +
                        " and s.math_score>=?2" +
                        " and s.english_score>=?3", Student.class)
                .setParameter(1, 50)
                .setParameter(2, 60)
                .setParameter(3, 70)
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
        transaction.commit();
        session.close();
    }

    @Test
    void testCriteriaQuery() {
        var cb = sessionFactory.getCriteriaBuilder();
        JpaCriteriaQuery<Object> query = cb.createQuery();
        JpaRoot<Student> root = query.from(Student.class);
        JpaParameterExpression<String> nameParam = cb.parameter(String.class);
        JpaParameterExpression<Integer> minScoreParam = cb.parameter(Integer.class);
        query = query.select(root)
                .where(cb.and(cb.equal(root.get("name"), nameParam),
                        cb.ge(root.get("chineseScore"), minScoreParam),
                        cb.ge(root.get("mathScore"), minScoreParam),
                        cb.ge(root.get("englishScore"), minScoreParam)));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = (Student) session.createQuery(query)
                .setParameter(nameParam, "icexmoon")
                .setParameter(minScoreParam, 60)
                .getSingleResult();
        System.out.println(student);
        transaction.commit();
        session.close();
    }
}
