package com.example.lombok.entity;

import com.example.lombok.controller.BookCategoryController;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.entity
 * @ClassName : .java
 * @createTime : 2023/5/31 18:22
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class BookCategory {
    Long id;
    String name;
    String desc;

    public static BookCategory newInstance(BookCategoryController.AddCategoryDTO dto) {
        return new BookCategory(null, dto.getName(), dto.getDesc());
    }
}
