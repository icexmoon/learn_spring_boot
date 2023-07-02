package com.example.onetoone.v3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : one-to-one
 * @Package : com.example.onetoone.v3
 * @ClassName : .java
 * @createTime : 2023/7/2 13:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface StudentInfoRepository3 extends JpaRepository<StudentInfo, Long> {
}
