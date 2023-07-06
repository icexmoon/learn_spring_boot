package com.example.filterentityassociation.v5;

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
 * @Package : com.example.filterentityassociation.v5
 * @ClassName : .java
 * @createTime : 2023/7/6 19:31
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
    void boeforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void test() {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.enableFilter("accountRoleFilter")
                .setParameter("role", "ADMIN");
        var students = session.createQuery("from Student5", Student.class).getResultList();
        students.forEach(s->{
            System.out.println(s);
        });
        transaction.commit();
        session.close();
    }
}
