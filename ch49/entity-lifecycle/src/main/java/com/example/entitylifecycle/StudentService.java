package com.example.entitylifecycle;

import com.example.entitylifecycle.models.user.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle
 * @Package : com.example.entitylifecycle
 * @ClassName : .java
 * @createTime : 2023/6/27 12:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> list(){
        return studentRepository.findAll();
    }
}
