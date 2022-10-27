package cn.icexmoon.books2.book.mapper;

import cn.icexmoon.books2.book.entity.Book;
import cn.icexmoon.books2.book.entity.dto.BookQueryDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.mapper
 * @ClassName : .java
 * @createTime : 2022/9/28 17:53
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BookMapper {
    @Select("SELECT * FROM book WHERE `type`=#{type}")
    List<Book> getBooks(@Param("type") Integer type);

    /**
     * 根据图书ID获取图书
     *
     * @param id 图书ID
     * @return
     */
    Book getBookById(@Param("id") int id);

    /**
     * 获取书籍分页数据
     *
     * @param start 开始游标
     * @param limit 结束游标
     * @return
     */
    List<Book> pageBooks(@Param("start") int start, @Param("limit") int limit, @Param("dto")BookQueryDTO dto);

    /**
     * 添加图书
     *
     * @param book
     */
    void addBook(@Param("book") Book book);

    /**
     * 批量添加图书
     *
     * @param books
     */
    void addBooks(@Param("books") Collection<Book> books);

    /**
     * 更新图书
     * @param book
     */
    void updateBookById(Book book);
}
