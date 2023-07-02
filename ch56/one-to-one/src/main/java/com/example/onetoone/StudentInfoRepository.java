package com.example.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone
 * @ClassName : .java
 * @createTime : 2023/7/2 10:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {
}
