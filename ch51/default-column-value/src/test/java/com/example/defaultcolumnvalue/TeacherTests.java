package com.example.defaultcolumnvalue;

import com.example.defaultcolumnvalue.entity.user.Teacher;
import com.example.defaultcolumnvalue.repository.user.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @createTime : 2023/6/29 17:34
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {DefaultColumnValueApplication.class})
@TestPropertySource("classpath:application.properties")
public class TeacherTests {
    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach
    void beforeEach() {
        teacherRepository.deleteAll();
    }

    @Test
    void testAddTeacherWithDefaultValue() {
        Teacher teacher = new Teacher();
        teacherRepository.save(teacher);
        var findTeacher = teacherRepository.findAll().stream().findFirst().get();
        Assertions.assertNotNull(findTeacher.getName());
        Assertions.assertEquals("icexmoon", findTeacher.getName());
    }

    @Test
    void testAddTeacherWithDefaultValue2() {
        Teacher teacher = new Teacher();
        teacherRepository.save(teacher);
        Assertions.assertNull(teacher.getName());
        Assertions.assertNotNull(teacher.getId());
        var findTeacher = teacherRepository.findAll().stream().findFirst().get();
        Assertions.assertNotNull(findTeacher.getName());
        Assertions.assertEquals("icexmoon", findTeacher.getName());
    }
}
