package com.example.lazyfetch;

import org.hibernate.SessionFactory;
import org.hibernate.graph.RootGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lazy-fetch
 * @Package : com.example.lazyfetch
 * @ClassName : .java
 * @createTime : 2023/7/8 15:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SessionFactory sessionFactory;

    public Student findStudentByName(String name) {
        return studentRepository.findOne(Example.of(Student.builder()
                .name(name)
                .build())).get();
    }

    public Student findStudentByName2(String name) {
        var session = sessionFactory.openSession();
        Student student = session.createQuery("select s from Student s join fetch s.emails where s.name=:name", Student.class)
                .setParameter("name", name)
                .getSingleResult();
        session.close();
        return student;
    }

    public Student findStudentByName3(String name) {
        long id = this.findStudentByName("icexmoon").getId();
        var session = sessionFactory.openSession();
        RootGraph<Student> entityGraph = session.createEntityGraph(Student.class);
        entityGraph.addAttributeNodes("name", "emails");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        return session.find(Student.class, id, properties);
    }
}
