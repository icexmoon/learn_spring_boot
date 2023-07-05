package com.example.cascade;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
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
 * @Project : cascade
 * @Package : com.example.cascade
 * @ClassName : .java
 * @createTime : 2023/7/5 11:12
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
    private SessionFactory sessionFactory;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmailRepository emailRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
//        emailRepository.deleteAll();
        studentRepository.deleteAll();
        studentRepository.saveAllAndFlush(students);
    }

    @Test
    @Commit
    void testAddNew(@Autowired List<Student> students) {
        if (TestTransaction.isActive()) {
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
        TestTransaction.start();
        var session = sessionFactory.openSession();
        var transaction = session.getTransaction();
        transaction.begin();
//        students.forEach(s -> {
//            session.persist(s);
//        });
//        transaction.commit();
//        transaction.begin();
        var icexmoon = students.stream().filter(s -> s.getName().equals("icexmoon")).findFirst().get();
        long id = icexmoon.getId();
        var savedIcexmoon = session.find(Student.class, id);
        var icexmoonEmail = savedIcexmoon.getEmails().get(0);
        icexmoonEmail.setName("111")
                .setDomain("gmail.com");
        session.persist(icexmoonEmail);
        transaction.commit();
        session.close();
    }

    @Commit
    @Test
    void testAddWithRepository(@Autowired @Qualifier("student") Student student) {
        studentRepository.saveAndFlush(student);
        student.getEmails().get(0)
                .setName("111")
                .setDomain("gmail.com");
        studentRepository.saveAndFlush(student);
    }

    @Test
    void testMerge(@Autowired @Qualifier("student") Student icexmoon) {
        if (TestTransaction.isActive()) {
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
        TestTransaction.start();
        var session = sessionFactory.openSession();
        var transaction = session.getTransaction();
        transaction.begin();
        var savedIcexmoon = session.find(Student.class, icexmoon.getId());
        session.evict(savedIcexmoon);
        savedIcexmoon.getEmails().get(0).setName("111").setDomain("gmail.com");
        session.merge(savedIcexmoon);
        transaction.commit();
        session.close();
    }

    @Test
    void testRemove(@Autowired @Qualifier("student") Student icexmoon) {
        if (TestTransaction.isActive()) {
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
        TestTransaction.start();
        var session = sessionFactory.openSession();
        var transaction = session.getTransaction();
        transaction.begin();
        var savedIcexmoon = session.find(Student.class, icexmoon.getId());
        session.remove(savedIcexmoon);
        transaction.commit();
        session.close();
    }

    @Test
    void testDetach(@Autowired @Qualifier("student") Student icexmoon) {
        if (TestTransaction.isActive()) {
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
        TestTransaction.start();
        var session = sessionFactory.openSession();
        var transaction = session.getTransaction();
        transaction.begin();
        var savedIcexmoon = session.find(Student.class, icexmoon.getId());
        Assertions.assertTrue(session.contains(savedIcexmoon));
        savedIcexmoon.getEmails().forEach(e -> {
            Assertions.assertTrue(session.contains(e));
        });
        session.detach(savedIcexmoon);
        Assertions.assertFalse(session.contains(savedIcexmoon));
        savedIcexmoon.getEmails().forEach(e -> {
            Assertions.assertFalse(session.contains(e));
        });
        transaction.commit();
        session.close();
    }

    @Test
    void testRefresh(@Autowired @Qualifier("student") Student icexmoon) {
        if (TestTransaction.isActive()) {
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
        TestTransaction.start();
        var session = sessionFactory.openSession();
        var transaction = session.getTransaction();
        transaction.begin();
        var savedIcexmoon = session.find(Student.class, icexmoon.getId());
        savedIcexmoon.setName("lalala");
        var savedEmail = savedIcexmoon.getEmails().get(0);
        savedEmail.setName("666").setDomain("gmail.com");
        var oldEmailName = savedEmail.getName();
        var oldEmailDomain = savedEmail.getDomain();
        Assertions.assertEquals("lalala", savedIcexmoon.getName());
        Assertions.assertEquals("666", savedEmail.getName());
        Assertions.assertEquals("gmail.com", savedEmail.getDomain());
        session.refresh(savedIcexmoon);
        Assertions.assertEquals("icexmoon", savedIcexmoon.getName());
        Assertions.assertEquals(oldEmailName, savedEmail.getName());
        Assertions.assertEquals(oldEmailDomain, savedEmail.getDomain());
        transaction.commit();
        session.close();
    }
}
