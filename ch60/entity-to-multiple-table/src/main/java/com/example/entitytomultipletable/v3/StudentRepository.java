package com.example.entitytomultipletable.v3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-to-multiple-table
 * @Package : com.example.entitytomultipletable.v3
 * @ClassName : .java
 * @createTime : 2023/7/4 18:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository("StudentRepository3")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
