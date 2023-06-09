package com.example.dicollections;

import com.example.dicollections.entity.Car;
import com.example.dicollections.entity.Motorcycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections
 * @ClassName : .java
 * @createTime : 2023/6/9 10:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
public class WebConfig {
    @Bean
    public Car bmp2() {
        return new Car("bmp2", "俄罗斯", "V8");
    }

    @Bean
    public Car t90() {
        return new Car("T-90", "俄罗斯", "V9");
    }

    @Bean
    public Car a99() {
        return new Car("99A", "中国", "V10");
    }

    @Bean
    public Motorcycle f90() {
        return new Motorcycle("f90", "9号电动车", true);
    }

    //文学
    //文学理论
//    @Bean
//    BookCategory literaryTheory() {
//        return new BookCategory("literary theory");
//    }
//
//    //外国文学
//    @Bean
//    BookCategory foreignLiterature() {
//        return new BookCategory("foreign literature");
//    }
//
//    //中国文学
//    @Bean
//    BookCategory chineseLiterature() {
//        return new BookCategory("chinese literature");
//    }
//
//    //历史
//    //中国历史
//    @Bean
//    BookCategory chineseHistory() {
//        return new BookCategory("chinese history");
//    }
//
//    //外国历史
//    @Bean
//    BookCategory foreignHistory() {
//        return new BookCategory("foreign history");
//    }
//
//    @Bean
//    List<BookCategory> defaultBookCategories(){
//        return List.of(chineseHistory(), foreignHistory());
//    }
}
