package com.example.keyuniqindex.service;

import com.example.keyuniqindex.entity.ClassRoom;
import com.example.keyuniqindex.entity.Student;
import com.example.keyuniqindex.entity.StudentClass;
import com.example.keyuniqindex.repository.ClassRoomRepository;
import com.example.keyuniqindex.repository.StudentClassRepository;
import com.example.keyuniqindex.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex.service
 * @ClassName : .java
 * @createTime : 2023/7/1 12:04
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class ClassRoomService {
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    /**
     * 获取指定班级的所有学生
     *
     * @param classId 班级id
     * @return
     */
    public List<Student> findStudentsByClassId(long classId) {
        var scList = studentClassRepository.findAll(Example.of(StudentClass.builder()
                .classRoomId(classId)
                .build()));
        var studentNumbers = scList.stream().map(sc -> sc.getStudentNumber()).collect(Collectors.toSet());
        return studentRepository.findAllById(studentNumbers);
    }

    /**
     * 根据学号查询其所属班级
     *
     * @param studentNumber
     * @return
     */
    public ClassRoom findClassRoomByStudentNumber(String studentNumber) {
        var sc = studentClassRepository.findOne(Example.of(StudentClass.builder()
                .studentNumber(studentNumber)
                .build())).get();
        return classRoomRepository.findById(sc.getClassRoomId()).get();
    }
}
