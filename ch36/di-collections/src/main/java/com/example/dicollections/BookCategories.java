package com.example.dicollections;

import com.example.dicollections.entity.BookCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections
 * @ClassName : .java
 * @createTime : 2023/6/9 13:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@ConfigurationProperties(prefix = "my.book.categories")
@Getter
@Setter
public class BookCategories {
    private List<BookCategory> list;
}
