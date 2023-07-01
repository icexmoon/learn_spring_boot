package com.example.keyuniqindex.repository;

import com.example.keyuniqindex.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa
 * @Package : com.example.jpa.repository.user
 * @ClassName : .java
 * @createTime : 2023/6/25 12:03
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
