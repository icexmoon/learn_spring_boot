package com.example.jpa.services.user;

import com.example.jpa.models.user.Student;
import com.example.jpa.repositories.user.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa
 * @Package : com.example.jpa.services.user
 * @ClassName : .java
 * @createTime : 2023/6/25 12:06
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> list(){
        return studentRepository.findAll();
    }
}
