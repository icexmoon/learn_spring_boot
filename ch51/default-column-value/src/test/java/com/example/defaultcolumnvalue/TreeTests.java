package com.example.defaultcolumnvalue;

import com.example.defaultcolumnvalue.entity.user.Tree;
import com.example.defaultcolumnvalue.repository.user.TreeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : default-column-value
 * @Package : com.example.defaultcolumnvalue
 * @ClassName : .java
 * @createTime : 2023/6/29 17:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = {DefaultColumnValueApplication.class})
@TestPropertySource("classpath:application.properties")
public class TreeTests {
    @Autowired
    private TreeRepository treeRepository;

    @BeforeEach
    void beforeEach(){
        treeRepository.deleteAll();
    }

    @Test
    void testAddTreeWithDefaultValue(){
        Tree tree = new Tree();
        treeRepository.save(tree);
        Assertions.assertEquals(5, tree.getAge());
    }
}
