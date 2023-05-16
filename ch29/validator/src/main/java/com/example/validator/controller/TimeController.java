package com.example.validator.controller;

import com.example.validator.util.Result;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : validator
 * @Package : com.example.validator.controller
 * @ClassName : .java
 * @createTime : 2023/5/16 19:18
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/time")
public class TimeController {

    public TimeController(FormattingConversionService conversionService) {
        String converted = conversionService.convert(LocalDate.of(2023, 5, 16), String.class);
        System.out.println(converted);
        converted = conversionService.convert(LocalDateTime.of(2023,5,16,20,15), String.class);
        System.out.println(converted);
    }

    @GetMapping("")
    public String time(@RequestParam LocalDate date,
                       @RequestParam LocalDateTime time) {
        System.out.println(date);
        System.out.println(time);
        return Result.success().toString();
    }
}
