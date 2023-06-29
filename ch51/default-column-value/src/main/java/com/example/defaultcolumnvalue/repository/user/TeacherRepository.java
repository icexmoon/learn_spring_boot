package com.example.defaultcolumnvalue.repository.user;

import com.example.defaultcolumnvalue.entity.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : default-column-value
 * @Package : com.example.defaultcolumnvalue
 * @ClassName : .java
 * @createTime : 2023/6/29 17:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
