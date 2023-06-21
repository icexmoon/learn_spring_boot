package com.example.lookup;

import org.springframework.beans.factory.annotation.Autowired;

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
public class BookStore {
    @Autowired
    private Book book;

    public Book getBook(){
        return book;
    }
}
