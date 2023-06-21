package com.example.lookup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lookup
 * @Package : com.example.lookup
 * @ClassName : .java
 * @createTime : 2023/6/21 11:28
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {LookupApplication.class})
public class BookStore5Tests {
    @Test
    void testBookStore5(@Autowired BookStore5 bookStore5) {
        var book1 = bookStore5.getBook();
        var book2 = bookStore5.getBook();
        Assertions.assertNotSame(book1, book2);
    }
}
