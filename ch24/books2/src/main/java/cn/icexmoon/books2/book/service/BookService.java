package cn.icexmoon.books2.book.service;

import cn.icexmoon.books2.book.entity.Book;
import cn.icexmoon.books2.book.entity.dto.BookDTO;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.service
 * @ClassName : .java
 * @createTime : 2022/10/10 10:08
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BookService {
    Book getBookById(int id);

    List<Book> pageBooks(int page, int limit);

    Integer addBook(BookDTO dto);

    List<Integer> addBooks(Collection<BookDTO> dtos);
}
