package cn.icexmoon.books2.book.entity;

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
    private Integer id;
    private String name;
    private String description;
    private Integer userId;
    private Integer type;
    private String extra;
    private Integer delFlag;
    //添加图书的用户
    private User user;
}
