package cn.icexmoon.books2.book.service.impl;

import cn.icexmoon.books2.book.entity.Book;
import cn.icexmoon.books2.book.entity.dto.BookDTO;
import cn.icexmoon.books2.book.mapper.BookMapper;
import cn.icexmoon.books2.book.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.service.impl
 * @ClassName : .java
 * @createTime : 2022/10/10 10:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<Book> pageBooks(int page, int limit) {
        return bookMapper.pageBooks((page - 1) * limit, limit);
    }

    @Override
    public Integer addBook(BookDTO dto) {
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        bookMapper.addBook(book);
        return book.getId();
    }

    @Override
    public List<Integer> addBooks(Collection<BookDTO> dtos) {
        List<Book> books = dtos.stream().map(dto -> {
            Book book = new Book();
            BeanUtils.copyProperties(dto, book);
            return book;
        }).collect(Collectors.toList());
        bookMapper.addBooks(books);
        return books.stream().map(b -> b.getId()).collect(Collectors.toList());
    }
}
