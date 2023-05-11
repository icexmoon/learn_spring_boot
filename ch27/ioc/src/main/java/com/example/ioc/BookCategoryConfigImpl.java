package com.example.ioc;

import com.example.ioc.annotation.CategoryQualifier;
import com.example.ioc.web.BookCategory;
import com.example.ioc.web.BookCategoryEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/10 17:54
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BookCategoryConfigImpl {
    //文学
    //文学理论
    @CategoryQualifier(BookCategoryEnum.LITERATURE)
    @Bean
    default BookCategory literaryTheory(){
        return new BookCategory("literary theory");
    }

    //外国文学
    @CategoryQualifier(BookCategoryEnum.LITERATURE)
    @Bean
    default BookCategory foreignLiterature(){
        return new BookCategory("foreign literature");
    }

    //中国文学
    @Primary
    @CategoryQualifier(BookCategoryEnum.LITERATURE)
    @Bean
    default BookCategory chineseLiterature(){
        return new BookCategory("chinese literature");
    }

    //历史
    //中国历史
    @CategoryQualifier(BookCategoryEnum.HISTORY)
    @Bean
    default BookCategory chineseHistory(){
        return new BookCategory("chinese history");
    }

    //外国历史
    @CategoryQualifier(BookCategoryEnum.HISTORY)
    @Bean
    default BookCategory foreignHistory(){
        return new BookCategory("foreign history");
    }

    @Bean
    default List<BookCategory> literatureBookCategories(){
        return List.of(literaryTheory(), foreignLiterature(), chineseLiterature());
    }
}
