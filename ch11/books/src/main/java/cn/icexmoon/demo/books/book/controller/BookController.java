package cn.icexmoon.demo.books.book.controller;


import cn.icexmoon.demo.books.book.entity.Book;
import cn.icexmoon.demo.books.book.service.IBookService;
import cn.icexmoon.demo.books.system.result.IResultArrayList;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation("获取所有图书列表")
    public List<Book> listAllBooks() {
        Result result = new Result();
        List<Book> books = new IResultArrayList<>();
        books.addAll(bookService.list());
        return books;
    }

    @RequiresRoles("manager")
    @PostMapping("/book/add")
    @ApiOperation("添加书籍")
    public Result addBook(@RequestBody Book book) {
        //添加图书
        Subject subject = SecurityUtils.getSubject();
        String name = (String) subject.getPrincipal();
        User user = userService.getUserByName(name);
        book.setUserId(user.getId());
        bookService.save(book);
        return Result.success();
    }
}
