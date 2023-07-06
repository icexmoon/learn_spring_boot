package com.example.filterentityassociation.v2;

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
 * @Package : com.example.filterentityassociation.v2
 * @ClassName : .java
 * @createTime : 2023/7/6 11:58
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
    private AccountRepository accountRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        var session = sessionFactory.openSession();
        var transaction = session.getTransaction();
        transaction.begin();
        session.createNativeQuery("delete from account2", Account.class).executeUpdate();
        session.createNativeQuery("delete from student2", Student.class).executeUpdate();
        transaction.commit();
        session.close();
        studentRepository.saveAll(students);
    }

    @Test
    void test() {
        var savedStudent = studentRepository.findAll().stream().findFirst().get();
        System.out.println("admin accounts;");
        savedStudent.getAdminAccounts().forEach(a->{
            System.out.println(a);
        });
        System.out.println("member accounts:");
        savedStudent.getMemberAccounts().forEach(a->{
            System.out.println(a);
        });
    }
}
