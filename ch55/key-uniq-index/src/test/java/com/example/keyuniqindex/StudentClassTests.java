package com.example.keyuniqindex;

import com.example.keyuniqindex.entity.ClassRoom;
import com.example.keyuniqindex.entity.Student;
import com.example.keyuniqindex.entity.StudentClass;
import com.example.keyuniqindex.entity.StudentClassId;
import com.example.keyuniqindex.repository.ClassRoomRepository;
import com.example.keyuniqindex.repository.StudentClassRepository;
import com.example.keyuniqindex.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 10:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {KeyUniqIndexApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class StudentClassTests {
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @BeforeEach
    void beforeEach() {
        studentClassRepository.deleteAll();
        studentRepository.deleteAll();
        classRoomRepository.deleteAll();
    }

    @Test
    void testStudentClassAdd(@Autowired Student s, @Autowired ClassRoom c) {
        studentRepository.save(s);
        classRoomRepository.save(c);
        StudentClass sc = new StudentClass(c.getId(), s.getNumber(), 1);
        studentClassRepository.save(sc);
        StudentClass csFind = studentClassRepository.findById(new StudentClassId(c.getId(), s.getNumber())).get();
        Assertions.assertEquals(1, csFind.getSeatNumber());
        Assertions.assertEquals(c.getId(), csFind.getClassRoomId());
        Assertions.assertEquals(s.getNumber(), csFind.getStudentNumber());
    }
}
