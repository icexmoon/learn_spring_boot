package com.example.identitifier.v3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
 * @Project : identitifier
 * @Package : com.example.identitifier
 * @ClassName : .java
 * @createTime : 2023/7/7 15:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringBootTest
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students) {
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void test() {
        List<Student> all = studentRepository.findAll();
        all.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    void testIdentifierGenerate(@Autowired EntityManagerFactory entityManagerFactory) {
        var harry = Student.builder()
                .name("Harry")
                .build();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(harry);
//        Assertions.assertNull(harry.getId());
        entityManager.getTransaction().commit();
    }
}
