package cn.icexmoon.books2.book.controller;

import cn.icexmoon.books2.book.entity.Book;
import cn.icexmoon.books2.book.entity.dto.BookDTO;
import cn.icexmoon.books2.book.service.BookService;
import cn.icexmoon.books2.system.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getBookInfo(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/page/{page}/{limit}")
    public List<Book> pageBooks(@PathVariable Integer page, @PathVariable Integer limit) {
        return bookService.pageBooks(page, limit);
    }

    @PostMapping("/add")
    public Result addBook(@RequestBody BookDTO dto) {
        Integer newId = bookService.addBook(dto);
        return Result.success(newId);
    }

    @PostMapping("/multip-add")
    public Result addBooks(@RequestBody List<BookDTO> dtos){
        return Result.success(bookService.addBooks(dtos));
    }
}
