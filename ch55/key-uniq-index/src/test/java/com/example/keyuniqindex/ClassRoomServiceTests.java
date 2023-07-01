package com.example.keyuniqindex;

import com.example.keyuniqindex.entity.ClassRoom;
import com.example.keyuniqindex.entity.Student;
import com.example.keyuniqindex.entity.StudentClass;
import com.example.keyuniqindex.repository.ClassRoomRepository;
import com.example.keyuniqindex.repository.StudentClassRepository;
import com.example.keyuniqindex.repository.StudentRepository;
import com.example.keyuniqindex.service.ClassRoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 12:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {KeyUniqIndexApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class ClassRoomServiceTests {
    @Autowired
    private ClassRoomService classRoomService;

    @BeforeEach
    void beforeEach(@Autowired StudentRepository studentRepository,
                    @Autowired ClassRoomRepository classRoomRepository,
                    @Autowired StudentClassRepository studentClassRepository,
                    @Autowired List<Student> students,
                    @Autowired ClassRoom classRoom) {
        studentRepository.deleteAll();
        classRoomRepository.deleteAll();
        studentClassRepository.deleteAll();
        studentRepository.saveAll(students);
        classRoomRepository.save(classRoom);
        //添加学生-班级对应关系
        var scList = students.stream().map(s -> StudentClass.builder()
                .studentNumber(s.getNumber())
                .classRoomId(classRoom.getId())
                .build()).collect(Collectors.toList());
        studentClassRepository.saveAll(scList);
    }

    @Test
    void testFindStudentsByClassId(@Autowired ClassRoom classRoom, @Autowired List<Student> exampleStudents) {
        var students = classRoomService.findStudentsByClassId(classRoom.getId());
        Assertions.assertEquals(exampleStudents, students);
    }

    @Test
    void testFindClassRoomByStudentNumber(@Autowired Student studentExample,
                                          @Autowired ClassRoom classRoom) {
        var findClassRoom = classRoomService.findClassRoomByStudentNumber(studentExample.getNumber());
        Assertions.assertEquals(classRoom.getId(), findClassRoom.getId());
    }
}
