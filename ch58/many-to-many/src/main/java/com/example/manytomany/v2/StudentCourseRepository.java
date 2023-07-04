package com.example.manytomany.v2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : many-to-many
 * @Package : com.example.manytomany.v2
 * @ClassName : .java
 * @createTime : 2023/7/3 20:53
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository("StudentCourseRepository2")
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourse.StudentCourseId> {
}
