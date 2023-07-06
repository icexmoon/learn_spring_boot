package com.example.filterentityassociation.v4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v4
 * @ClassName : .java
 * @createTime : 2023/7/6 18:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
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
    void test() {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        printStudents(85, session);
        printStudents(70, session);
        transaction.commit();
        session.close();
    }

    void printStudents(int minScore, Session session){
        session.enableFilter("scoreFilter")
                .setParameter("minScore", minScore);
        var students = session.createQuery("from Student4", Student.class)
                .getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
    }
}
