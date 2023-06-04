package com.example.lombok.controller;

import com.example.lombok.entity.BookCategory;
import com.example.lombok.system.Result;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok.controller
 * @ClassName : .java
 * @createTime : 2023/6/1 10:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/book/category")
@Log4j2
public class BookCategoryController {
    @Value
    public static class AddCategoryDTO {
        @NotBlank String name;
        @NotBlank String desc;
    }

    @PostMapping
    public Result<Object> addCategory(@Validated @RequestBody AddCategoryDTO addCategoryDTO) {
        System.out.println(addCategoryDTO);
        log.debug(addCategoryDTO);
        //用DTO生成POJO
        BookCategory bookCategory = BookCategory.newInstance(addCategoryDTO);
        System.out.println(bookCategory);
        //用POJO在持久层添加新的图书类别
        //这里省略持久层调用
        return Result.success();
    }
}
