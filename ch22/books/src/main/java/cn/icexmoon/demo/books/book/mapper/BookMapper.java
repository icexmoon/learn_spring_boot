package cn.icexmoon.demo.books.book.mapper;

import cn.icexmoon.demo.books.book.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 获取分页的书籍列表
     *
     * @param page
     * @return
     */
    IPage<Book> getPagedBooks(IPage<Book> page);
}
