package com.example.onetoone.v2;

import com.example.onetoone.OneToOneApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v2
 * @ClassName : .java
 * @createTime : 2023/7/2 12:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {OneToOneApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentRepository2 studentRepository;
    @Autowired
    private StudentInfoRepository2 studentInfoRepository;

    @BeforeEach
    void beforeEach() {
        studentInfoRepository.deleteAll();
        studentRepository.deleteAll();
    }

    @Test
    void testAddRelastionship(@Autowired List<Student> students,
                              @Autowired List<StudentInfo> studentInfos) {
        studentRepository.saveAll(students);
        studentInfoRepository.saveAll(studentInfos);
        studentInfos.forEach(si -> {
            Assertions.assertNotNull(si.getStudent().getId());
        });
        var findsis = studentInfoRepository.findAll();
        findsis.forEach(sis -> {
            System.out.println(sis.getStudent());
        });
    }
}
