package com.example.dicollections.converter;

import com.example.dicollections.entity.BookCategory;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections.converter
 * @ClassName : .java
 * @createTime : 2023/6/9 12:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class StringToBookCategoryConverter implements Converter<String, BookCategory> {
    @Override
    public BookCategory convert(String source) {
        return new BookCategory(source);
    }
}
