package com.example.entitylifecycleenvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Example;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle-envent
 * @Package : com.example.entitylifecycleenvent
 * @ClassName : .java
 * @createTime : 2023/6/28 18:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {EntityLifecycleEnventApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(StudentConfig.class)
public class LifecycleTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private List<Student> exampleStudents;

    @BeforeEach
    void beforeEach() {
        // 清空数据表，并插入示例 student 数据
        studentRepository.deleteAll();
        studentRepository.saveAll(exampleStudents);
    }

    @Test
    void testPersistEvent() {
        Student student = new Student("lalala", LocalDate.of(2002, 1, 1), Gender.MALE);
        studentRepository.save(student);
    }

    @Test
    void testRemoveEvent() {
        Student student = studentRepository
                .findOne(Example.of(new Student("icexmoon", null, null)))
                .get();
        studentRepository.delete(student);
    }

    @Test
    void testUpdateEvent(){
        Student student = studentRepository
                .findOne(Example.of(new Student("icexmoon", null, null)))
                .get();
        student.setBirthDay(LocalDate.of(1990,1,1));
        student.setName("moyuhongcha");
        studentRepository.save(student);
    }
}
