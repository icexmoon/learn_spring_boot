package cn.icexmoon.books2.book.controller;

import cn.icexmoon.books2.book.entity.Book;
import cn.icexmoon.books2.book.entity.dto.BookDTO;
import cn.icexmoon.books2.book.entity.dto.BookQueryDTO;
import cn.icexmoon.books2.book.service.BookService;
import cn.icexmoon.books2.system.Result;
import cn.icexmoon.books2.system.annotation.FuncClock;
import cn.icexmoon.books2.system.proxy.BookServiceProxy;
import cn.icexmoon.books2.system.util.MyLogUtil;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.controller
 * @ClassName : .java
 * @createTime : 2022/10/10 10:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/book/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = BookServiceProxy.getBookServiceAroundProxy(bookService);
    }


    @GetMapping("/{id}")
    public Book getBookInfo(@PathVariable int id) {
        MyLogUtil.doLogging("before getBookInfo request");
        try {
            return bookService.getBookById(id);
        } finally {
            MyLogUtil.doLogging("after getBookInfo request");
        }
    }

    @Data
    @NoArgsConstructor
    private static class PageBooksDTO {
        @NotNull
        private BookQueryDTO query;
        private Integer page;
        private Integer limit;
    }

    @PostMapping("/page")
    @FuncClock
    public List<Book> pageBooks(@RequestBody PageBooksDTO dto) {
        MyLogUtil.doLogging("before pageBooks request");
        try {
            return bookService.pageBooks(dto.getPage(), dto.getLimit(), dto.getQuery());
        } finally {
            MyLogUtil.doLogging("after pageBooks request");
        }
    }

    @PostMapping("/add")
    public Result addBook(@RequestBody BookDTO dto) {
        MyLogUtil.doLogging("before addBook request");
        try {
            Integer newId = bookService.addBook(dto);
            return Result.success(newId);
        } finally {
            MyLogUtil.doLogging("after addBook request");
        }
    }

    @PostMapping("/multip-add")
    public Result addBooks(@RequestBody List<BookDTO> dtos) {
        MyLogUtil.doLogging("before addBooks request");
        try {
            return Result.success(bookService.addBooks(dtos));
        } finally {
            MyLogUtil.doLogging("after addBooks request");
        }
    }

    @PostMapping("/edit/{id}")
    public Result editBook(@RequestBody BookDTO dto, @PathVariable Integer id) {
        MyLogUtil.doLogging("before editBook request");
        try {
            bookService.editBook(dto, id);
            return Result.success();
        } finally {
            MyLogUtil.doLogging("after editBook request");
        }
    }
}
