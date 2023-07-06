package com.example.filterentityassociation.v4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation.v4
 * @ClassName : .java
 * @createTime : 2023/7/6 18:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository("StudentRepository4")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
