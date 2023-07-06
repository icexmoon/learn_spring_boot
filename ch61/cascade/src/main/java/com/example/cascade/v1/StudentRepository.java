package com.example.cascade.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cascade
 * @Package : com.example.cascade
 * @ClassName : .java
 * @createTime : 2023/7/5 11:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
