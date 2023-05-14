package cn.icexmoon.demo.books.book.controller;


import cn.icexmoon.demo.books.book.entity.Book;
import cn.icexmoon.demo.books.book.service.IBookService;
import cn.icexmoon.demo.books.system.Result;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@RestController
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;


    @RequiresRoles(value = {"guest", "manager"}, logical = Logical.OR)
    @GetMapping("/book")
    public String listAllBooks() {
        Result result = new Result();
        List<Book> books = bookService.list();
        result.setData(books);
        return result.toString();
    }

    @RequiresRoles("manager")
    @PostMapping("/book/add")
    public String addBook(@RequestBody Book book) {
        //添加图书
        Subject subject = SecurityUtils.getSubject();
        String name = (String) subject.getPrincipal();
        User user = userService.getUserByName(name);
        book.setUserId(user.getId());
        bookService.save(book);
        Result result = new Result();
        result.setData(book.getId());
        result.setMsg("添加成功");
        return result.toString();
    }
}
