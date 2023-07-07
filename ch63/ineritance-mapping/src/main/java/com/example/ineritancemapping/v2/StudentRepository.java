package com.example.ineritancemapping.v2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ineritance-mapping
 * @Package : com.example.ineritancemapping.v2
 * @ClassName : .java
 * @createTime : 2023/7/7 10:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository("StudentRepository2")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
