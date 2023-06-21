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
 * @createTime : 2023/6/21 10:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = LookupApplication.class)
public class BookStore3Tests {
    @Test
    void testBookStore3(@Autowired BookStore3 bookStore3) {
        var book1 = bookStore3.getBook();
        var book2 = bookStore3.getBook();
        Assertions.assertNotSame(book1, book2);
    }
}
