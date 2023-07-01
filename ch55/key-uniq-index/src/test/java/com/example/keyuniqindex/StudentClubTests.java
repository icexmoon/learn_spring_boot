package com.example.keyuniqindex;

import com.example.keyuniqindex.entity.Club;
import com.example.keyuniqindex.entity.Student;
import com.example.keyuniqindex.entity.StudentClub;
import com.example.keyuniqindex.repository.ClubRepository;
import com.example.keyuniqindex.repository.StudentClubRepository;
import com.example.keyuniqindex.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 14:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {KeyUniqIndexApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class StudentClubTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private StudentClubRepository studentClubRepository;

    @BeforeEach
    void beforeEach(@Autowired List<Student> students,
                    @Autowired List<Club> clubs) {
        studentRepository.deleteAll();
        clubRepository.deleteAll();
        studentClubRepository.deleteAll();
        studentRepository.saveAll(students);
        clubRepository.saveAll(clubs);
    }

    @Test
    void testAddStudentClub(@Autowired List<Student> students,
                            @Autowired List<Club> clubs,
                            @Autowired Student student,
                            @Autowired Club club) {
        students.forEach(s -> {
            clubs.forEach(c -> {
                studentClubRepository.save(StudentClub.builder()
                        .clubId(c.getId())
                        .studentNumber(s.getNumber())
                        .build());
            });
        });
        //单独插入一条重复数据，这里应当报错
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            studentClubRepository.save(StudentClub.builder()
                    .studentNumber(student.getNumber())
                    .clubId(club.getId())
                    .build());
        });
    }
}
