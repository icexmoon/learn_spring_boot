package cn.icexmoon.books2.book.entity.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.book.entity.dto
 * @ClassName : .java
 * @createTime : 2022/10/22 16:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class BookDTO {
    private String name;
    private String description;
    private Integer userId;
    private Integer type;
    private String extra;
}
