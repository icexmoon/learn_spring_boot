package com.example.dicollections.system;

import lombok.Value;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-collections
 * @Package : com.example.dicollections.system
 * @ClassName : .java
 * @createTime : 2023/6/9 10:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value(staticConstructor = "newInstance")
public class Result<T> {
    boolean success;
    String errorCode;
    String errorMsg;
    private final static String DEFAULT_SUCCESS_CODE = "success";
    private final static String DEFAULT_FAIL_CODE = "fail.other";
    T data;

    public static Result<Object> success() {
        return Result.success(null);
    }

    public static <T> Result<T> success(T data) {
        return Result.newInstance(true, DEFAULT_SUCCESS_CODE, "", data);
    }

    public static Result<Object> fail(String errorCode, String errorMsg) {
        return Result.newInstance(false, errorCode, errorMsg, null);
    }

    public static Result<Object> fail(String errorMsg) {
        return Result.fail(DEFAULT_FAIL_CODE, errorMsg);
    }
}
