package com.example.entitylifecycleenvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle-envent
 * @Package : com.example.entitylifecycleenvent
 * @ClassName : .java
 * @createTime : 2023/6/28 18:10
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
