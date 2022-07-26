package cn.icexmoon.demo.books.book.controller;


import cn.icexmoon.demo.books.book.entity.Book;
import cn.icexmoon.demo.books.book.service.IBookService;
import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.system.result.IResultArrayList;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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
@RequestMapping("")
@Api(tags = "书籍管理")
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

    @Data
    private static class AddBookDTO {
        @ApiModelProperty("书籍名称")
        private String name;
        @ApiModelProperty("书籍说明")
        private String desc;
    }

    @RequiresRoles("manager")
    @PostMapping("/book/add")
    @ApiOperation("添加书籍")
    public Result addBook(@RequestBody AddBookDTO dto) {
        //添加图书
        Subject subject = SecurityUtils.getSubject();
        String name = (String) subject.getPrincipal();
        User user = userService.getUserByName(name);
        Book book = new Book();
        book.setUserId(user.getId());
        book.setName(dto.getName());
        book.setDescription(dto.getDesc());
        bookService.save(book);
        return Result.success();
    }

    @PostMapping("/book/form/add")
    @ApiOperation("添加书籍（使用表单）")
    public Result addBookByForm(@RequestParam String name, @RequestParam String desc) {
        //添加图书
        Subject subject = SecurityUtils.getSubject();
        String uname = (String) subject.getPrincipal();
        User user = userService.getUserByName(uname);
        Book book = new Book();
        book.setUserId(user.getId());
        book.setName(name);
        book.setDescription(desc);
        bookService.save(book);
        return Result.success();
    }

    @Data
    private static class GetBookInfoVO implements IResult {
        @ApiModelProperty("图书id")
        private Integer id;
        @ApiModelProperty("图书名称")
        private String name;
        @ApiModelProperty("图书介绍")
        private String desc;
        @ApiModelProperty("添加人id")
        private Integer uid;

        public static GetBookInfoVO newInstance(Book book) {
            GetBookInfoVO vo = new GetBookInfoVO();
            vo.setId(book.getId());
            vo.setName(book.getName());
            vo.setDesc(book.getDescription());
            vo.setUid(book.getUserId());
            return vo;
        }
    }

    @ApiOperation("获取书籍详情")
    @GetMapping("/book/detail/{id}")
    public GetBookInfoVO getBookInfo(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new ResultException(Result.ErrorCode.PARAM_CHECK, String.format("%d不是一个有效的书籍id", id));
        }
        return GetBookInfoVO.newInstance(book);
    }

    @ApiOperation("查询书籍列表")
    @GetMapping("/book/list/query")
    public List<Book> getQueryBooks(@RequestParam(required = false) String name, @RequestParam(required = false) String desc, @RequestParam(required = false) Integer userId) {
        List<Book> books = new IResultArrayList<>();
        QueryWrapper<Book> qw = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(name)) {
            qw.like("name", name);
        }
        if (!ObjectUtils.isEmpty(desc)) {
            qw.like("description", desc);
        }
        if (userId != null && userId > 0) {
            qw.eq("user_id", userId);
        }
        List<Book> findBooks;
        if (!qw.isEmptyOfWhere()) {
            findBooks = bookService.list(qw);
        } else {
            findBooks = bookService.list();
        }
        books.addAll(findBooks);
        return books;
    }

    @Data
    private static class GetQueryBooksByPostJSONDTO {
        @ApiModelProperty("书籍名称")
        private String name;
        @ApiModelProperty("书籍介绍")
        private String desc;
        @ApiModelProperty("添加书籍人id")
        private Integer userId;
    }

    @ApiOperation("查询书籍列表（POST+JSON方式）")
    @PostMapping("/book/list/query")
    public List<Book> getQueryBooksByPostJSON(@RequestBody GetQueryBooksByPostJSONDTO dto) {
        List<Book> books = new IResultArrayList<>();
        QueryWrapper<Book> qw = new QueryWrapper<>();
        String name = dto.getName();
        if (!ObjectUtils.isEmpty(name)) {
            qw.like("name", name);
        }
        String desc = dto.getDesc();
        if (!ObjectUtils.isEmpty(desc)) {
            qw.like("description", desc);
        }
        Integer userId = dto.getUserId();
        if (userId != null && userId > 0) {
            qw.eq("user_id", userId);
        }
        List<Book> findBooks;
        if (!qw.isEmptyOfWhere()) {
            findBooks = bookService.list(qw);
        } else {
            findBooks = bookService.list();
        }
        books.addAll(findBooks);
        return books;
    }
}
