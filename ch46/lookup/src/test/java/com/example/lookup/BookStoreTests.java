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
 * @createTime : 2023/6/21 10:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {WebConfig.class})
public class BookStoreTests {
    @Test
    void testBookInject(@Autowired BookStore bookStore) {
        var book1 = bookStore.getBook();
        var book2 = bookStore.getBook();
        Assertions.assertSame(book1, book2);
    }
}
