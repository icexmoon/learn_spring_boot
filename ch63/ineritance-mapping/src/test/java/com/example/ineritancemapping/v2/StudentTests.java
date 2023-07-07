package com.example.ineritancemapping.v2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v2
 * @ClassName : .java
 * @createTime : 2023/7/7 10:21
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
    private TeacherRepository teacherRepository;
    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students,
                    @Autowired List<Teacher> teachers,
                    @Autowired List<Person> persons) {
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        personRepository.deleteAll();
        studentRepository.saveAll(students);
        teacherRepository.saveAll(teachers);
        personRepository.saveAll(persons);
    }

    @Test
    void test() {
        var students = studentRepository.findAll();
        students.forEach(s->{
            System.out.println(s);
        });
        var teachers = teacherRepository.findAll();
        teachers.forEach(t->{
            System.out.println(t);
        });
        var persons = personRepository.findAll();
        persons.forEach(p->{
            System.out.println(p);
        });
    }

    @Test
    void selectAllByBaseClass(@Autowired SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> persons = session.createQuery("from Person2", Person.class).getResultList();
        persons.forEach(p->{
            System.out.println(p);
        });
        transaction.commit();
        session.close();
    }
}
