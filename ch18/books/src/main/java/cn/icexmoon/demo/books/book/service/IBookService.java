package cn.icexmoon.demo.books.book.service;

import cn.icexmoon.demo.books.book.entity.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
public interface IBookService extends IService<Book> {
    IPage<Book> getPagedBooks(IPage<Book> page);
}
