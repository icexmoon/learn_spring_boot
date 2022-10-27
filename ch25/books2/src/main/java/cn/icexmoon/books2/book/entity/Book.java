package cn.icexmoon.books2.book.entity;

import cn.icexmoon.books2.book.entity.enums.BookType;
import cn.icexmoon.books2.user.entity.User;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.entity
 * @ClassName : .java
 * @createTime : 2022/9/28 17:54
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class Book {
    protected Integer id;
    protected String name;
    protected String description;
    protected Integer userId;
    protected BookType type;
    protected String extra;
    protected Integer delFlag;
    //添加图书的用户
    protected User user;
}
