package cn.icexmoon.demo.books.book.entity.typehandler;

import cn.icexmoon.demo.books.book.entity.Book;
import cn.icexmoon.demo.books.system.MyJsonTypeHandler;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.book.entity.typehandler
 * @ClassName : .java
 * @createTime : 2022/8/8 18:18
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class BookExtraTypeHandler extends MyJsonTypeHandler<Book.Extra> {
    public BookExtraTypeHandler() {
        super(Book.Extra.class);
    }
}
