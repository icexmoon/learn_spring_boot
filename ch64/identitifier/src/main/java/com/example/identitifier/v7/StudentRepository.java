package com.example.identitifier.v7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : identitifier
 * @Package : com.example.identitifier
 * @ClassName : .java
 * @createTime : 2023/7/7 15:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository("StudentRepository7")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
