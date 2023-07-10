package com.example.jpajoin;

import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
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
 * @Project : jpa-join
 * @Package : com.example.jpajoin
 * @ClassName : .java
 * @createTime : 2023/7/9 9:31
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @BeforeEach
    void beforeEach(@Autowired List<School> schools) {
        schoolRepository.deleteAll();
        schoolRepository.saveAll(schools);
    }

    @Test
    void test() {
        var session = sessionFactory.openSession();
        var school = session.createQuery("select s.school from Student s where s.name=:name", School.class)
                .setParameter("name", "icexmoon")
                .getSingleResult();
        Assertions.assertEquals("霍格沃茨魔法学校", school.getName());
    }

    @Test
    void testWithJoinJPQL() {
        var session = sessionFactory.openSession();
        List<Student> students = session.createQuery("select s from Student s join Email e on e.student=s where e.domain=:domain", Student.class)
                .setParameter("domain", "gmail.com")
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testWithInnerJoinJPQL() {
        var session = sessionFactory.openSession();
        List<Student> students = session.createQuery("select s from Student s inner join Email e on e.student=s where e.domain=:domain", Student.class)
                .setParameter("domain", "gmail.com")
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void fetchCollection() {
        var session = sessionFactory.openSession();
        List<Email> emails = session.createQuery("select s.emails from Student s where s.name=:name", Email.class)
                .setParameter("name", "icexmoon")
                .getResultList();
        emails.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    void fetchCollectionWithCondition() {
        var session = sessionFactory.openSession();
        List<Email> emails = session.createQuery("select e from Student s" +
                                " join Email e on e.student=s" +
                                " where s.name=:name" +
                                " and e.domain=:domain",
                        Email.class)
                .setParameter("name", "icexmoon")
                .setParameter("domain", "qq.com")
                .getResultList();
        emails.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    void testJPQLWithLeftJoin() {
        var session = sessionFactory.openSession();
        List<Student> students = session.createQuery("select s from Student s left join Email e" +
                        " on e.student=s" +
                        " where e.domain=:domain", Student.class)
                .setParameter("domain", "qq.com")
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testJoinMultipleEntity() {
        var session = sessionFactory.openSession();
        List<Student> students = session.createQuery("select s from School sc" +
                        " left join Student s on s.school=sc" +
                        " left join Email e on e.student=s" +
                        " where sc.name=:scname" +
                        " and e.domain=:domain", Student.class)
                .setParameter("scname", "霍格沃茨魔法学校")
                .setParameter("domain", "qq.com")
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testJoinWithWhere() {
        var session = sessionFactory.openSession();
        var students = session.createQuery("select s from Student s,Email e" +
                        " where s=e.student" +
                        " and e.domain=:domain", Student.class)
                .setParameter("domain", "gmail.com")
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testJoinWithWhereAndNoJoinCondition() {
        var session = sessionFactory.openSession();
        var students = session.createQuery("select s from Student s,Email e", Student.class)
                .getResultList();
        students.forEach(s->{
            System.out.println(s);
        });
    }

    @Test
    void testJoinWithFetch(){
        var session = sessionFactory.openSession();
        var students = session.createQuery("select s from Student s" +
                " left join fetch Email e on e.student=s", Student.class)
                .getResultList();
        log.info("fetch students over.");
        students.forEach(s->{
            System.out.println(s);
        });
    }
}
