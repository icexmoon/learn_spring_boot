package com.example.filterentityassociation.v3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v3
 * @ClassName : .java
 * @createTime : 2023/7/6 13:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringBootTest
@Import(ExampleDataConfig.class)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StudentAddressRepository studentAddressRepository;

    @BeforeEach
    void beforeEach(@Autowired @Qualifier("student") Student student1,
                    @Autowired @Qualifier("address1") Address address1,
                    @Autowired @Qualifier("address2") Address address2) {
        studentAddressRepository.deleteAll();
        studentRepository.deleteAll();
        addressRepository.deleteAll();
        studentRepository.save(student1);
        addressRepository.save(address1);
        addressRepository.save(address2);
        studentAddressRepository.save(new StudentAddress(
                new StudentAddress.StudentAdressId(student1.getId(), address1.getId()),
                StudentAddress.Type.LONG));
        studentAddressRepository.save(new StudentAddress(
                new StudentAddress.StudentAdressId(student1.getId(), address2.getId()),
                StudentAddress.Type.TEMPORARY));
    }

    @Test
    void test() {
        var students = studentRepository.findAll();
        students.forEach(s->{
            System.out.println(s);
        });
    }
}
