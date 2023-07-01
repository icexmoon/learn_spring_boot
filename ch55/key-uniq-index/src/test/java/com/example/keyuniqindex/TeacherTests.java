package com.example.keyuniqindex;

import com.example.keyuniqindex.entity.ClassRoom;
import com.example.keyuniqindex.entity.Teacher;
import com.example.keyuniqindex.entity.TeacherClass;
import com.example.keyuniqindex.entity.TeacherClassId;
import com.example.keyuniqindex.repository.ClassRoomRepository;
import com.example.keyuniqindex.repository.TeacherClassRepository;
import com.example.keyuniqindex.repository.TeacherRepository;
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
 * @createTime : 2023/7/1 13:25
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {KeyUniqIndexApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class TeacherTests {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherClassRepository teacherClassRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @BeforeEach
    void beforeEach(@Autowired Teacher teacher,
                    @Autowired ClassRoom classRoom) {
        classRoomRepository.deleteAll();
        teacherRepository.deleteAll();
        teacherClassRepository.deleteAll();
        teacherRepository.save(teacher);
        classRoomRepository.save(classRoom);
    }

    @Test
    void testAddTeacherClass(@Autowired Teacher teacher,
                             @Autowired ClassRoom classRoom) {
        teacherClassRepository.save(TeacherClass.builder()
                .teacherClassId(TeacherClassId.builder()
                        .teacherId(teacher.getId())
                        .classRoomId(classRoom.getId())
                        .build())
                .classLeader(false)
                .build());
        var tc = teacherClassRepository.findById(TeacherClassId.builder()
                .teacherId(teacher.getId())
                .classRoomId(classRoom.getId())
                .build()).get();
        Assertions.assertEquals(teacher.getId(), tc.getTeacherClassId().getTeacherId());
        Assertions.assertEquals(classRoom.getId(), tc.getTeacherClassId().getClassRoomId());
    }
}
