package cn.icexmoon.books2.book.entity.dto;

import cn.icexmoon.books2.book.entity.enums.BookType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.entity.dto
 * @ClassName : .java
 * @createTime : 2022/10/27 14:31
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@NoArgsConstructor
public class BookQueryDTO {
    private Integer bookId;
    private String userName;
    private String bookName;
    private String desc;
    private List<BookType> types;
}
