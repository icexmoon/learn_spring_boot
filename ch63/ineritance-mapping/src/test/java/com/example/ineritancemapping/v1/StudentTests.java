package com.example.ineritancemapping.v1;

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
 * @Package : com.example.ineritancemapping
 * @ClassName : .java
 * @createTime : 2023/7/7 9:15
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

    @BeforeEach
    void beforeEach(@Autowired List<Student> students,
                    @Autowired List<Teacher> teachers){
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        studentRepository.saveAll(students);
        teacherRepository.saveAll(teachers);
    }

    @Test
    void test(){
        var students = studentRepository.findAll();
        var teachers = teacherRepository.findAll();
        students.forEach(s->{
            System.out.println(s);
        });
        teachers.forEach(t->{
            System.out.println(t);
        });
    }

    @Test
    void selectAllByBaseClass(@Autowired SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> persons = session.createQuery("from com.example.ineritancemapping.v1.Person", Person.class).getResultList();
        persons.forEach(p->{
            System.out.println(p);
        });
        transaction.commit();
        session.close();
    }
}
