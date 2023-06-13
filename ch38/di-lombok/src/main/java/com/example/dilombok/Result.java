package com.example.dilombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : di-lombok
 * @Package : com.example.dilombok
 * @ClassName : .java
 * @createTime : 2023/6/13 15:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
@RequiredArgsConstructor(staticName = "newInstance")
public class Result<T> {
    boolean success;
    @NonNull
    String errorCode;
    @NonNull
    String errorMsg;
    T data;
    private static final String DEFAULT_SUCCESS_CODE = "success";
    private static final String DEFAULT_FAIL_CODE = "fail";

    public static <D> Result<D> success(D data) {
        return newInstance(true, DEFAULT_SUCCESS_CODE, "", data);
    }

    public static Result<?> success() {
        return success(null);
    }

    public static Result<?> fail(String errorCode, String errorMsg) {
        return newInstance(false, errorCode, errorMsg, null);
    }
}
