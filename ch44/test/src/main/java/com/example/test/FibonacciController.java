package com.example.test;

import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 17:54
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/fibonacci")
@Validated
public class FibonacciController {
    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/{n}")
    public Result<Integer> fibonacci(@Min(1) @PathVariable("n") Integer n) {
        int result = fibonacciService.fibonacci(n);
        return Result.success(result);
    }
}
