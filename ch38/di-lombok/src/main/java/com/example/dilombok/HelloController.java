package com.example.dilombok;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-lombok
 * @Package : com.example.dilombok
 * @ClassName : .java
 * @createTime : 2023/6/13 15:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/hello")
@Validated
public class HelloController {
    @Setter(onMethod = @__(@Autowired))
    private FibonacciService fibonacciService;
    private final Integer n = 10;

    @GetMapping
    public Result<?> hello(@RequestParam String n) {
        int numN;
        if ("null".equals(n)) {
            numN = this.n;
        } else {
            numN = Integer.parseInt(n);
        }
        if (numN < 1) {
            return Result.fail("hello.input.invalid", "n 不能小于 1");
        }
        int fibonacci = fibonacciService.fibonacci(numN);
        return Result.success(fibonacci);
    }
}
