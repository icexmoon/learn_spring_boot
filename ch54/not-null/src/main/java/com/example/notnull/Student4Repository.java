package com.example.notnull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : not-null
 * @Package : com.example.notnull
 * @ClassName : .java
 * @createTime : 2023/6/30 19:01
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface Student4Repository extends JpaRepository<Student4, Long> {

}
