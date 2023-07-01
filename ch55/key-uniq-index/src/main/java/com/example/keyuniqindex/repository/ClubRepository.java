package com.example.keyuniqindex.repository;

import com.example.keyuniqindex.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : key-uniq-index
 * @Package : com.example.keyuniqindex.repository
 * @ClassName : .java
 * @createTime : 2023/7/1 15:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
