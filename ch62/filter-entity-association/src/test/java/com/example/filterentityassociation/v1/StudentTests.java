package com.example.filterentityassociation.v1;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation
 * @ClassName : .java
 * @createTime : 2023/7/6 9:51
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
        session.createNativeQuery("delete from account", Account.class).executeUpdate();
        session.createNativeQuery("delete from student", Student.class).executeUpdate();
        transaction.commit();
        session.close();
        studentRepository.saveAll(students);
    }

    @AfterEach
    void afterEach(){
    }

    @Commit
    @Test
    void test() {
        var students = studentRepository.findAll();
        students.forEach(s -> {
            System.out.println(s);
        });
        var savedIcexmoon = students.stream().filter(s -> s.getName().equals("icexmoon")).findFirst().get();
        Assertions.assertEquals(2, savedIcexmoon.getAccounts().size());
        savedIcexmoon.getAccounts().forEach(a -> {
            a.setDelFlag(true);
        });
        studentRepository.save(savedIcexmoon);
        students = studentRepository.findAll();
        savedIcexmoon = students.stream().filter(s -> s.getName().equals("icexmoon")).findFirst().get();
        Assertions.assertEquals(0, savedIcexmoon.getAccounts().size());
    }
}
