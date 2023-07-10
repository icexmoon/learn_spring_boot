package com.example.jpajoin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jpa-join
 * @Package : com.example.jpajoin
 * @ClassName : .java
 * @createTime : 2023/7/9 9:47
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
