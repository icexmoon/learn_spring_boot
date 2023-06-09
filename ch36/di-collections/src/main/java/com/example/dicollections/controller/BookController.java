package com.example.dicollections.controller;

import com.example.dicollections.BookCategories;
import com.example.dicollections.entity.BookCategory;
import com.example.dicollections.system.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections.controller
 * @ClassName : .java
 * @createTime : 2023/6/9 10:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Value("#{${book.categories}}")
    private List<BookCategory> bookCategories;

    @Value("#{${book.categories}}")
    private List<String> categories;

    @Autowired
    private BookCategories bookCategories2;

//    @Autowired(required = false)
//    public void setBookCategories(List<BookCategory> bookCategories) {
//        this.bookCategories = bookCategories;
//    }

//    public BookController(List<BookCategory> bookCategories){
//        this.bookCategories = bookCategories;
//    }

    @GetMapping("/category/list")
    public Result<Object> listBookCategories() {
        System.out.println(bookCategories);
        System.out.println(categories);
        System.out.println(bookCategories2.getList());
        return Result.success();
    }
}
