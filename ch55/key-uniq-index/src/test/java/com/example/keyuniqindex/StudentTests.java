package com.example.keyuniqindex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex
 * @ClassName : .java
 * @createTime : 2023/7/1 10:18
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {KeyUniqIndexApplication.class})
@TestPropertySource("classpath:application.properties")
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testAddNewStudent(){
        Student s = Student.builder()
                .number("2010000001")
                .name("icexmoon")
                .birthDay(LocalDate.of(2000,1,1))
                .gender(Gender.MALE)
                .build();
        studentRepository.save(s);
    }
}
