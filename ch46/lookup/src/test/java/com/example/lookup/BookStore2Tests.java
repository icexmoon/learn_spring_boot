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
 * @createTime : 2023/6/21 10:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig
public class BookStore2Tests {
    @Configuration
    @Import(BookConfig.class)
    static class Config {
        @Bean
        public BookStore2 bookStore2() {
            return new BookStore2();
        }
    }

    @Test
    void testBookInject(@Autowired BookStore2 bookStore2) {
        var book1 = bookStore2.getBook();
        var book2 = bookStore2.getBook();
        Assertions.assertNotSame(book1, book2);
    }
}
