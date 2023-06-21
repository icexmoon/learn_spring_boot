package com.example.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lookup
 * @Package : com.example.lookup
 * @ClassName : .java
 * @createTime : 2023/6/21 10:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class BookStore3 {
    @Lookup
    public Book getBook() {
        return null;
    }
}
