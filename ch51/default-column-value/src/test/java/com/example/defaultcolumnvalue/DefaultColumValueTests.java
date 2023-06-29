package com.example.defaultcolumnvalue;

import com.example.defaultcolumnvalue.entity.user.Student;
import com.example.defaultcolumnvalue.repository.user.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : default-column-value
 * @Package : com.example.defaultcolumnvalue
 * @ClassName : .java
 * @createTime : 2023/6/29 16:26
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {DefaultColumnValueApplication.class})
@TestPropertySource("classpath:application.properties")
public class DefaultColumValueTests {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void beforeEach() {
        studentRepository.deleteAll();
    }

    @Test
    void testNewStudentWithDefaultValue() {
        Student student = new Student();
        studentRepository.save(student);
        Assertions.assertEquals(Student.DEFAULT_NAME, student.getName());
        Assertions.assertEquals(Student.DEFAULT_BIRTH_DAY, student.getBirthDay());
        Assertions.assertEquals(Student.DEFAULT_GENDER, student.getGender());
        var findStudent = studentRepository.findOne(Example.of(new Student().setName(Student.DEFAULT_NAME))).get();
        Assertions.assertNotNull(findStudent);
        Assertions.assertEquals(Student.DEFAULT_NAME, findStudent.getName());
        Assertions.assertEquals(Student.DEFAULT_BIRTH_DAY, findStudent.getBirthDay());
        Assertions.assertEquals(Student.DEFAULT_GENDER, findStudent.getGender());
    }
}
