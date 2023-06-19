package com.example.test;

import lombok.Value;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : test
 * @Package : com.example.test
 * @ClassName : .java
 * @createTime : 2023/6/19 17:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
public class Result<T> {
    boolean success;
    String code;
    String msg;
    T data;
    private static final String DEFAULT_SUCCESS_CODE = "success";
    private static final String DEFAULT_SUCCESS_MSG = "success";

    public static <D> Result<D> success(D data) {
        return new Result<>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, data);
    }
}
