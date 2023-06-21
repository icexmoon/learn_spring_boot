package com.example.lookup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lookup
 * @Package : com.example.lookup
 * @ClassName : .java
 * @createTime : 2023/6/21 11:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig
public class BookStore4Tests {
    @Configuration
    @Import(BookConfig.class)
    static class Config {
        @Bean
        public BookStore4 bookStore4() {
            return new BookStore4();
        }
    }

    @Test
    void testBookStore4(@Autowired BookStore4 bookStore4) {
        var book1 = bookStore4.getBook();
        var book2 = bookStore4.getBook();
        Assertions.assertSame(null, book1);
        Assertions.assertSame(null, book2);
    }
}
