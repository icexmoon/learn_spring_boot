package cn.icexmoon.demo.books.book.entity;

import cn.icexmoon.demo.books.book.entity.enums.BookType;
import cn.icexmoon.demo.books.book.entity.typehandler.BookExtraTypeHandler;
import cn.icexmoon.demo.books.user.entity.User;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "book", autoResultMap = true)
@Accessors(chain = true)
public class Book implements Serializable {
    @Data
    @NoArgsConstructor
    public static class Extra implements Serializable {
        public static Extra newInstance(String ISBN, String publisher) {
            Extra extra = new Extra();
            extra.setISBN(ISBN);
            extra.setPublisher(publisher);
            return extra;
        }

        private String Publisher;
        private String ISBN;
    }

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Integer userId;
    private BookType type;
    @TableField(typeHandler = BookExtraTypeHandler.class)
    private Extra extra;
    private Integer delFlag;
    @TableField(exist = false)
    private User user;
}
