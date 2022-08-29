package cn.icexmoon.demo.books.book.service.impl;

import cn.icexmoon.demo.books.book.entity.Book;
import cn.icexmoon.demo.books.book.mapper.BookMapper;
import cn.icexmoon.demo.books.book.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public IPage<Book> getPagedBooks(IPage<Book> page) {
        return bookMapper.getPagedBooks(page);
    }
}
