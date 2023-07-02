package com.example.onetoone.v5;

import com.example.onetoone.OneToOneApplication;
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
 * @Package : com.example.onetoone.v5
 * @ClassName : .java
 * @createTime : 2023/7/2 16:45
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
    private StudentRepository5 studentRepository;
    @Autowired
    private StudentInfoRepository5 studentInfoRepository;

    @BeforeEach
    void beforeEach() {
        studentRepository.deleteAll();
    }

    @Test
    void testAddAll(@Autowired List<Student> students) {
        studentRepository.saveAll(students);
        var sList = studentRepository.findAll();
        sList.forEach(s -> {
            System.out.println(s);
        });
        var siList = studentInfoRepository.findAll();
        siList.forEach(si->{
            System.out.println(si);
        });
    }
}
